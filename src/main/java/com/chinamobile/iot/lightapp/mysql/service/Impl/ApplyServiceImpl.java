package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dao.ApplyMapper;
import com.chinamobile.iot.lightapp.mysql.dao.UserMapper;
import com.chinamobile.iot.lightapp.mysql.dao.UserWorkcycleMapper;
import com.chinamobile.iot.lightapp.mysql.dao.WorkCycleMapper;
import com.chinamobile.iot.lightapp.mysql.dto.ApplyDTO;
import com.chinamobile.iot.lightapp.mysql.dto.ApplyResult;
import com.chinamobile.iot.lightapp.mysql.dto.ApplyResultDTO;
import com.chinamobile.iot.lightapp.mysql.model.*;
import com.chinamobile.iot.lightapp.mysql.response.ResponseCode;
import com.chinamobile.iot.lightapp.mysql.service.ApplyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The devices Service Impl.
 *
 * @author sxt
 * @since 2016.10.25
 */

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserWorkcycleMapper userWorkcycleMapper;

    @Autowired
    private WorkCycleMapper workCycleMapper;

    @Override
    public PageInfo<Apply> findApplys(Apply apply,Integer userId, Integer pageNum, Integer pageSize) {
        //查询用户所有的工作圈
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserWorkcycle> list = userWorkcycleMapper.selectByExample(userWorkcycleExample);
        List<Integer> workCycleList = new ArrayList<Integer>();
        if(list != null && list.size() > 0) {
            for(UserWorkcycle temp:list) {
                workCycleList.add(temp.getWorkCycleId());
            }
        }
        //查询工作圈信息(主要是名称)
        WorkCycleExample workCycleExample = new WorkCycleExample();
        WorkCycleExample.Criteria criteria1 = workCycleExample.createCriteria();
        criteria1.andWorkCycleIdIn(workCycleList);
        List<WorkCycle> workCycles = workCycleMapper.selectByExample(workCycleExample);
        Map<Integer, String> workCycleMap = workCycles.stream().collect(Collectors.toMap(WorkCycle::getWorkCycleId,WorkCycle::getWorkCycleName));

        //查询申请列表
        ApplyExample applyExample = new ApplyExample();
        ApplyExample.Criteria criteria2 = applyExample.createCriteria();
        criteria2.andCycleIdIn(workCycleList);
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<Apply>applyList = applyMapper.selectByExample(applyExample);
        return new PageInfo<Apply>(applyList);
    }

    @Override
    public Apply findApplyByApplyId(Integer applyId) {
        return applyMapper.selectByPrimaryKey(applyId);
    }

    @Override
    public int deleteByApplyId(Integer applyId) {
        return applyMapper.deleteByPrimaryKey(applyId);
    }

    @Override
    public int updateByApplyId(Apply apply) {
        Apply oldApply = applyMapper.selectByPrimaryKey(apply.getApplyId());
        if (oldApply == null) {
            return 4;
        }
        UserWorkcycle userWorkcycle = new UserWorkcycle();
        userWorkcycle.setUserId(oldApply.getApplyUser());
        userWorkcycle.setWorkCycleId(oldApply.getCycleId());
        userWorkcycle.setIsManager(Constant.CYCLE_MEMBER);
        userWorkcycleMapper.insert(userWorkcycle);
        applyMapper.updateByPrimaryKeySelective(apply);
        return 0;
    }

    @Override
    public ApplyResult insert(List<ApplyDTO> applyList) {
        ApplyResult applyResult = new ApplyResult();
        if (applyList != null && applyList.size() > 0) {
            List<ApplyResultDTO> list = new ArrayList<ApplyResultDTO>();
            for (ApplyDTO temp : applyList) {
                ApplyResultDTO applyResultDTO = new ApplyResultDTO();
                applyResultDTO.setCycleId(temp.getCycleId());
                applyResultDTO.setApplyUserPhone(temp.getApplyUserPhone());
                int result = addApply(temp);
                applyResultDTO.setResult(result);
            }
        }
        return applyResult;
    }

    //0-成功，1-用户不存在，2-工作圈不存在 3-用户已经在该工作圈内 4-申请不存在
    private int addApply(ApplyDTO applyDTO) {
        String phone = applyDTO.getApplyUserPhone();
        User user = findUserByPhone(phone);
        if (user == null) {
            return 1;
        }
        Integer workCycleId = applyDTO.getCycleId();
        Integer userId = user.getUserId();
        //判断工作圈是否存在
        WorkCycle workCycle = workCycleMapper.selectByPrimaryKey(workCycleId);
        if (workCycle == null) {
            return 2;
        }
        //判断用户是否在工作圈内
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andWorkCycleIdEqualTo(workCycleId).andUserIdEqualTo(userId);
        List<UserWorkcycle> list = userWorkcycleMapper.selectByExample(userWorkcycleExample);
        if (list != null && list.size() > 0) {
            return 3;
        }
        Apply apply = new Apply();
        apply.setApplyUser(user.getUserId());
        apply.setInviter(applyDTO.getInviter());
        apply.setApplyType(applyDTO.getApplyType());
        apply.setCycleId(workCycleId);
        applyMapper.insertSelective(apply);
        return 0;
    }

    public User findUserByPhone(String phone) {
        if (phone == null || phone.trim().length() == 0) {
            return null;
        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<User> list = userMapper.selectByExample(userExample);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}

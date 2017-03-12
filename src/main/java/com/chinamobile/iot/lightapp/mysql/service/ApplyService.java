package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.dto.ApplyDTO;
import com.chinamobile.iot.lightapp.mysql.dto.ApplyResult;
import com.chinamobile.iot.lightapp.mysql.model.Apply;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The devices service.
 *
 * @author sxt
 * @since 2016.10.25
 */
@Service
public interface ApplyService {


    /**
     * find applys.
     *
     * @param apply    the apply
     * @param userId   the user id
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the applys
     */
    public PageInfo<Apply> findApplys(Apply apply,Integer userId, Integer pageNum, Integer pageSize);

    /**
     * find apply by apply id.
     *
     * @param applyId the apply id
     * @return the apply by apply id
     */
    public Apply findApplyByApplyId(Integer applyId);

    /**
     * Delete by apply id int.
     *
     * @param applyId the apply id
     * @return the int
     */
    @Transactional
    public int deleteByApplyId(Integer applyId);

    /**
     * Update by apply id int.
     *
     * @param apply the apply
     * @return the int
     */
    @Transactional
    public int updateByApplyId(Apply apply);


    /**
     * Insert apply result.
     *
     * @param applyList the apply list
     * @return the apply result
     */
    ApplyResult insert(List<ApplyDTO> applyList);
}

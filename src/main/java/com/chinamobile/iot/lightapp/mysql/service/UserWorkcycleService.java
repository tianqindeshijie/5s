package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.model.User;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycle;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The devices service.
 *
 * @author sxt
 * @since 2016.10.25
 */
@Service
public interface UserWorkcycleService {

    /**
     * find userWorkcycles.
     *
     * @param userId      the user id
     * @param workCycleId the work cycle id
     * @param pageNum     the page num
     * @param pageSize    the page size
     * @return the userWorkcycles
     */
    public PageInfo<User> findUserWorkcycles(Integer userId, Integer workCycleId, Integer pageNum, Integer pageSize);

    /**
     * find userWorkcycle by userWorkcycle id.
     *
     * @param userWorkcycleId the userWorkcycle id
     * @return the userWorkcycle by userWorkcycle id
     */
    public UserWorkcycle findUserWorkcycleByUserWorkcycleId(Integer userWorkcycleId);

    /**
     * Delete by userWorkcycle id int.
     *
     * @param userId       the user id
     * @param deleteUserId the delete user id
     * @param workCycleId  the work cycle id
     * @return the int
     */
    @Transactional
    public int deleteByUserWorkcycleId(Integer userId,Integer deleteUserId,Integer workCycleId);

    /**
     * Update by userWorkcycle id int.
     *
     * @param userWorkcycle the userWorkcycle
     * @return the int
     */
    @Transactional
    public int updateByUserWorkcycleId(UserWorkcycle userWorkcycle);

    /**
     * Insert int.
     *
     * @param userWorkcycle the userWorkcycle
     * @return the int
     */
    @Transactional
    public int insert(UserWorkcycle userWorkcycle);
}

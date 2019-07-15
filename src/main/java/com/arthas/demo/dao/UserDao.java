package com.arthas.demo.dao;

import com.arthas.demo.bean.UserDO;

/**
 * @author linyang on 19/7/15.
 */
public interface UserDao {

    void insert(UserDO userDO);

    void modify(UserDO userDO);

    UserDO queryById(Long id);


}

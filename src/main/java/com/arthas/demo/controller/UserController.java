package com.arthas.demo.controller;

import com.arthas.demo.bean.UserDO;
import com.arthas.demo.dao.UserDao;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author linyang on 19/7/15.
 */
@RestController
public class UserController {

    @Resource
    private UserDao userDao;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Long create(@RequestBody UserDO userDO) {
        userDao.insert(userDO);
        return userDO.getId();
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    public UserDO query(@RequestParam Long id) {
        if (id == 63) {
            throw new RuntimeException("id不能为63");
        }
        return userDao.queryById(id);
    }
}

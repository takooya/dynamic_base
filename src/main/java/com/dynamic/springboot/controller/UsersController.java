package com.dynamic.springboot.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.dynamic.springboot.entity.UsersPO;
import com.dynamic.springboot.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.dynamic.springboot.constants.DataSourcePoolNameConstant.MASTER;
import static com.dynamic.springboot.constants.DataSourcePoolNameConstant.SLAVE_1;

/**
 * @author wangyichun
 * @since 2021/8/3 10:51
 */
@Slf4j
@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersMapper usersMapper;

    @GetMapping(MASTER)
    @DS("slave_1")
    public List<UsersPO> users3307() {
        return usersMapper.selectList(null);
    }

    @GetMapping(SLAVE_1)
    @DS("master")
    public List<UsersPO> users3308() {
        return usersMapper.selectList(null);
    }
}

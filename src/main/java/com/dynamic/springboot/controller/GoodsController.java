package com.dynamic.springboot.controller;

import com.dynamic.springboot.entity.GoodsPO;
import com.dynamic.springboot.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangyichun
 * @since 2021/8/3 10:51
 */
@Slf4j
@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsMapper goodsMapper;

    @GetMapping("master")
    public List<GoodsPO> goods3307() {
        return goodsMapper.selectList(null);
    }

    @GetMapping("slave_1")
    public List<GoodsPO> goods3308() {
        return goodsMapper.selectList(null);
    }
}

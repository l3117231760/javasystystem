package com.li.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.li.entity.Car;

import com.li.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarMapper extends BaseMapper<Car> {
    List<Car> listAll();

    IPage pageC(IPage<Car> index);

    IPage pageCC(IPage<Car> page, @Param(Constants.WRAPPER)LambdaQueryWrapper<Car> wrapper);


    IPage pageCR(IPage<Users> index, @Param(Constants.WRAPPER)LambdaQueryWrapper<Users> lambdaQueryWrapper1);
}

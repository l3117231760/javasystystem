package com.li.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.li.entity.Car;
import com.li.entity.Users;

import java.util.List;

public interface CarService extends IService<Car>  {
    List<Car> listAll();

    IPage pageC(IPage<Car> index);

    IPage pageCC(IPage<Car> index, LambdaQueryWrapper<Car> wrapper);


    IPage pageCR(IPage<Users> index, LambdaQueryWrapper<Users> lambdaQueryWrapper1);
}

package com.li.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.entity.Car;
import com.li.entity.Users;
import com.li.mapper.CarMapper;
import com.li.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService {

    @Resource
    private CarMapper carMapper;
    @Override
    public List<Car> listAll() {
        return carMapper.listAll();
    }

    @Override
    public IPage pageC(IPage<Car> index) {
        return carMapper.pageC(index);
    }

    @Override
    public IPage pageCC(IPage<Car> index, LambdaQueryWrapper<Car> wrapper) {
        return carMapper.pageCC(index,wrapper);
    }

    @Override
    public IPage pageCR(IPage<Users> index, LambdaQueryWrapper<Users> lambdaQueryWrapper1) {
        return carMapper.pageCR(index,lambdaQueryWrapper1);
    }
}

package com.li.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.entity.Orders;
import com.li.mapper.OrdersMapper;
import com.li.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;
    @Override
    public IPage pageOR(IPage<Orders> index, LambdaQueryWrapper<Orders> lambdaQueryWrapper) {
        return ordersMapper.pageOR(index,lambdaQueryWrapper);
    }
}

package com.li.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.li.entity.Orders;


public interface OrdersService extends IService<Orders> {
    IPage pageOR(IPage<Orders> index, LambdaQueryWrapper<Orders> lambdaQueryWrapper);
}

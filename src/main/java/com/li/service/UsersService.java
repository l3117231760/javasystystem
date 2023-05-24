package com.li.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.li.entity.Users;

public interface UsersService extends IService<Users> {


    IPage pageU(IPage<Users> index, LambdaQueryWrapper<Users> lambdaQueryWrapper1);
}

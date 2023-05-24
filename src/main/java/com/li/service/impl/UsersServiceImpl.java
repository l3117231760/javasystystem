package com.li.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.entity.Users;
import com.li.mapper.UsersMapper;
import com.li.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Resource
    private  UsersMapper usersMapper;
    @Override
    public IPage pageU(IPage<Users> index, LambdaQueryWrapper<Users> lambdaQueryWrapper1) {
        return usersMapper.pageU(index,lambdaQueryWrapper1);
    }
}

package com.li.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.li.entity.Dates;

import java.util.Date;

public interface DatesService extends IService<Date> {
    IPage pageCR(IPage<Dates> index, LambdaQueryWrapper<Dates> lambdaQueryWrapper1);
}

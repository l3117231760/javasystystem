package com.li.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.common.QueryPageParam;
import com.li.common.Result;
import com.li.entity.Car;
import com.li.entity.Users;
import com.li.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @GetMapping("/list")
    public List<Users> list()
    {
        return usersService.list();
    }
/*
{
        "userno":123,
        "username":"赵",
        "userpwd":"123",
        "userage":18,
        "userphone":123,
         "userisvalid":"N"
}
 */
    @PostMapping("/save")
    public Result save(@RequestBody Users users) {
        return usersService.save(users)==true?Result.success():Result.fail();
    }

    // 修改
    @PostMapping("/mod")
    public Boolean mod(@RequestBody Users users) {
        return usersService.updateById(users);
    }

    // 新增或修改
    @PostMapping("saveOrMod")
    public Boolean saveOrMod(@RequestBody Users users) {
        return usersService.saveOrUpdate(users);
    }

    @GetMapping("delete")
    public boolean delete(int id)
    {
        return usersService.removeById(id);
    }

    @PostMapping("/login")
    public Result login(@RequestBody Users users)
    {
        List list = usersService.lambdaQuery()
                .eq(Users::getUserno, users.getUserno())
                .eq(Users::getUserpwd, users.getUserpwd()).list();
        return list.size()>0?Result.success(list.get(0)):Result.fail();
    }
    @PostMapping("Search")
    public Result Search(@RequestBody Users users)
    {
        List list = usersService.lambdaQuery().eq(Users::getUserid,users.getUserid()).list();
        return list.size()>0?Result.success(list.get(0)):Result.fail();
    }
    @PostMapping("listpageC")
    public Result listpageC(@RequestBody QueryPageParam page)
    {
        /*
                {
           "pageSize" : 10,
           "pageNum" : 1,
           "param":{
                   "name" : "",
                    "type"  : ""
           }

        }
         */
        Page index = new Page(1,2);
        //当前页
        index.setCurrent(page.getPageNum());
        // 每页多少记录
        index.setSize(page.getPageSize());
        HashMap param = page.getParam();
        int id = (int)param.get("id");
        String type = (String)param.get("type");
        LambdaQueryWrapper<Users> lambdaQueryWrapper = new LambdaQueryWrapper();
        // like 模糊查询
        lambdaQueryWrapper.eq(Users::getUserid,id);
        lambdaQueryWrapper.like(Users::getUserisvalid,type);
        IPage result = usersService.page(index,lambdaQueryWrapper);
        System.out.println("Mytotal == " + result.getTotal());
        return result.getTotal()>0?Result.success():Result.fail();
    }
    @PostMapping("listpageR")
    public Result listpageR(@RequestBody QueryPageParam page)
    {

        Page index = new Page(1,5);
        //当前页
        index.setCurrent(page.getPageNum());
        // 每页多少记录
        index.setSize(page.getPageSize());
        HashMap param = page.getParam();
        String type = (String)param.get("name");
        LambdaQueryWrapper<Users> lambdaQueryWrapper1 = new LambdaQueryWrapper();
        // like 模糊查询
        if(StringUtils.isNotBlank(type)&& !"null".equals(type))
        {
            lambdaQueryWrapper1.like(Users::getUsername,type);
        }

        IPage result = usersService.pageU(index,lambdaQueryWrapper1);
        System.out.println("total == " + result.getTotal());
        return Result.success(result.getRecords(),result.getTotal());
    }
}

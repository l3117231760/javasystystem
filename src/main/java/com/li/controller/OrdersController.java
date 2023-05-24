package com.li.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.common.QueryPageParam;
import com.li.common.Result;
import com.li.entity.Orders;
import com.li.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersController {
    @Autowired
   private OrdersService ordersService;

    @GetMapping("list")
    public List<Orders> list()
    {
       return ordersService.list();
    }
    @PostMapping("saveOrMod")
    // json
    public Result saveOrMod(@RequestBody Orders orders) {

        return  ordersService.saveOrUpdate(orders)?Result.success():Result.fail();
    }
    @PostMapping("/listpage")
    public Result listpage(@RequestBody QueryPageParam page)
    {
//        System.out.println(page);
//        System.out.println("num == "+ page.getPageNum());
//        System.out.println("size == "+page.getPageSize());
//        HashMap param = page.getParam();
//        System.out.println("name == "+ param.get("name"));
//        System.out.println("no == "+ param.get("no"));



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
        LambdaQueryWrapper<Orders> lambdaQueryWrapper = new LambdaQueryWrapper();
        // like 模糊查询
        lambdaQueryWrapper.eq(Orders::getUserid,id);
        IPage result = ordersService.page(index,lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());
        return Result.success(result.getRecords(),result.getTotal());
    }
    @PostMapping("/save")
    public  Result save(@RequestBody Orders orders)
    {
        return ordersService.save(orders)==true?Result.success():Result.fail();
    }
    @PostMapping("/mod")
    public Result mod(@RequestBody Orders order)
    {
        return  ordersService.updateById(order)==true?Result.success():Result.fail();
    }

}

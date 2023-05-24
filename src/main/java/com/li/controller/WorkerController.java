package com.li.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.ChainQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.common.QueryPageParam;
import com.li.common.Result;
import com.li.entity.Car;
import com.li.entity.Users;
import com.li.entity.Worker;
import com.li.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @GetMapping("list")
    public List<Worker> list()
    {
        return  workerService.list();
    }
    @PostMapping("page")
    public Result listpage(@RequestBody QueryPageParam page)
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
        String name = (String)param.get("name");
        LambdaQueryWrapper<Worker> lambdaQueryWrapper = new LambdaQueryWrapper();
        // like 模糊查询
        lambdaQueryWrapper.like(Worker::getWorkname,name);
        IPage result = workerService.page(index,lambdaQueryWrapper);
        System.out.println("total==" + result.getTotal());
        return Result.success(result.getRecords(),result.getTotal());
    }
    @PostMapping("/save")
    public Result save(@RequestBody Worker worker) {
        return workerService.save(worker)==true?Result.success():Result.fail();
    }
    @GetMapping("delete")
    public boolean delete(int id)
    {
        return workerService.removeById(id);
    }


}

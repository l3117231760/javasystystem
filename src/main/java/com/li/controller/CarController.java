package com.li.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.common.QueryPageParam;
import com.li.common.Result;
import com.li.entity.Car;
import com.li.entity.Users;
import com.li.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
/*
*
* {
    "cid" : "2",
    "ctype" : "奔驰3",
    "cstatus" : "1",
    "cold" : "100",
    "cmoney" : "1100",
    "cdescription" : "无"
 }
*
* */
@RestController
@RequestMapping("/car")


public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/list")
    public List<Car> list()
    {
        // return  carService.list();
        return carService.listAll();
    }
    //保存
    @PostMapping("/save")
    public  Result save(@RequestBody Car car)
    {
        return carService.save(car)==true?Result.success():Result.fail();
    }
    //修改
    @PostMapping("/mod")
    public Result mod(@RequestBody Car car)
    {
        return  carService.updateById(car)==true?Result.success():Result.fail();
    }
    //新增或者修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody Car car)
    {
        return carService.saveOrUpdate(car);
    }
    //删除
    @GetMapping("delete")
    public boolean delete(int id)
    {
        return carService.removeById(id);
    }
    //查询(模糊匹配)
    @PostMapping("listp")
   // public List<Car> listp(@RequestBody Car car)
    public Result listp(@RequestBody Car car)
    {
        LambdaQueryWrapper<Car> lambdaQueryWrapper = new LambdaQueryWrapper();
        // like 模糊查询
        if(StringUtils.isNotBlank(car.getCtype()))
        {
            lambdaQueryWrapper.like(Car::getCtype,car.getCtype());
        }
        // 相等查询
//      lambdaQueryWrapper.eq(Car::getCtype,car.getCtype());
        return Result.success(carService.list(lambdaQueryWrapper));
    }
    // 以下全部都是分页查询
  //  @PostMapping("listpage")
    //public List<Car> listpage(@RequestBody HashMap map)
    /*
      * {
       "pageSize" : 10,
       "pageNum" : 1,
       "name" : "abc"
        }
    * */
//    public List<Car> listpage(@RequestBody QueryPageParam page)
//    {
////        System.out.println(page);
////        System.out.println("num == "+ page.getPageNum());
////        System.out.println("size == "+page.getPageSize());
////        HashMap param = page.getParam();
////        System.out.println("name == "+ param.get("name"));
////        System.out.println("no == "+ param.get("no"));
//
//
//
//        /*
//                {
//           "pageSize" : 10,
//           "pageNum" : 1,
//           "param":{
//                   "name" : "",
//                    "type"  : ""
//           }
//
//        }
//         */
//
//         Page index = new Page(1,2);
//         //当前页
//         index.setCurrent(page.getPageNum());
//         // 每页多少记录
//         index.setSize(page.getPageSize());
//        HashMap param = page.getParam();
//        String type = (String)param.get("type");
//        LambdaQueryWrapper<Car> lambdaQueryWrapper = new LambdaQueryWrapper();
//        // like 模糊查询
//        lambdaQueryWrapper.like(Car::getCtype,type);
//        IPage result = carService.page(index,lambdaQueryWrapper);
//        System.out.println("total==" + result.getTotal());
//        return result.getRecords();
//    }
    @PostMapping("listpageC")
    public List<Car> listpageC(@RequestBody QueryPageParam page)
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
        String type = (String)param.get("type");
//        LambdaQueryWrapper<Car> lambdaQueryWrapper = new LambdaQueryWrapper();
//        // like 模糊查询
//        lambdaQueryWrapper.like(Car::getCtype,type);

        IPage result = carService.pageC(index);
        System.out.println("total == " + result.getTotal());
        return result.getRecords();
    }

    @PostMapping("listpageCC")
    public List<Car> listpageCC(@RequestBody QueryPageParam page)
    {

        Page index = new Page(1,2);
        //当前页
        index.setCurrent(page.getPageNum());
        // 每页多少记录
        index.setSize(page.getPageSize());
        HashMap param = page.getParam();
        String type = (String)param.get("type");
        LambdaQueryWrapper<Car> lambdaQueryWrapper1 = new LambdaQueryWrapper();
        // like 模糊查询
        lambdaQueryWrapper1.like(Car::getCtype,type);

        IPage result = carService.pageCC(index,lambdaQueryWrapper1);
        System.out.println("total == " + result.getTotal());
        return result.getRecords();
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
        String type = (String)param.get("type");
        LambdaQueryWrapper<Car> lambdaQueryWrapper1 = new LambdaQueryWrapper();
        // like 模糊查询
        if(StringUtils.isNotBlank(type)&& !"null".equals(type))
        {
            lambdaQueryWrapper1.like(Car::getCtype,type);
        }

        IPage result = carService.pageCC(index,lambdaQueryWrapper1);
        System.out.println("total == " + result.getTotal());
        return Result.success(result.getRecords(),result.getTotal());
    }
    @PostMapping("listpageRC")
    public Result listpageReCar(@RequestBody QueryPageParam page)
    {

        Page index = new Page(1,2);
        //当前页
        index.setCurrent(page.getPageNum());
        // 每页多少记录
        index.setSize(page.getPageSize());
        HashMap param = page.getParam();
        Integer id = (Integer)param.get("id");
        LambdaQueryWrapper<Users> lambdaQueryWrapper1 = new LambdaQueryWrapper();
        lambdaQueryWrapper1.eq(Users::getUserid,id);
        IPage result = carService.pageCR(index,lambdaQueryWrapper1);
        System.out.println("total == " + result.getTotal());
        return Result.success(result.getRecords(),result.getTotal());
    }



}

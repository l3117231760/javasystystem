package com.li.common;

import lombok.Data;

@Data
public class Result {
    private int code; // 200成功 400失败
    private String msg; // 成功或者失败
    private Long total; // 总记录数
    private Object data;

    // 失败
    public static  Result fail()
    {
        return result(0,"失败",0L,null);
    }
    // 成功
    public static  Result success()
    {
        return result(1,"成功",0L,null);
    }
    public static  Result success(Object data)
    {
        return result(1,"成功",0L,data);
    }
    public static  Result success(Object data,Long total)
    {
        return result(1,"成功",total,data);
    }

    private static  Result result(int code,String msg,long total,Object data)
    {
        Result res = new Result();
        res.setData(data);
        res.setCode(code);
        res.setMsg(msg);
        res.setTotal(total);
        return res;
    }
}

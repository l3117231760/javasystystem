package com.li.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Orders {
    @TableId
    public int orderid;
    // 租车人id
    public int userid;
    // 车的id
    public int cid;
    // 租车时间
    public int hour;
    // 订单状态 1 表示已经结束
    public int orderstatus = 1;
    // 租车人姓名
    public String username;
    // 车类型
    public String ctype;
    //租借时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    public Date renttime;
    //归还时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    public Date returntime;
}

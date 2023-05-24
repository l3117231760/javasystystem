package com.li.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Car {
    @TableId
    public int cid;
    public String ctype;
    public  int cstatus = 1;
    public int cold;
    public  int cmoney;
    public String cdescription;
}

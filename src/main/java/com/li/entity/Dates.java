package com.li.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Dates {
    @TableId
    public int cid;

    public int userid;
    public String ctype;
    public  int cstatus = 1;
    public int cold;
    public  int cmoney;
    public String cdescription;
    public int orderid;
}

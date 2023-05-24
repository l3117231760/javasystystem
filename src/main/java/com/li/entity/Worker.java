package com.li.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
//CREATE TABLE `worker` (
//        `workno` int(30) NOT NULL AUTO_INCREMENT,
//        `workname` varchar(30) NULL NULL,
//        `worksalar` int(11) Not NULL,
//        `workage` int(11) DEFAULT NULL,
//        `worktype` varchar(30) DEFAULT NULL,
//        `workBlankID` int(11) NOT NULL,
//        `workisvalid` varchar(30) DEFAULT 'Y',
//        PRIMARY KEY (`workno`)
//        ) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
@Data
public class Worker {
    @TableId
    public int workno;

    // 姓名
    public  String workname;
    // 薪水
    public int worksalar;
    // 年龄
    public int workage;
    // 工作类型
    public String worktype;
    // 银行卡卡号(唯一)
    public int workblankid;
}

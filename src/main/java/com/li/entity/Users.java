package com.li.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Users {
    @TableId
    public int userid;

    // 账号
    public String userno;
    // 用户的名字
    public String username;
    // 密码
    public String userpwd;
    // 年龄
    public int userage;
    // 手机号
    public String userphone;
    // 数据是否有效
    public String userisvalid;
}

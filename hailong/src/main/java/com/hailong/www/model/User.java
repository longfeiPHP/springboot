package com.hailong.www.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId(type = IdType.AUTO)/*主键自增*/
    private Integer id;/*主键id*/
    private String name;/*姓名*/
    private Integer age;/*年龄*/
    private String email;/*邮箱*/
    private Integer created;/*创建时间*/
    private Integer updated;/*更新时间*/
}

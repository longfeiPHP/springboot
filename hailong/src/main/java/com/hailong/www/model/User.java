package com.hailong.www.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId(type = IdType.AUTO)/*主键自增*/
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}

package com.hailong.www.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    @TableId(type = IdType.AUTO)/*主键自增*/
    private Integer id;/*主键id*/
    private String name;/*姓名*/
    private Integer age;/*年龄*/
    private String email;/*邮箱*/
    private Integer created;/*创建时间*/
    private Integer updated;/*更新时间*/
}

package com.hailong.www.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person")/*和配置文件 person 前辍进行绑定*/
@Data /*自动生成javaBean 的getter/setter*/
//@NoArgsConstructor /*自动生成无参数构造器*/
//@AllArgsConstructor /*自动生成全参构造器*/
//@JacksonXmlRootElement
public class Person {
    private String name;
    private Integer age;
    private Date birthday;
    private Boolean like;
    private Child child;
    private List<Dog> dogs;
    private Map<String, Cat> cats;
}

package com.hailong.www;

import com.hailong.www.model.Person;
import com.hailong.www.model.Pig;
import com.hailong.www.model.Sheep;
import com.hailong.www.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hailong.www.mapper")
public class HailongApplication {

	public static void main(String[] args) {
		var ioc = SpringApplication.run(HailongApplication.class, args);
//		for (String beanDefinitionName : ioc.getBeanDefinitionNames()) {
//			System.out.println(beanDefinitionName);
//		}
//		for (String s : ioc.getBeanNamesForType(User.class)) {
//			System.out.println(s);
//		}
//		var pig = ioc.getBean(Pig.class);
//		System.out.println(pig);

//		var sheep  = ioc.getBean(Sheep.class);
//		System.out.println(sheep);
//		var person = ioc.getBean(Person.class);
//		System.out.println(person);
	}

}

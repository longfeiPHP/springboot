package com.hailong.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hailong.www.mapper")
public class HailongApplication {

	public static void main(String[] args) {
		SpringApplication.run(HailongApplication.class, args);
	}

}

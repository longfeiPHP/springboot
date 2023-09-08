package com.hailong.www;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HailongApplicationTests {

	@DisplayName("测试1")
	@Test
	void contextLoads() {
//		System.out.println("test");
		/*断言*/
		Assertions.assertEquals(1,1);
	}

}

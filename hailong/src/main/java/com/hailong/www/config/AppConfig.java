package com.hailong.www.config;

import com.hailong.www.model.Pig;
import com.hailong.www.model.Sheep;
import com.hailong.www.model.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(User.class)
@SpringBootConfiguration
@EnableConfigurationProperties(Sheep.class) /*加放ioc容器*/
public class AppConfig {

    @Bean
    public User user01() {
        var user = new User();
        user.setId(10);
        user.setName("abc");
        return user;
    }

    @ConfigurationProperties(prefix = "pig")
    @Bean
    public User user02() {
        var user = new User();
        user.setId(11);
        user.setName("def");
        return user;
    }

    @Bean
    public Pig pig() {
        return new Pig();
    }
}

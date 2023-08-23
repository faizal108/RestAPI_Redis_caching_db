package com.faizal.RestAPI_Redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RestApiRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiRedisApplication.class, args);
	}

}

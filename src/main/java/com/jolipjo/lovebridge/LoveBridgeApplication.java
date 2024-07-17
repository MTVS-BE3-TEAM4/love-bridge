package com.jolipjo.lovebridge;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@MapperScan(basePackages = "com.jolipjo.lovebridge.domain.*", annotationClass = Mapper.class)
public class LoveBridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveBridgeApplication.class, args);
	}

}

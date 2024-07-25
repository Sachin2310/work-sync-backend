package com.task.credmarg.worksync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WorksyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorksyncApplication.class, args);
	}

}

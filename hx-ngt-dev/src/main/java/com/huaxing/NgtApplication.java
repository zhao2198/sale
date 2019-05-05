package com.huaxing;

import com.huaxing.modules.autoconfigure.jdbc.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ DynamicDataSourceRegister.class })
@EnableEurekaClient
public class NgtApplication {


//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(NgtApplication.class);
//	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(NgtApplication.class, args);
	}
}

package com.sachith.els;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class ElsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElsApplication.class, args);
	}

}

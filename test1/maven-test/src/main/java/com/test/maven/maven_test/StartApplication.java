package com.test.maven.maven_test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}


	@Bean
	CommandLineRunner initDatabase(ModuleRepository repository) {
		return args -> {
			repository.save(new Module("PromoCard",new Long("1")));
			repository.save(new Module("CategoryCard",new Long("2")));
			repository.save(new Module("FlashSaleCard",new Long("3")));
			repository.save(new Module("HistoryCard",new Long("4")));
			repository.save(new Module("NewsCard",new Long("5")));

		};

	}
}

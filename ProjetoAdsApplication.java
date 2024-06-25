package com.projeto.ads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan(basePackages= "com.projeto.ads")
@ComponentScan(basePackages= "com.projeto.ads")
@EnableJpaRepositories (basePackages= "com.projeto.ads.repository")
@EnableTransactionManagement
@EnableAutoConfiguration
@SpringBootApplication
public class ProjetoAdsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjetoAdsApplication.class, args);
	}
}

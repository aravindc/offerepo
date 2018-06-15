package com.ara.app;

import com.ara.model.Offer;
import com.ara.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EntityScan(basePackageClasses= {Offer.class,Product.class})
@ComponentScan(basePackages = {"com.ara.controller","com.ara.search","com.ara.service"})
@EnableJpaRepositories("com.ara.repository")
public class offerepo {
    public static void main(String[] args) {
        SpringApplication.run(offerepo.class);
    }
}

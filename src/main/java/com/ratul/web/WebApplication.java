package com.ratul.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ratul.web.entities.User;


@SpringBootApplication
public class WebApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}

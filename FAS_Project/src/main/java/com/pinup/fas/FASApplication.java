package com.pinup.fas;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import oracle.jdbc.pool.OracleDataSource;

@ConfigurationProperties("spring.datasource")
@SpringBootApplication
public class FASApplication {
	
	private String username;
	private String password;
	private String url;
	
	public static void main(String[] args) {
		SpringApplication.run(FASApplication.class, args);
		System.out.println("Hello World!");
	}
	
	@Bean
	DataSource dataSource() throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setURL(url);
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setConnectionCachingEnabled(true);
		return dataSource;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}

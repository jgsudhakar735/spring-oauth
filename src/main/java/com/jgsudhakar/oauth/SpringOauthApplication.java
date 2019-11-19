package com.jgsudhakar.oauth;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.jgsudhakar.oauth.flyway.FlywayConfiguration;

@SpringBootApplication
public class SpringOauthApplication {
	
	@Value("${spring.datasource.driver-class-name}")
	public String driverClassName;

	@Value("${spring.datasource.url}")
	public String connectionUrl;

	@Value("${spring.datasource.username}")
	public String dbUserName;

	@Value("${spring.datasource.password}")
	public String dbPassword;

	public static void main(String[] args) {
		SpringApplication.run(SpringOauthApplication.class, args);
	}

	@DependsOn("dataSource")
	@Bean
	Flyway initFlyway() throws Exception {
		FlywayConfiguration flywayConfiguration = new FlywayConfiguration();
		flywayConfiguration.setDataSource(dataSource());
		flywayConfiguration.version();
		return flywayConfiguration;
	}

	@Bean
	public DataSource dataSource() throws Exception {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUsername(dbUserName);
		ds.setPassword(dbPassword);
		ds.setUrl(connectionUrl);
		return ds;
	}
}

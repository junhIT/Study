package com.example.springbase.h2;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * H2 DataBase 초기화 클래스
 * 2022.11.25 
 * @author JunHi
 */
@Slf4j
@Component
public class H2Runner implements ApplicationRunner{
	private DataSource dataSource;
	
	public H2Runner(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try(Connection connection = dataSource.getConnection()) {
			log.debug("================================ DataSource Connection Success");

			Statement statement = connection.createStatement();
			String sql = "CREATE TABLE USERS(id INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY(id))";
			statement.executeUpdate(sql);
			log.debug("================================ DataSource CREATE TABLE SUCCESS");
		} 
	}
}

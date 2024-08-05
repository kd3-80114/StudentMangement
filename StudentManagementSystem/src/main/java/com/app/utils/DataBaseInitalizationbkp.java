package com.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//@Component
public class DataBaseInitalizationbkp {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@EventListener(ApplicationReadyEvent.class)
	public void initializeDatabase() {
		if (!checkIfAdminExists()) {
			createAdmin();
		}
		
	}

	private void createAdmin() {
		
		jdbcTemplate.execute(
				"INSERT INTO sign_in (id,email,password,user_role) values (1895235,'patelshrinit@gmail.com','$2a$10$nAqY2tdqotLPgvF1DKf.uOfgpY0mpgFwtk3Bloc5mZpx7MYZMMQea','ROLE_ADMIN')");
		
	
		jdbcTemplate.execute(
				"INSERT INTO admin (contact_no,email,fname,lname,password,sign_in) values ('9730808232','patelshrinit@gmail.com','shrinit','patel','$2a$10$nAqY2tdqotLPgvF1DKf.uOfgpY0mpgFwtk3Bloc5mZpx7MYZMMQea',1895235)");
		
	}

	private boolean checkIfAdminExists() {
		if (jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM admin",
				Integer.class) > 0) {
			return true;
		}
		return false;
	}




}
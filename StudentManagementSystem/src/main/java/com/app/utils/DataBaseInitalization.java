package com.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class DataBaseInitalization {
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
				"INSERT INTO sign_in (email,password,user_role) values ('patelshrinit@gmail.com','$2a$10$XwBgnXI.a1kJaD9STOwpdO4jDJ6IDE6wXIChXD4uAz.qxtt0Y7GYy','ROLE_ADMIN')");
		
	
		jdbcTemplate.execute(
"INSERT INTO admin (contact_no, email, fname, lname, password, sign_in) VALUES ('9730808232', 'patelshrinit@gmail.com', 'shrinit', 'patel', '$2a$10$XwBgnXI.a1kJaD9STOwpdO4jDJ6IDE6wXIChXD4uAz.qxtt0Y7GYy', (SELECT id FROM sign_in WHERE email = 'patelshrinit@gmail.com'));");		
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
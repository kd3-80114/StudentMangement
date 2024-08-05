package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
@Table(name = "signIn")
public class SignIn extends BaseEntity {
	@Column(length = 50,unique = true)
	private String email;
	@Column(length = 300, nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private RoleType userRole;
}

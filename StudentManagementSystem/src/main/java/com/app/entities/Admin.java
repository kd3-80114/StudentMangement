package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
public class Admin extends BaseEntity implements User {
	@Column(name = "fname", length = 50)
	private String firstName;
	@Column(name = "lname", length = 50)
	private String lastName;
	@Column(length = 50, unique = true)
	private String email;
	@Column(name = "password", length = 500)
	private String password;
	@Column(length = 15, unique = true)
	private String contactNo;
	@JsonIgnore
	@ToString.Exclude
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "signIn", nullable = true)
	private SignIn signIn;
}

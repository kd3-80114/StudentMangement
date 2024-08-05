package com.app.entities;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
public class Student extends BaseEntity implements User,Comparable<Student>{
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
	 @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "student_subject",
	        joinColumns = @JoinColumn(name = "student_id"),
	        inverseJoinColumns = @JoinColumn(name = "subject_id"))
	 @JsonIgnore
	    private Set<Subject> subjects;
	 @JsonIgnore
		@ToString.Exclude
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "signIn", nullable = true)
		private SignIn signIn;
	@Override
	public int compareTo(Student student) {
		
		if(student.getFirstName().compareTo(this.firstName)==0)
		{
			return 0;
		}
		else if(student.getFirstName().compareTo(this.firstName)>0)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	 
	

}

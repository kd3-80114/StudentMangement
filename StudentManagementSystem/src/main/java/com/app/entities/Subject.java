package com.app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Subject extends BaseEntity implements Comparable<Subject>{

	    private String name;

	    @ManyToMany(mappedBy = "subjects")
	    private Set<Student> students;

		@Override
		public int compareTo(Subject subject) {
				
				if(subject.getName().compareTo(this.name)==0)
				{
					return 0;
				}
				else if(subject.getName().compareTo(this.name)>0)
				{
					return 1;
				}
				else
				{
					return -1;
				}
			
		}
	    
	    
	    
	    
}

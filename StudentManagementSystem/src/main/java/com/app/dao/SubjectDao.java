package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Subject;

public interface SubjectDao extends JpaRepository<Subject, Long> {

}

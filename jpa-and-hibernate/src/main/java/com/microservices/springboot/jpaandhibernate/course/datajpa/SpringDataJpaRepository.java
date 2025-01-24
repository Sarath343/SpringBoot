package com.microservices.springboot.jpaandhibernate.course.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.springboot.jpaandhibernate.course.Course;

public interface SpringDataJpaRepository extends JpaRepository<Course,Long > {

	public Course findByName(String name);
	
}

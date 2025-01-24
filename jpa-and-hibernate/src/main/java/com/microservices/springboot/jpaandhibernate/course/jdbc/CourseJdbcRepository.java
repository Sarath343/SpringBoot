package com.microservices.springboot.jpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	private static String insert_query ="Insert into course (id, name,author)  values (1,'course1','auth1')"; ; 
	
	
	public void insert() {
		springJdbcTemplate.update(insert_query) ;
	}
}

package com.microservices.springboot.jpaandhibernate.course.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.microservices.springboot.jpaandhibernate.course.Course;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);
	}

	public Course fetchById(long id) {
		return entityManager.find(Course.class, id);
	}

	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
		
	}
	//for fetching all rows , either rely on creating query or rely on spring-data-jpa
	public List<Course> fetchAllCourses(){
		return entityManager.createQuery("select e from Course e").getResultList();
	}
}

package com.microservices.springboot.jpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.microservices.springboot.jpaandhibernate.course.datajpa.SpringDataJpaRepository;
import com.microservices.springboot.jpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.microservices.springboot.jpaandhibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
	//Spring jdbc
//	@Autowired
//	CourseJdbcRepository repository ; 
//	
//	@Override
//	public void run(String... args) throws Exception {
//		repository.insert();
//	}
	
	
	
	//jpa
//	@Autowired
//	CourseJpaRepository jpaRepository;
//	
//	@Override
//	public void run(String...   args) throws Exception{
//		jpaRepository.insert(new Course(1,"course1","author1"));
//		jpaRepository.insert(new Course(2,"course2","author2"));
//		jpaRepository.insert(new Course(3,"course3","author3"));
//		jpaRepository.insert(new Course(4,"course4","author4"));
//
//		System.out.println(jpaRepository.fetchById(2)) ;
//		jpaRepository.deleteById(3);
//		System.out.println(jpaRepository.fetchAllCourses());
//	}

	
	//spring-data-jpa
	@Autowired
	SpringDataJpaRepository dataJpaRepo;
	@Override
	public void run(String...   args) throws Exception{
		dataJpaRepo.save(new Course(1,"course1","author1"));
		dataJpaRepo.save(new Course(2,"course2","author2"));
		dataJpaRepo.save(new Course(3,"course3","author3"));
		dataJpaRepo.save(new Course(4,"course4","author4"));
		
		System.out.println(dataJpaRepo.findById(3L));
		dataJpaRepo.deleteById(2L);
		System.out.println(dataJpaRepo.findByName("course4"));
		System.out.println("----------");
		System.out.println(dataJpaRepo.findAll());
		System.out.println(dataJpaRepo.findByName("wddw"));

	}
	
}

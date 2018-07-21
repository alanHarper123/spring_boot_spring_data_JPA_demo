package com.qiujintao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qiujintao.model.Person;
import com.qiujintao.service.PersonService;

@SpringBootApplication
public class SpringBootSpringDataJpaDemoApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootSpringDataJpaDemoApplication.class);

	
	@Autowired
	private PersonService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSpringDataJpaDemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Current objects in DB: {}",service.countPersons());
		Person person = service.createPerson(new Person("shubham",23));
		log.info("Person created in DB: {}",person);
		log.info("Current objects in DB: {}",service.countPersons());
		person.setName("Programmer");
		Person editedPerson = service.editPerson(person);
		log.info("Person created in DB: {}",editedPerson);
		
		service.deletePerson(person);
		log.info("After deletion, count: {}",service.countPersons());
		
	}
}

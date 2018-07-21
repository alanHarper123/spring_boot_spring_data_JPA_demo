package com.qiujintao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.qiujintao.model.Person;
import com.qiujintao.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository repository;
	
	public Person createPerson(Person person) {
		return repository.save(person);
	}
	public Person getPerson(Long id) {
		return repository.getOne(id);
	}
	public Person editPerson(Person person) {
		return repository.save(person);
	}
	public void deletePerson(Person person) {
		repository.delete(person);
	}
	public List<Person> getAllPersons(int pageNumber, int pageSize){
		return repository.findAll(new PageRequest(pageNumber, pageSize)).getContent();
	}
	public List<Person> getAllPersons(){
		return repository.findAll();
	}
	public long countPersons() {
		return repository.count();
	}
}

package com.qiujintao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qiujintao.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}

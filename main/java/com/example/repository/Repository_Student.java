package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.StudentClass;

@Repository
public interface Repository_Student extends CrudRepository<StudentClass, Integer>{

}

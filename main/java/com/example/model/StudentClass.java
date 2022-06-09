package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class StudentClass {

@Id
 private Integer id;
 private String name;
 private Integer marks;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getMarks() {
	return marks;
}
public void setMarks(Integer marks) {
	this.marks = marks;
}
public StudentClass(Integer id, String name, Integer marks) {
	super();
	this.id = id;
	this.name = name;
	this.marks = marks;
}
public StudentClass() {
	super();
}


 
 
}

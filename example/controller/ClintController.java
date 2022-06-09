package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class ClintController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/all")
	public ResponseEntity<List<StudentClass>> getAllData() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<StudentClass> entity = new HttpEntity<StudentClass>(headers);

		ResponseEntity object = restTemplate.exchange("http://localhost:8080/student/get", HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<StudentClass>>() {
				});
		System.out.println(object.getBody());
		return object;

	}

	@PostMapping("/save")
	public String saveStudentData(@RequestBody StudentClass studentA) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity entity = new HttpEntity<StudentClass>(studentA, headers);
		restTemplate.exchange("http://localhost:8080/student/save", HttpMethod.POST,
				entity, StudentClass.class);

		return  "record saved successfully....";
	}

	@PutMapping("/update/{id}")
	public String updateStudentData(@PathVariable Integer id, @RequestBody StudentClass StudentB) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<StudentClass> entity = new HttpEntity<StudentClass>(StudentB, headers);
		ResponseEntity<StudentClass> detailsSave = restTemplate.exchange("http://localhost:8080/student/update/" + id,
				HttpMethod.PUT, entity, StudentClass.class);
		return "record updated successfully....";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudentData(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<StudentClass> entity = new HttpEntity<StudentClass>(headers);
		ResponseEntity<StudentClass> detailsSave = restTemplate.exchange("http://localhost:8080/student/delete/" + id,
				HttpMethod.DELETE, entity, StudentClass.class);
		return "record deleted successfully....";
	}

}

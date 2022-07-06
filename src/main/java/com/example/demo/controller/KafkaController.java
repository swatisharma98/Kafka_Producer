package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
@RequestMapping("kafka")
public class KafkaController {

	@Autowired
	KafkaTemplate<String,User> kafkaTemplate;
	
	private static final String TOPIC ="test";
	
	@GetMapping("publish/{message}")
	public String post(@PathVariable("message") final String name) {
		
		kafkaTemplate.send(TOPIC,new User(name,"Tech"));
		return "Published Successfully";
	}
}

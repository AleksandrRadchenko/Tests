package spring_annotation_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_annotation_test.model.User;

@RestController
@RequestMapping("/rest")
public class Controller
{
	@GetMapping("/getUser")
	public User getUser() {
		return new User("Den");
	}
}

package com.SpringBlood.SpringBloodApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBlood.SpringBloodApplication.Service.LoginService; 

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService service;
	//login with email and password and get full name
	@GetMapping("/search/{email}/{password}")
	public List<Object> searchByEmailPass(@PathVariable(value="email") String email,@PathVariable(value="password") String password)
	{
		System.out.println(email);
		return service.serviceLogin(email,password);
	}
}

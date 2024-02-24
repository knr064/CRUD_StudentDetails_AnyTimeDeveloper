package com.SpringBlood.SpringBloodApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBlood.SpringBloodApplication.Repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository repository;
	public java.util.List<Object> serviceLogin(String email,String password)
	{
		return repository.loginRepository(email,password);
	}
}

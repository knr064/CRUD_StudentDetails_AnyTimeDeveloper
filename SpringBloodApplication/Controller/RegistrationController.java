package com.SpringBlood.SpringBloodApplication.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBlood.SpringBloodApplication.Entity.RegistrationEntity;
import com.SpringBlood.SpringBloodApplication.Service.RegistrationService;
import com.SpringBlood.SpringBloodApplication.customExceptions.ResourseNotFoundException;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	@Autowired
	private RegistrationService service;
	
	
	@PostMapping("/postMethod")
	public RegistrationEntity toSaveData(@Valid @RequestBody RegistrationEntity es)
	{
		return service.serviceMethodToCallRepository(es);
	}
	
	
	@GetMapping("/getMethod")
	public List<RegistrationEntity> getData()
	{
		return service.getDataFromDatabase();
		
	}
	
	@GetMapping("/getMethod/{id}")
	public ResponseEntity<RegistrationEntity> getDataByblood(@PathVariable(value="id") long id)throws ResourseNotFoundException
	{
		RegistrationEntity data=service.getDataFromRegistrationByBlood(id).orElseThrow(()->new ResourseNotFoundException("there is no data available with "+id));
		//return (List<RegistrationEntity>) data;
		return ResponseEntity.ok().body(data);
		
	}
	//getting all details based on bloodGroup
	@GetMapping("/search/{bloodGroup}")
	public ResponseEntity<List<RegistrationEntity>> search(@PathVariable(value="bloodGroup") String bloodGroup)
	{
		System.out.println(bloodGroup);
		return ResponseEntity.ok(service.search(bloodGroup));
	}
	//getting full name and mail id based on bloodgroup
	@GetMapping("/search2/{bloodGroup}")
	public List<Object> search2(@PathVariable(value="bloodGroup") String bloodGroup, RegistrationEntity es)
	{
		System.out.println(bloodGroup);
		System.out.println(es.getFullName());
		return service.search2(bloodGroup);
	}
	
	//getting full name based on email
	@GetMapping("/search4/{Email}")
	public List<Object> searchEmail(@PathVariable(value="Email") String Email)
	{
		return service.searchEmailService(Email);
	}
}

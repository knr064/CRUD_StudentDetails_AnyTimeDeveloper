package com.SpringBlood.SpringBloodApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.SpringBlood.SpringBloodApplication.Entity.RegistrationEntity;
import com.SpringBlood.SpringBloodApplication.Repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repository;
	public RegistrationEntity serviceMethodToCallRepository(RegistrationEntity es)
	{
		return repository.save(es);
	}
	
	public List<RegistrationEntity>getDataFromDatabase()
	{
		return repository.findAll();
	}
	
	public Optional<RegistrationEntity>getDataFromRegistrationByBlood(long id)
	{
		return repository.findById(id);
	}
	
	
	//calling repository query and getting all columns based on bloodgroup
	public List<RegistrationEntity> search(String bloodGroup)
	{
		List<RegistrationEntity> data=repository.search(bloodGroup);
		return data;
	}
	
	//calling repository method and getting fullname,mail based on bloodgroup
	public List<Object> search2(String bloodGroup)
	{
		
		return repository.search2(bloodGroup);
	}
	
	
	
	//calling repository method to get fullname based on email
	public List<Object>searchEmailService(String Email)
	{
		return repository.searchEmailRepo(Email);
	}
}

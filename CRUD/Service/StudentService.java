package com.Student.CRUD.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.CRUD.Entity.StudentEntity;
import com.Student.CRUD.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	public StudentEntity saveData( StudentEntity se)
	{
		return repository.save(se);
		
	}
	
	//getting data
	public List<StudentEntity> getStudenData()
	{
		return repository.findAll();
		
	}
	
	//gettind data by id from student table
	public Optional<StudentEntity> getStudentDataById(long id)
	{
		return repository.findById(id);
		
	}
	//update data by id
		public StudentEntity updateDataById(StudentEntity se)
		{
			return repository.save(se);
		}
	//delete record by id from Student table
	public void deleteRecordById(long id)
	{
		 repository.deleteById(id);
	}
	//delete all records 
	public void deleteAllRecords()
	{
		repository.deleteAll();
	}
	
}

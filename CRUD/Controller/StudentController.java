package com.Student.CRUD.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.CRUD.Entity.StudentEntity;
import com.Student.CRUD.Service.StudentService;
import com.Student.CRUD.customExceptions.ResourseNotFoundException;
import com.example.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/Student")
public class StudentController {
	private StudentEntity se;
	@Autowired
	private StudentService service;
	//Entering the data into student table 
	@PostMapping("/insertDetails")
	public StudentEntity putStudentData(@RequestBody StudentEntity se)
	{
		return service.saveData(se);
	}
	
	//Retrive the details from student table 
	@GetMapping("/getDetails")
	public List<StudentEntity> getStudentData()
	{
		return service.getStudenData();
	}
	
	//Retraive details by id from student table
	@GetMapping("/getDetailsByID/{id}")
	public Optional<StudentEntity> getStudentDataById(@PathVariable(value="id") long id)
	{
		return service.getStudentDataById(id);
	}
	
	
	@PutMapping("/updateDataByid/{id}")
	public ResponseEntity<StudentEntity> updateDataById(@PathVariable(value="id") long id,@Valid @RequestBody StudentEntity e) throws ResourseNotFoundException
	{	
		System.out.print("id:"+id);
		StudentEntity student=service.getStudentDataById(id).orElseThrow(()->new ResourseNotFoundException("not found this id:"+id));
		//set values from entity e into entity student
		student.setFirst_name(e.getFirst_name());
		student.setLast_name(e.getLast_name());
		student.setMarks(e.getMarks());
		student.setEmail(e.getEmail());
	
        final StudentEntity updatedData = service.updateDataById(student);
        return ResponseEntity.ok(updatedData);
	   
    
	}
	
	
	//Delete records by id from student table
	@DeleteMapping("/deleteRecordByID/{id}")
	public void deleteRecordById(@PathVariable(value="id") long id)
	{
		 service.deleteRecordById(id);
	}
	
	//delete all records from table
	@DeleteMapping("/deleteAllRecords")
	public void deleteAllRecords()
	{
		service.deleteAllRecords();
	}
}

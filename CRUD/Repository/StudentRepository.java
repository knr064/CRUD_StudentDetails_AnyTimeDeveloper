package com.Student.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Student.CRUD.Entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long>{

}

package com.SpringBlood.SpringBloodApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SpringBlood.SpringBloodApplication.Entity.RegistrationEntity;

@Repository
public interface LoginRepository extends JpaRepository<RegistrationEntity,Long> {
	@Query(value="select full_name from registration_table where email=:email and password=:password",nativeQuery=true)
	List<Object> loginRepository(@Param("email") String email,@Param("password") String password);
}

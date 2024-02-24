package com.SpringBlood.SpringBloodApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SpringBlood.SpringBloodApplication.Entity.RegistrationEntity;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity,Long>{
	
	//retrive all coloumns based on bloodGroup
	@Query(value="select full_name,mobile,id,email,blood_group,date_of_birth,city,password,confirm_password from registration_table where blood_group =:bloodGroup", nativeQuery=true)
	List<RegistrationEntity> search(@Param("bloodGroup")String bloodGroup);
	
	//retrive full name ,email based on bloodgroup
	@Query(value="SELECT full_name, email FROM registration_table  WHERE blood_group =:bloodGroup",nativeQuery=true)
	List<Object> search2(@Param("bloodGroup")String bloodGroup);
	
	 
	//Search By EmailId and getting full name
	@Query(value="select full_name from registration_table where email=:Email",nativeQuery=true)
	List<Object> searchEmailRepo(@Param("Email") String Email);
}

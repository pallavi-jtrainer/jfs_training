package com.springpeople.spring.boot.SpringBootNamedQueriesDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springpeople.spring.boot.SpringBootNamedQueriesDemo.entity.Users;
import com.springpeople.spring.boot.SpringBootNamedQueriesDemo.utils.UserStatus;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	public Users findByEmail(String email);
	public Users findByUserPhone(String ph);
	
	public List<Users> getUsersWithSalaryBetween(double min, double max);
	
	public List<Users> findAllByStatus(UserStatus status);
	
	//public List<Users> findAllBySalaryBetween(double min, double max);
}

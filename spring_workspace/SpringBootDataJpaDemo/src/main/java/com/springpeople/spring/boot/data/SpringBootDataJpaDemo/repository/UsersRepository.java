package com.springpeople.spring.boot.data.SpringBootDataJpaDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	@Query("select u from Users u inner join u.roles r where r.roleName = :roleName")
	public List<Users> findAllByRoleName(@Param("roleName") String roleName);
	
	
}

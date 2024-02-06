package com.springpeople.spring.boot.SpringBootBackEndForNg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springpeople.spring.boot.SpringBootBackEndForNg.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	public Student findByStudentId(long id);
	public Student findByEmail(String email);
	
	@Modifying
	@Query("update Student s set s.password = :pass where s.studentId = :id")
	public int updatePassword(@Param("id") long id, @Param("pass") String pass);
	
}

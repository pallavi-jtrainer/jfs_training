package com.springpeople.spring.boot.data.SpringBootDataJpaDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springpeople.spring.boot.data.SpringBootDataJpaDemo.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

}

package com.ezio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezio.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmailAndPassword(String email, String password);

}

package com.example.demo.dao.repository;

import com.example.demo.dao.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
    List<StudentEntity> findAll();
}

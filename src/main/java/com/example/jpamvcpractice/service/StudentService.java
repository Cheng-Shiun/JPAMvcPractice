package com.example.jpamvcpractice.service;

import com.example.jpamvcpractice.model.Student;

import java.util.Optional;

public interface StudentService {
    Student insert(Student student);

    Student read(Integer studentId);

    Optional<Integer> findIdByNameAndAge(String studentName, Integer studentAge);

    Boolean update(Integer studentId, Student student);

    void delete(Integer studentId);
}

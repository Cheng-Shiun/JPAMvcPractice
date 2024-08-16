package com.example.jpamvcpractice.service;

import com.example.jpamvcpractice.dao.StudentRepository;
import com.example.jpamvcpractice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student insert(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student read(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Optional<Integer> findIdByNameAndAge(String studentName, Integer studentAge) {
        return studentRepository.findIdByNameAndAge(studentName, studentAge);
    }

    @Override
    public Boolean update(Integer studentId, Student student) {
        //先查詢資料庫中是否有該筆資料
        Student s =  studentRepository.findById(studentId).orElse(null);
        //如果有 -> 執行更新; 反之則失敗
        if (s != null) {
            //更新查詢出來的object數據
            //將請求的數據各個欄位的value設定給剛查詢出的object
            s.setName(student.getName());
            s.setAge(student.getAge());
            studentRepository.save(s);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void delete(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}

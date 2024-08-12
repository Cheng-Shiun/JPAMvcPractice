package com.example.jpamvcpractice.controller;

import com.example.jpamvcpractice.model.Student;
import com.example.jpamvcpractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //新增 Create api
    @PostMapping("/students")
    public String insert(@RequestBody Student student) {
        studentService.insert(student);
        return "執行資料庫 Create 操作";
    }

    //查詢 Read api
    @GetMapping("/students/{studentId}")
    public Student read(@PathVariable Integer studentId) {
        return studentService.read(studentId);
    }

    //查詢某個學生年紀 Read api
    @GetMapping("/students/{studentName}/{studentAge}")
    public Integer readAge(@PathVariable String studentName,
                           @PathVariable Integer studentAge) {
        Optional<Integer> studentId = studentService.findIdByNameAndAge(studentName, studentAge);
        return studentId.orElse(null);  //傳換為Integer
    }

    //修改 Update api
    @PutMapping("students/{studentId}")
    public String uqdate(@PathVariable Integer studentId,
                         @RequestBody Student student) {
        Boolean isUpdate = studentService.update(studentId, student);
        if(isUpdate){
            return "執行資料庫 Update 操作";
        } else {
            return "Update失敗，數據不存在";
        }
    }

    //刪除 Delete api
    @DeleteMapping("students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        studentService.delete(studentId);
        return "執行資料庫 Delete 操作";
    }
}

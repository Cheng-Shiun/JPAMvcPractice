package com.example.jpamvcpractice.dao;

import com.example.jpamvcpractice.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    //@Query (使用JPQL語法) -> 透過自訂實體的別名來實作SQL語句
    //別名s 為自訂(在FROM 後面)
    //@Param 將方法的參數與命名參數綁定(注意：即使相同也要綁定)
    @Query("SELECT s.id FROM Student s WHERE s.name = :studentName AND s.age = :studentAge")
    Optional<Integer> findIdByNameAndAge(@Param("studentName") String studentName, @Param("studentAge") Integer studentAge);
}

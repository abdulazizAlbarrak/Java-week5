package com.example.week5hw21.Repository;

import com.example.week5hw21.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public Student findStudentById(Integer id);

}

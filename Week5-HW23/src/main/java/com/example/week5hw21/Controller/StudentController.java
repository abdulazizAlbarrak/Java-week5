package com.example.week5hw21.Controller;

import com.example.week5hw21.Model.Student;
import com.example.week5hw21.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents(){
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("student added");
    }
    @PutMapping("/update/{student_id}")
    public ResponseEntity updateStudent(@PathVariable Integer student_id, @Valid @RequestBody Student student){
        studentService.updateStudent(student_id, student);
        return ResponseEntity.status(200).body("student updated");
    }
    @DeleteMapping("/delete/{student_id}")
    public ResponseEntity deleteStudent(@PathVariable Integer student_id){
        studentService.deleteStudent(student_id);
        return ResponseEntity.status(200).body("student deleted");
    }
    @PutMapping("/change/{student_id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer student_id,@PathVariable String major){
        studentService.changeMajor(student_id, major);
        return ResponseEntity.status(200).body("Major changed");
    }
    @GetMapping("/get-students-by-course/{course_id}")
    public ResponseEntity getStudentsByCourse(@PathVariable Integer course_id){
        return ResponseEntity.status(200).body(studentService.getAllStudentsByCourse(course_id));
    }
    @PutMapping("assign/{student_id}/{course_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer student_id,@PathVariable Integer course_id){
        studentService.assignStudentToCourse(student_id, course_id);
        return ResponseEntity.status(200).body("student assigned");
    }
}

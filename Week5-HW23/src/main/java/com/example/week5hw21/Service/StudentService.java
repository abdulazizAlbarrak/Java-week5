package com.example.week5hw21.Service;

import com.example.week5hw21.ApiException.ApiException;
import com.example.week5hw21.Model.Course;
import com.example.week5hw21.Model.Student;
import com.example.week5hw21.Repository.CourseRepository;
import com.example.week5hw21.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public void updateStudent(Integer student_id, Student student){
        Student old = studentRepository.findStudentById(student_id);
        if (old==null)
            throw new ApiException("Student id not found");
        old.setName(student.getName());
        old.setAge(student.getAge());
        old.setMajor(student.getMajor());
        studentRepository.save(old);
    }
    public void deleteStudent(Integer student_id){
        Student student = studentRepository.findStudentById(student_id);
        if (student==null)
            throw new ApiException("Student id not found");
        studentRepository.delete(student);
    }
    public void assignStudentToCourse(Integer student_id, Integer course_id){
        Student student = studentRepository.findStudentById(student_id);
        Course course = courseRepository.findCourseById(course_id);
        if (student==null || course==null)
            throw new ApiException("id not found");
        student.getCourses().add(course);
        course.getStudent().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }
    public void changeMajor(Integer student_id, String major){
        Student student = studentRepository.findStudentById(student_id);
        List<Course> course = courseRepository.findAll();
        if (student==null)
            throw new ApiException("Students id not found");
        for (int i=0;i<course.size();i++){
            if (student.getCourses().contains(course.get(i))){
                Course course1 = courseRepository.findCourseByName(course.get(i).getName());
                course1.getStudent().remove(student);
                courseRepository.save(course1);
            }
        }
        student.setMajor(major);
        student.getCourses().clear();
        studentRepository.save(student);
    }
    public Set<Student> getAllStudentsByCourse(Integer course_id){
        return courseRepository.findCourseById(course_id).getStudent();
    }

}

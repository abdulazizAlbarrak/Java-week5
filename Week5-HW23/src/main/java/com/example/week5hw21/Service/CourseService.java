package com.example.week5hw21.Service;

import com.example.week5hw21.ApiException.ApiException;
import com.example.week5hw21.Model.Course;
import com.example.week5hw21.Model.Teacher;
import com.example.week5hw21.Repository.CourseRepository;
import com.example.week5hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAll(){
        return courseRepository.findAll();
    }
    public void addCourse(Course course){
        courseRepository.save(course);
    }
    public void updateCourse(Integer id, Course course){
        Course old = courseRepository.findCourseById(id);
        if (old==null)
            throw new ApiException("course id not found");
        old.setName(course.getName());
        courseRepository.save(old);
    }
    public void deleteCourse(Integer id){
        if (courseRepository.findCourseById(id)==null)
            throw new ApiException("id not found");
        courseRepository.delete(courseRepository.findCourseById(id));
    }
    public void assignTeacherToCourse(Integer teacher_id,Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        if (course==null || teacher==null)
            throw new ApiException("course id or teacher is incorrect");
        course.setTeacher(teacher);
        courseRepository.save(course);
    }
    public String teacherNameForTheClass(Integer course_id){
        Course course = courseRepository.findCourseById(course_id);
        if (course==null)
            throw new ApiException("course id not found");
        if (course.getTeacher()==null)
            throw new ApiException("no teacher has been assigned to the course yet");
        return course.getTeacher().getName();
    }
}

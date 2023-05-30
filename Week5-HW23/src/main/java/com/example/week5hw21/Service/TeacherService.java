package com.example.week5hw21.Service;

import com.example.week5hw21.ApiException.ApiException;
import com.example.week5hw21.Model.Teacher;
import com.example.week5hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Integer id, Teacher teacher){
        if (teacherRepository.findTeacherById(id)==null){
            throw new ApiException("Id not found");
        }
        Teacher old = teacherRepository.findTeacherById(id);
        old.setAge(teacher.getAge());
        old.setName(teacher.getName());
        old.setSalary(teacher.getSalary());
        old.setEmail(teacher.getEmail());
        teacherRepository.save(old);
    }
    public void deleteTeacher(Integer id){
        teacherRepository.delete(teacherRepository.findTeacherById(id));
    }
    public Teacher getTeacherDetails(Integer id){
        return teacherRepository.findTeacherById(id);
    }
}

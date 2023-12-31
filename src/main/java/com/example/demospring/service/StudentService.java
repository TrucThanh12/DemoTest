package com.example.demospring.service;

import com.example.demospring.model.Student;
import com.example.demospring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(String id){
        return studentRepository.findById(id).orElse(null);
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(String id){
        studentRepository.deleteById(id);
    }

    public void deleteAllStudent(){
        studentRepository.deleteAll();
    }

}

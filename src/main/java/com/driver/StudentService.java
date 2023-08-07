package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public boolean addStudent(Student student) {
        boolean b= studentRepository.addStudent(student);

        return b;
    }

    public boolean addTeacher(Teacher addTeacher) {
        boolean b= studentRepository.addTeacher(addTeacher);
        return b;
    }

    public void addStudentTeacherPair(String student, String teacher) {
        studentRepository.addStudentTeacherPair(student,teacher);

    }

    public Student getStudentByName(String name) {
        Student student = studentRepository.getStudentByName(name); // Assign student by calling service layer method
        return student;

    }


    public Teacher getTeacherByName(String name) {
        Teacher teacher = studentRepository.getTeacherByName(name);
        return teacher;
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String> students = studentRepository.getStudentsByTeacherName(teacher);
        return students;
    }

    public List<String> getAllStudents() {
        List<String> students = studentRepository.getAllStudents();
        return students;
    }

    public void deleteTeacherByName(String teacher) {
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
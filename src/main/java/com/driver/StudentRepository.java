package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    private HashMap<String ,Student> studentDB = new HashMap<>();
    private HashMap<String ,Teacher> teacherDB = new HashMap<>();
    private HashMap<String  ,List<String>> studentTeacherDB = new HashMap<>();


    public boolean addStudent(Student student) {
        if(studentDB.containsKey(student.getName())){
            return false;
        }
        studentDB.put(student.getName(),student);
        return true;
    }

    public boolean addTeacher(Teacher addTeacher) {
        if(teacherDB.containsKey(addTeacher.getName())){
            return false;
        }

        teacherDB.put(addTeacher.getName(),addTeacher);
        return true;
    }

    public void addStudentTeacherPair(String student, String teacher) {
        if (studentDB.containsKey(student) && teacherDB.containsKey((teacher))) {

            if (studentTeacherDB.containsKey(teacher)) {
                List<String> list = studentTeacherDB.get(teacher);
                list.add(student);
                studentTeacherDB.put(teacher, list);
            } else {
                List<String> al = new ArrayList<>();
                al.add(student);
                studentTeacherDB.put(teacher, al);
            }
        }

    }

    public Student getStudentByName(String name) {
        if(studentDB.containsKey(name)) {
            return studentDB.get(name);
        } else {
            return null;
        }
    }

    public Teacher getTeacherByName(String name) {

        if(teacherDB.containsKey(name)) {
            return teacherDB.get(name);
        } else {
            return null;
        }
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        if(studentTeacherDB.containsKey(teacher)) {
            return studentTeacherDB.get(teacher);
        } else {
            return new ArrayList<>();
        }
    }

    public List<String> getAllStudents() {
        List<String> list = new ArrayList<>();
        for ( String student : studentDB.keySet()) {
            list.add(student);
        }
        return list;
    }

    public void deleteTeacherByName(String teacher) {
        teacherDB.remove(teacher);

        List<String> al = studentTeacherDB.remove(teacher);
        for(int i=0; i<al.size(); i++) {
            String temp = al.get(i);
            studentDB.remove(temp);
        }
    }

    public void deleteAllTeachers() {

        for(String k: studentTeacherDB.keySet()) {
            teacherDB.remove(k);
            List<String> al = studentTeacherDB.remove(k);
            for(String p: al) {
                if(studentDB.containsKey(p)) {
                    studentDB.remove(p);
                }
            }
        }
    }
}

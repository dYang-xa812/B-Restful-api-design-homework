package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.Model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Integer, Student> students = new HashMap<>();

    public StudentService() {
        students.put(1,new Student(1,"Alice", Gender.FEMALE,""));
        students.put(2,new Student(2,"Bert", Gender.MALE,""));
        students.put(3,new Student(3,"Carol", Gender.FEMALE,""));
        students.put(4,new Student(4,"Dave", Gender.MALE,""));
        students.put(5,new Student(5,"Edward", Gender.MALE,""));
        students.put(6,new Student(6,"Freya", Gender.FEMALE,""));
        students.put(7,new Student(7,"Grace", Gender.FEMALE,""));
        students.put(8,new Student(8,"Henry", Gender.MALE,""));
    }

    public void createStudent(Student student) {
        students.put(student.getId(),student);
    }

    public void deleteStudent(int id) {
        students.remove(id);
    }

    public List<Student> getStudents(Gender gender) {
        return students.values().stream()
                .filter(student -> gender == null || student.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public Student getStudentById(int id) {
        final Student student = students.get(id);
        if (student == null) {
            throw new IllegalArgumentException("student not found");
        }
        return student;
    }

    public Student UpdateStudentById(Integer id,Student student) {
        this.students.put(id,student);
        return this.students.get(id);
    }
}

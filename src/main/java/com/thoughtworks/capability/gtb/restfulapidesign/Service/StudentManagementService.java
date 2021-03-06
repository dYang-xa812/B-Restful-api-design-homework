package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.Model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Model.StudentGroup;
import lombok.Getter;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentManagementService {
    private final StudentService studentService = new StudentService();
    private final StudentGroupService studentGroupService = new StudentGroupService();

    public void createStudent(Student student) {
        this.studentService.createStudent(student);
    }

    public void deleteStudent(int id) {
        this.studentService.deleteStudent(id);
    }

    public List<Student> getStudents(Gender gender) {
        return this.studentService.getStudents(gender);
    }

    public Student getStudentById(int id) {
        return this.studentService.getStudentById(id);
    }

    public Student updateStudentInformation(int id, Student student) {
        return this.studentService.UpdateStudentById(id,student);
    }

    public List<StudentGroup> getStudentGroups() {
        return this.studentGroupService.getStudentGroups();
    }

    public void updateStudentGroupNameById(int id,String name) {
        this.studentGroupService.updateGroupName(id,name);
    }

    public List<StudentGroup> groupStudents(int groupCount) {
        final List<Student> students = this.studentService.getStudents(null);
        this.studentGroupService.groupStudents(students,groupCount);
        return this.studentGroupService.getStudentGroups();
    }
}

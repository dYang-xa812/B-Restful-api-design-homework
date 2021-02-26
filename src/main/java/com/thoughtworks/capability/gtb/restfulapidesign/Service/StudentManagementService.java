package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.Model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Model.StudentGroup;
import lombok.Getter;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentManagementService {
    private final StudentService studentService = new StudentService();
    private final StudentGroupService studentGroupService = new StudentGroupService();
    private @Getter final Map<StudentGroup,List<Student>> studentGroupListMap = new HashMap<>();

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

    public void updateStudentInformation(int id, Student student) {
        this.studentService.UpdateStudentById(id,student);
    }

    public void updateStudentGroupNameById(int id,String name) {
        this.studentGroupService.updateGroupName(id,name);
    }

    public void getStudentGroups() {
        this.studentGroupService.getStudentGroups();
    }

    public void groupStudents(int groupCount) {
        var students = this.studentService.getStudents(null);
        for (Student student : students) {
            var groupId = student.getId() % groupCount;
            var studentGroup = this.studentGroupService.getStudentGroupById(groupId);
            var studentList = this.studentGroupListMap.get(studentGroup);
            if (studentList == null) {
                studentList = new ArrayList<>();
            }
            studentList.add(student);
        }
    }
}

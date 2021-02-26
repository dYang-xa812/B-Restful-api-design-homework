package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.Model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Model.StudentGroup;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentManagementController {
    private final StudentManagementService studentManagementService;
    private final static String DEFAULT_GROUP_COUNT = "6";
    
    public StudentManagementController(StudentManagementService service) {
        this.studentManagementService = service;
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        this.studentManagementService.createStudent(student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("id") int id) {
        this.studentManagementService.deleteStudent(id);
    }

    @GetMapping("/students")
    public List<Student> getStudents(@RequestParam(name = "gender",required = false) Gender gender) {
        return this.studentManagementService.getStudents(gender);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return this.studentManagementService.getStudentById(id);
    }

    @PutMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudentInformation(@PathVariable("id") int id, @RequestBody Student student) {
        return this.studentManagementService.updateStudentInformation(id,student);
    }

    @PatchMapping("/studentgroups/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudentGroupNameById(@PathVariable("id") int id,@RequestBody String name) {
        this.studentManagementService.updateStudentGroupNameById(id,name);
    }

    @GetMapping("/studentgroups")
    public List<StudentGroup> getStudentGroups() {
        return this.studentManagementService.getStudentGroups();
    }

    @GetMapping("/students/group")
    public List<StudentGroup> groupStudent(@RequestParam(name = "group-count",defaultValue = DEFAULT_GROUP_COUNT,required = false) int groupCount) {
        return this.studentManagementService.groupStudents(groupCount);
    }
    
}

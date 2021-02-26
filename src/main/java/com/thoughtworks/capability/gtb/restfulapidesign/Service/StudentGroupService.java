package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Model.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.Model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Model.StudentGroup;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentGroupService {
    private final Map<Integer,StudentGroup> studentGroups = new HashMap<>();

    public StudentGroupService() {
        studentGroups.put(1,new StudentGroup(1,"A Team", "",null));
        studentGroups.put(2,new StudentGroup(2,"B Team", "",null));
        studentGroups.put(3,new StudentGroup(3,"C Team", "",null));
        studentGroups.put(4,new StudentGroup(4,"D Team", "",null));
        studentGroups.put(5,new StudentGroup(5,"E Team", "",null));
        studentGroups.put(6,new StudentGroup(6,"F Team", "",null));
    }

    public void updateGroupName(int id,String name) {
        StudentGroup studentGroup = studentGroups.get(id);
        if (studentGroup == null) {
            throw new IllegalArgumentException("stucdent group not found");
        }
        studentGroup.setName(name);
    }

    public StudentGroup getStudentGroupById(int id) {
        StudentGroup studentGroup = this.studentGroups.get(id);
        if (studentGroup == null) {
            throw new IllegalArgumentException("student group not found");
        }
        return studentGroup;
    }

    public List<StudentGroup> getStudentGroups() {
        return new ArrayList<>(this.studentGroups.values());
    }
}

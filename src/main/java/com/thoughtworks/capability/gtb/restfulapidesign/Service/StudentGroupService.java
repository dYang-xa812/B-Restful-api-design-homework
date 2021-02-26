package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Model.StudentGroup;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentGroupService {
    private @Getter final Map<Integer,StudentGroup> studentGroups = new HashMap<>();

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
}

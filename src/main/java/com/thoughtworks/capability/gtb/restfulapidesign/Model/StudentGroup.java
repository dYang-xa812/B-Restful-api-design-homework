package com.thoughtworks.capability.gtb.restfulapidesign.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroup {
    private int id;

    @NonNull
    private String name;
    private String note;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Student> students;
}

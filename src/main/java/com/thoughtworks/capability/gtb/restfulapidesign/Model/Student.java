package com.thoughtworks.capability.gtb.restfulapidesign.Model;

import com.thoughtworks.capability.gtb.restfulapidesign.Model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    @NonNull
    private String name;
    private Gender gender;
    private String note;
}






package com.thoughtworks.capability.gtb.restfulapidesign.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroup {
    private int id;

    @NonNull
    private String name;
    private String note;
}

package com.example.democompositeprimarykey.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class DepartmentId implements Serializable {

    private String departmentCode;
    private String departmentBranch;

    public DepartmentId() {

    }
}

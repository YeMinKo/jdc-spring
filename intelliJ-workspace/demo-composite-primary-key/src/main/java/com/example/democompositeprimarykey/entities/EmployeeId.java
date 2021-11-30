package com.example.democompositeprimarykey.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
public class EmployeeId implements Serializable {

    private String city;
    private String cubicleNo;

    public EmployeeId() {

    }
}

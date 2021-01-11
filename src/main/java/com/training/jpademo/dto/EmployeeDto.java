package com.training.jpademo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeDto
{
    private Long employeeId;
    private String name;
    List<PhoneDto> phoneList = new ArrayList<>();
}

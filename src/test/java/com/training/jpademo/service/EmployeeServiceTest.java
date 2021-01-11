package com.training.jpademo.service;

import com.training.jpademo.dto.EmployeeDto;
import com.training.jpademo.dto.PhoneDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class EmployeeServiceTest
{
    @Autowired
    EmployeeService employeeService;

    @Test
    void contextLoads() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName( "Jack Lane" );
        List<PhoneDto> phoneDtoList = Arrays.asList(
                new PhoneDto( "033121221212" ),
                new PhoneDto( "809830280834" )
        );
        employeeDto.setPhoneList( phoneDtoList );

        EmployeeDto employeeDtoResponse = employeeService.saveEmployee( employeeDto );
        System.out.println( employeeDtoResponse );
    }
}

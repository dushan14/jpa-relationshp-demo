package com.training.jpademo.controller;

import com.training.jpademo.dto.EmployeeDto;
import com.training.jpademo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;

    @RequestMapping( value = "employee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
    public EmployeeDto save( @RequestBody EmployeeDto employeeDto )
    {
        try
        {
            EmployeeDto employeeDtoResponse = employeeService.saveEmployee( employeeDto );
            return employeeDtoResponse;
        }
        catch( Exception e )
        {
            return null;
        }
    }
}

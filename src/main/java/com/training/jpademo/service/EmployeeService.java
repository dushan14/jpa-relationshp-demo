package com.training.jpademo.service;

import com.training.jpademo.dto.EmployeeDto;
import com.training.jpademo.entity.Employee;
import com.training.jpademo.mapper.EmployeeMapper;
import com.training.jpademo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    public EmployeeDto saveEmployee( EmployeeDto employeeDto )
    {
        try
        {
            Employee employee = employeeMapper.toEntity( employeeDto );
            Employee saved = employeeRepository.save( employee );
            EmployeeDto employeeDtoSaved = employeeMapper.toDto( saved );
            return employeeDtoSaved;
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return null;
        }
    }
}

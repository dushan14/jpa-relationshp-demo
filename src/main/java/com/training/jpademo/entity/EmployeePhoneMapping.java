package com.training.jpademo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "EMPLOYEE_PHONE_MAPPING" )
public class EmployeePhoneMapping
{
    @EmbeddedId
    private EmpPhoneMapId primaryKey = new EmpPhoneMapId();

    @MapsId( "employeeId" )
    @ManyToOne
    private Employee employee;

    @MapsId( "phoneId" )
    @ManyToOne
    private Phone phone;
}

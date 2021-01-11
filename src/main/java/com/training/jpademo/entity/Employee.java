package com.training.jpademo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table( name = "EMPLOYEE" )
public class Employee
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ID" )
    private Long employeeId;

    @Column( name = "NAME")
    private String name;

    @OneToMany( mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true )
    public Set<EmployeePhoneMapping> employeePhoneMappings = new HashSet<>();

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( !( o instanceof Employee ) ) return false;
        Employee employee = ( Employee ) o;
        return Objects.equals( getEmployeeId(), employee.getEmployeeId() );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( getEmployeeId() );
    }
}

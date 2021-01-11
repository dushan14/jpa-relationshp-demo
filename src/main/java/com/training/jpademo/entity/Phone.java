package com.training.jpademo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table( name = "PHONE" )
public class Phone
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "ID" )
    private Long phoneId;

    @Column( name = "NUMBER")
    private String number;

    @OneToMany( mappedBy = "phone", cascade = CascadeType.ALL, orphanRemoval = true )
    public Set<EmployeePhoneMapping> employeePhoneMappings = new HashSet<>();

    @Override
    public boolean equals( Object o )
    {
        if( this == o ) return true;
        if( !( o instanceof Phone ) ) return false;
        Phone phone = ( Phone ) o;
        return Objects.equals( getPhoneId(), phone.getPhoneId() );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( getPhoneId() );
    }
}

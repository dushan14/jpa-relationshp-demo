package com.training.jpademo.mapper;

import com.training.jpademo.dto.EmployeeDto;
import com.training.jpademo.dto.PhoneDto;
import com.training.jpademo.entity.Employee;
import com.training.jpademo.entity.Phone;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE
)
public abstract class PhoneMapper
{
    public abstract PhoneDto toDto( Phone entity );

    @Mapping( target = "employeePhoneMappings", ignore = true )
    public abstract Phone toEntity( PhoneDto dto );

    @AfterMapping
    public void attachEntities( PhoneDto dto, @MappingTarget Phone target )
    {

    }
}

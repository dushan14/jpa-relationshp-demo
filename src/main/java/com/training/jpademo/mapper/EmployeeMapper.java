package com.training.jpademo.mapper;

import com.training.jpademo.dto.EmployeeDto;
import com.training.jpademo.dto.PhoneDto;
import com.training.jpademo.entity.Employee;
import com.training.jpademo.entity.EmployeePhoneMapping;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE
)
public abstract class EmployeeMapper
{
    @Autowired
    PhoneMapper phoneMapper;

    @Mapping( target = "phoneList", ignore = true )
    public abstract EmployeeDto toDto( Employee entity );

    @Mapping( target = "employeePhoneMappings", ignore = true )
    public abstract Employee toEntity( EmployeeDto dto );

    @AfterMapping
    public void attachToEntities( EmployeeDto dto, @MappingTarget Employee target )
    {
        if( dto.getPhoneList() != null && !dto.getPhoneList().isEmpty() )
        {
            for( PhoneDto phoneDto : dto.getPhoneList() )
            {
                EmployeePhoneMapping employeePhoneMapping = new EmployeePhoneMapping();
                employeePhoneMapping.setEmployee( target );
                employeePhoneMapping.setPhone( phoneMapper.toEntity( phoneDto ) );
                target.getEmployeePhoneMappings().add( employeePhoneMapping );
            }
        }
    }

    @AfterMapping
    public void attachToDto( Employee entity, @MappingTarget EmployeeDto dto )
    {
        if( entity.getEmployeePhoneMappings() != null && !entity.getEmployeePhoneMappings().isEmpty() )
        {
            for( EmployeePhoneMapping employeePhoneMapping : entity.getEmployeePhoneMappings() )
            {
                PhoneDto phoneDto = phoneMapper.toDto( employeePhoneMapping.getPhone() );
                dto.getPhoneList().add( phoneDto );
            }
        }

    }
}

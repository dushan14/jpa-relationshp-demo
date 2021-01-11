package com.training.jpademo.repository;

import com.training.jpademo.entity.EmpPhoneMapId;
import com.training.jpademo.entity.EmployeePhoneMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePhoneMappingRepository extends JpaRepository<EmployeePhoneMapping,EmpPhoneMapId>
{
}

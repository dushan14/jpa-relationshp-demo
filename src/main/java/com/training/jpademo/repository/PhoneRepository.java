package com.training.jpademo.repository;

import com.training.jpademo.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long>
{
}

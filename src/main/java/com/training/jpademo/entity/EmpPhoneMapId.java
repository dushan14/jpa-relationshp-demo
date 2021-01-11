package com.training.jpademo.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmpPhoneMapId implements Serializable
{
    private Long employeeId;
    private Long phoneId;
}

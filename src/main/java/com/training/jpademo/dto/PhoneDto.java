package com.training.jpademo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneDto
{
    private Long phoneId;
    private String number;

    public PhoneDto( String number )
    {
        this.number = number;
    }
}

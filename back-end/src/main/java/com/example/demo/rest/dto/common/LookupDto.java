package com.example.demo.rest.dto.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = {"arabicName", "englishName", "code"}, callSuper = true)
@ToString(of = {"arabicName", "englishName", "enabled", "code"}, callSuper = true)
public class LookupDto extends RestDto{

    private String arabicName;

    private String englishName;

    private String code;

    private Boolean enabled;
}

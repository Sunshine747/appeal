package ru.sunshine747.appeal;

import lombok.experimental.Accessors;

@lombok.Data
@Accessors(chain = true)
public class PersonalInfo {
    private String fullname;
    private String fullAddress;
    private String phone;
    private String email;
}

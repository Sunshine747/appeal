package ru.sunshine747.appeal.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonalInfo {
    private String fullname;
    private String fullAddress;
    private String phone;
    private String email;
    private String textMessage;
}

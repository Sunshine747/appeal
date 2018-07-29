package ru.sunshine747.appeal.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonalInfo {

    private String surname;
    private String name;
    private String patronymic;
    private String fullname;
    private String city;
    private String street;
    private String house;
    private String flat;
    private String fullAddress;
    private String phone;
    private String email;
    private String textMessage;
}

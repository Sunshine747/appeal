package ru.sunshine747.appeal.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonalInfo {

    private String surname;
    private String name;
    private String patronymic;
    private String fullname = surname + " " + name + " " + patronymic;
    private String fullAddress;
    private String phone;
    private String email;
    private String textMessage;
}

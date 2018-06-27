package ru.sunshine747.appeal;

import org.testng.annotations.Test;

public class TestAppeal extends TestTemplate {

    @Test
    public void testAppeal() {

        fillAppealForm(new PersonalInfo()
                        .setFullname("Зоя Александровна Кузнецова")
                        .setFullAddress("г Москва, шоссе Внуковское 1-й километр ")
                        .setPhone("+7 234  234 23 34")
                        .setEmail("1@1.ru"));
        putMessage("test message");
        sendMessage();
    }

}

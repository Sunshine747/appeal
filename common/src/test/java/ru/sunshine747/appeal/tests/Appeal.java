package ru.sunshine747.appeal.tests;

import org.testng.annotations.Test;
import ru.sunshine747.appeal.model.PersonalInfo;

public class Appeal extends TestTemplate {

    @Test
    public void testAppeal() {

        page.fillAppealForm(new PersonalInfo()
                        .setFullname("Зоя Александровна Кузнецова")
                        .setFullAddress("г Москва, шоссе Внуковское 1-й километр ")
                        .setPhone("+7 234  234 23 34")
                        .setEmail("1@1.ru"));
        page.putMessage("test message");
        page.sendMessage();
    }

}

package ru.sunshine747.appeal.tests;

import org.testng.annotations.Test;
import ru.sunshine747.appeal.model.PersonalInfo;

public class PositiveFullTest extends TestTemplate {

    PersonalInfo user = new PersonalInfo()
            .setFullname("Петр См")
            .setEmail("1@1.com")
            .setTextMessage("test")
            .setFullAddress("г Москва, шоссе Калужское 34-й (п Десеновское) километр, д 1 стр 1")
            .setPhone("999 999 99 99")
            .setCity("Санкт-Петербург")
            .setStreet("Адмиралтейская")
            .setHouse("1")
            .setFlat("1");

    @Test
    public void positiveFullTestWithOneRowAddress() {

        assertions.assertThatPageContentIsCorrect();
        page.fillFIOChoiceVariant(user);
        page.fillAddressChoiceVariant(user);
        page.fillPhone(user);
        page.fillEmail(user);
        page.fillTextMessage(user);
        page.sendMessage();
        assertions.assertThatFeedbackMessageIsCorrect();
        assertions.assertThatFeedbackButtonTextIsCorrect();
        page.clickFeedbackButton();
        assertions.assertThatFeedbackMessageIsHide();

    }

    @Test
    public void positiveFullTestWithManyRowAddress() {
        assertions.assertThatPageContentIsCorrect();
        page.fillCity(user);
        page.fillStreet(user);
        page.fillHouse(user);
        page.fillFlat(user);
        page.choiceAddress();
        System.out.println(page.getIndex());
        System.out.println(page.getRegion());
        System.out.println(page.getCity());
        System.out.println(page.getStreet());
        System.out.println(page.getHouse());
        System.out.println(page.getFlat());
    }
}

package ru.sunshine747.appeal.tests;

import org.testng.annotations.Test;
import ru.sunshine747.appeal.model.PersonalInfo;

public class PositiveFullTest extends TestTemplate {

    @Test
    public void positiveFullTest() {

        PersonalInfo user = new PersonalInfo()
                .setFullname("Петр См")
                .setEmail("1@1.com")
                .setTextMessage("test")
                .setFullAddress("г Москва, шоссе Калужское 34-й (п Десеновское) километр, д 1 стр 1")
                .setPhone("999 999 99 99");

        assertions.assertThatPageContentIsCorrect();
        page.fillFIOChoiceVariant(user);
        page.fillAddressChoiseVarian(user);
        page.fillPhone(user);
        page.fillEmail(user);
        page.fillTextMessage(user);
        page.sendMessage();
        assertions.assertThatFeedbackMessageIsCorrect();
        assertions.assertThatFeedbackButtonTextIsCorrect();
        page.clickFeedbackButton();
        assertions.assertThatFeedbackMessageIsHide();

    }
}

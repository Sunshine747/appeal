package ru.sunshine747.appeal.tests;

import org.testng.annotations.Test;
import ru.sunshine747.appeal.model.PersonalInfo;

public class PositiveMandatoryTest extends TestTemplate{

    @Test
    public void positiveMandatoryTest() {

        PersonalInfo user = new PersonalInfo()
                .setFullname("Петр См")
                .setEmail("1@1.com")
                .setTextMessage("test");

        assertions.assertThatPageContentIsCorrect();
        page.fillFIOChoiceVariant(user);
        page.fillEmail(user);
        page.fillTextMessage(user);
        page.sendMessage();
        assertions.assertThatFeedbackMessageIsCorrect();
        assertions.assertThatFeedbackButtonTextIsCorrect();
        page.clickFeedbackButton();
        assertions.assertThatFeedbackMessageIsHide();

    }
}

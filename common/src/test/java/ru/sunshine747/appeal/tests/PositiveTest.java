package ru.sunshine747.appeal.tests;

import org.testng.annotations.Test;
import ru.sunshine747.appeal.model.PersonalInfo;

public class PositiveTest extends TestTemplate{

    @Test
    public void displayPageTest() {

        assertions.assertThatPageContentIsCorrect();
        page.fillAppealFormWithChoiceVariant(new PersonalInfo()
                .setFullname("Петр Петров")
                .setEmail("1@1.com")
                .setTextMessage("test"));
        page.sendMessage();
        page.waitFeedbackProgress();
        assertions.assertThatFeedbackMessageIsCorrect();
        assertions.assertThatFeedbackButtonTextIsCorrect();

    }
}

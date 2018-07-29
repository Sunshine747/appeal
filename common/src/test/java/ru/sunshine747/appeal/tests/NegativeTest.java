package ru.sunshine747.appeal.tests;

import org.testng.annotations.Test;
import ru.sunshine747.appeal.model.PersonalInfo;

public class NegativeTest extends TestTemplate {

    PersonalInfo user = new PersonalInfo()
            .setSurname("Смирнов")
            .setName("Петр")
            .setEmail("test")
            .setTextMessage("test")
            .setFullAddress("Москва");

    @Test
    public void emptyRequiredFieldsTest() {
        page.sendMessageForNegative();
        assertions.assertThatFeedbackMessageIsHide();
        page.fillSurname(user);
        page.sendMessageForNegative();
        assertions.assertThatFeedbackMessageIsHide();
        page.fillName(user);
        page.sendMessageForNegative();
        assertions.assertThatFeedbackMessageIsHide();
        page.fillEmail(user);
        page.sendMessageForNegative();
        assertions.assertThatFeedbackMessageIsHide();
        user.setEmail("test@");
        page.fillEmail(user);
        page.sendMessageForNegative();
        assertions.assertThatFeedbackMessageIsHide();
        user.setEmail("test@test.com"); //"test@test" is valid email
        page.fillEmail(user);
        page.sendMessageForNegative();
        assertions.assertThatFeedbackMessageIsHide();

    }

}

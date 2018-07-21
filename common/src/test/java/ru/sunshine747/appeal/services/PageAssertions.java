package ru.sunshine747.appeal.services;

import org.hamcrest.core.IsNot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;

public class PageAssertions {

    private PageActions page = new PageActions();

    public PageAssertions(PageActions page) {
        this.page = page;
    }

    public void assertThatPageContentIsCorrect() {

        //TODO: add asterisk check

        assertThat(page.getHeaderText(), equalTo("Обращение в правительство Москвы"));
        assertThat(page.getSecondHeaderText(), equalTo("Пожалуйста, укажите ваши контактные данные и суть вопроса"));
        assertThat(page.getFIOLableText(), equalTo("ФИО"));
        assertThat(page.getFIODefaultText(), equalTo("Введите ФИО в свободной форме"));
        assertThat(page.getSurnameLableText(), equalTo("Фамилия"));
        assertThat(page.getNameLableText(), equalTo("Имя"));
        assertThat(page.getParronymicLableText(), equalTo("Отчество"));
        assertThat(page.getPhoneLableText(), equalTo("Контактный телефон"));
        assertThat(page.getPhoneDefaultText(), equalTo("+7 916 123-45-67"));
        assertThat(page.getEmailLableText(), equalTo("E-mail"));
        assertThat(page.getEmailDefaultText(), equalTo("me@example.com"));
        assertThat(page.getMassageContentLableText(), equalTo("Содержание обращения"));
        assertThat(page.getAddressLableText(), equalTo("Адрес"));
        assertThat(page.getAddressDefaultText(), equalTo("Введите адрес в свободной форме"));
        assertThat(page.getPostalCodeLableText(), equalTo("Индекс"));
        assertThat(page.getRegionLableText(), equalTo("Регион"));
        assertThat(page.getCityLableText(), equalTo("Город"));
        assertThat(page.getStreetLableText(), equalTo("Улица"));
        assertThat(page.getHouseLableText(), equalTo("Дом"));
        assertThat(page.getFlatLableText(), equalTo("Квартира"));
        assertThat(page.getSubmitButtonText(), equalTo("Отправить обращение"));

    }

    public void assertThatFeedbackMessageIsCorrect() {

        assertThat(page.getFeedbackMessageHead(), anyOf(
                equalTo("Это не настоящее правительство :-("),
                equalTo("Извините, у нас обед")));
        assertThat(page.getFeedbackMessageBody(), anyOf(
                equalTo("К сожалению, мы не можем принять ваше обращение.\n" +
                        "Но вы всегда можете отправить его через электронную приемную правительства Москвы."),
                equalTo("Прямо сейчас мы не можем принять ваше обращение.\n" +
                        "Но вы всегда можете отправить его нотариально заверенную копию Почтой России по адресу: 125032, Москва, ул. Тверская, 13.")
        ));

    }

    public void assertThatFeedbackButtonTextIsCorrect() {
        assertThat(page.getFeedbackButtonText(), equalTo("Хорошо, я понял"));

    }

    public void assertThatFeedbackMessageIsHide() {
        assertThat(page.findFeedbackMessage(), equalTo(false));
    }

    public void assertThatFeedbackMessageIsPresent() {
        assertThat(page.findFeedbackMessage(), equalTo(true));
    }
}

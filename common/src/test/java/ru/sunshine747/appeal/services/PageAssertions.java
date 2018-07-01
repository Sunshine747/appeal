package ru.sunshine747.appeal.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PageAssertions {

    private PageActions page = new PageActions();

    public PageAssertions(PageActions page) {
        this.page = page;
    }

    public void assertThatPageContentIsCorrect() {

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
        assertThat(page.getSubmitButtonText(), equalTo("Отправить обращение"));    }
}

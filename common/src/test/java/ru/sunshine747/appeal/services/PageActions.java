package ru.sunshine747.appeal.services;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sunshine747.appeal.model.PersonalInfo;

import java.util.concurrent.TimeUnit;


public class PageActions {

    WebDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void openPage() {

        FirefoxOptions opt = new FirefoxOptions();
        opt.addArguments("--headless");

        WebDriverManager.firefoxdriver().setup();
        wd = new FirefoxDriver(opt);
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://hflabs.github.io/suggestions-demo/");
    }

    public void stopTest() {
        wd.quit();
    }

    public void sendMessage() {
        wd.findElement(By.xpath("//form[@id='feedback-form']//button[.='Отправить обращение']")).click();
        new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("feedback-progress")));
        new WebDriverWait(wd, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id("feedback-progress")));
    }

    public void sendMessageForNegative() {
        wd.findElement(By.xpath("//form[@id='feedback-form']//button[.='Отправить обращение']")).click();
    }

    public void fillFIOChoiceVariant(PersonalInfo personalInfo) {
        wd.findElement(By.id("fullname")).click();
        wd.findElement(By.id("fullname")).clear();
        wd.findElement(By.id("fullname")).sendKeys(personalInfo.getFullname());
        wd.findElement(By.xpath(".//div[@class='col-xs-12 col-md-6'][1]/div[@class='form-group']/div[@class='suggestions-wrapper']/div[@class='suggestions-suggestions']/div[2]")).click();
    }

    public void fillSurname(PersonalInfo personalInfo) {
        wd.findElement(By.id("fullname-surname")).click();
        wd.findElement(By.id("fullname-surname")).clear();
        wd.findElement(By.id("fullname-surname")).sendKeys(personalInfo.getSurname());
        wd.findElement(By.xpath(".//div[@class='suggestions-suggestion'][2]")).click();
    }

    public void fillName(PersonalInfo personalInfo) {
        wd.findElement(By.id("fullname-name")).click();
        wd.findElement(By.id("fullname-name")).clear();
        wd.findElement(By.id("fullname-name")).sendKeys(personalInfo.getName());
        wd.findElement(By.xpath(".//div[@class='suggestions-suggestion'][2]")).click();
    }

    public void fillPatronymic(PersonalInfo personalInfo) {
        wd.findElement(By.id("fullname-patronymic")).click();
        wd.findElement(By.id("fullname-patronymic")).clear();
        wd.findElement(By.id("fullname-patronymic")).sendKeys(personalInfo.getPatronymic());
    }

    public void fillAddressChoiceVariant(PersonalInfo personalInfo) {
        wd.findElement(By.id("address")).click();
        wd.findElement(By.id("address")).clear();
        wd.findElement(By.id("address")).sendKeys(personalInfo.getFullAddress());
        new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='col-xs-12 col-md-6'][2]/div[@class='form-group']/div[@class='suggestions-wrapper']/div[@class='suggestions-suggestions']")));
        wd.findElement(By.xpath(".//div[@class='col-xs-12 col-md-6'][2]/div[@class='form-group']/div[@class='suggestions-wrapper']/div[@class='suggestions-suggestions']")).click();
    }

    public void fillCity(PersonalInfo personalInfo) {
        wd.findElement(By.id("address-city")).click();
        wd.findElement(By.id("address-city")).clear();
        wd.findElement(By.id("address-city")).sendKeys(personalInfo.getCity());
    }

    public void fillStreet(PersonalInfo personalInfo) {
        wd.findElement(By.id("address-street")).click();
        wd.findElement(By.id("address-street")).clear();
        wd.findElement(By.id("address-street")).sendKeys(personalInfo.getStreet());
    }

    public void fillHouse(PersonalInfo personalInfo) {
        wd.findElement(By.id("address-house")).click();
        wd.findElement(By.id("address-house")).clear();
        wd.findElement(By.id("address-house")).sendKeys(personalInfo.getHouse());
    }

    public void fillFlat(PersonalInfo personalInfo) {
        wd.findElement(By.id("address-flat")).click();
        wd.findElement(By.id("address-flat")).clear();
        wd.findElement(By.id("address-flat")).sendKeys(personalInfo.getFlat());
    }

    public void choiceAddress() {
        wd.findElement(By.id("address")).click();
        new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='col-xs-12 col-md-6'][2]/div[@class='form-group']/div[@class='suggestions-wrapper']/div[@class='suggestions-suggestions']")));
        wd.findElement(By.xpath(".//div[@class='col-xs-12 col-md-6'][2]/div[@class='form-group']/div[@class='suggestions-wrapper']/div[@class='suggestions-suggestions']")).click();
    }

    public String getIndex() {
        return wd.findElement(By.id("address-postal_code")).getAttribute("value");
    }

    public String getRegion() {
        return wd.findElement(By.id("address-region")).getAttribute("value");
    }

    public String getCity() {
        return wd.findElement(By.id("address-city")).getAttribute("value");
    }

    public String getStreet() {
        return wd.findElement(By.id("address-street")).getAttribute("value");
    }

    public String getHouse() {
        return wd.findElement(By.id("address-house")).getAttribute("value");
    }

    public String getFlat() {
        return wd.findElement(By.id("address-flat")).getAttribute("value");
    }

    public void fillPhone(PersonalInfo personalInfo) {
        wd.findElement(By.id("phone")).click();
        wd.findElement(By.id("phone")).clear();
        wd.findElement(By.id("phone")).sendKeys(personalInfo.getPhone());
    }

    public void fillEmail(PersonalInfo personalInfo) {
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys(personalInfo.getEmail());
    }

    public void fillTextMessage(PersonalInfo personalInfo) {
        wd.findElement(By.id("message")).click();
        wd.findElement(By.id("message")).clear();
        wd.findElement(By.id("message")).sendKeys(personalInfo.getTextMessage());
    }

    public String getHeaderText() {
        return  wd.findElement(By.xpath(".//div[@class='page-header']/h1")).getText();
    }

    public String getSecondHeaderText() {
        return  wd.findElement(By.className("lead")).getText();
    }

    public String getFIOLableText() {
        return  wd.findElement(By.xpath(".//label[@for='fullname']")).getText();
    }

    public String getFIODefaultText() {
        return  wd.findElement(By.id("fullname")).getAttribute("placeholder");
    }

    public String getSurnameLableText() {
        return wd.findElement(By.xpath(".//label[@for='fullname-surname']")).getText();
    }

    public String getNameLableText() {
        return wd.findElement(By.xpath(".//label[@for='fullname-name']")).getText();
    }

    public String getParronymicLableText() {
        return wd.findElement(By.xpath(".//label[@for='fullname-patronymic']")).getText();
    }

    public String getPhoneLableText() {
        return  wd.findElement(By.xpath(".//label[@for='phone']")).getText();
    }

    public String getPhoneDefaultText() {
        return  wd.findElement(By.id("phone")).getAttribute("placeholder");
    }

    public String getEmailLableText() {
        return  wd.findElement(By.xpath(".//label[@for='email']")).getText();
    }

    public String getEmailDefaultText() {
        return  wd.findElement(By.id("email")).getAttribute("placeholder");
    }

    public String getMassageContentLableText() {
        return  wd.findElement(By.xpath(".//label[@for='message']")).getText();
    }

    public String getAddressLableText() {
        return  wd.findElement(By.xpath(".//label[@for='address']")).getText();
    }

    public String getAddressDefaultText() {
        return  wd.findElement(By.id("address")).getAttribute("placeholder");
    }

    public String getPostalCodeLableText() {
        return wd.findElement(By.xpath(".//label[@for='address-postal_code']")).getText();
    }

    public String getRegionLableText() {
        return wd.findElement(By.xpath(".//label[@for='address-region']")).getText();
    }

    public String getCityLableText() {
        return wd.findElement(By.xpath(".//label[@for='address-city']")).getText();
    }

    public String getStreetLableText() {
        return wd.findElement(By.xpath(".//label[@for='address-street']")).getText();
    }

    public String getHouseLableText() {
        return wd.findElement(By.xpath(".//label[@for='address-house']")).getText();
    }

    public String getFlatLableText() {
        return wd.findElement(By.xpath(".//label[@for='address-flat']")).getText();
    }

    public String getRequiredLabelFIO() { return wd.findElement(By.xpath("//div[label[@for='fullname']]/span")).getText();}

    public String getRequiredLabelEmail() { return wd.findElement(By.xpath("//div[label[@for='email']]/span")).getText();}

    public String getRequiredLabelMessage() { return wd.findElement(By.xpath("//div[label[@for='message']]/span")).getText();}

    public String getSubmitButtonText(){
        return wd.findElement(By.xpath(".//button[@class='btn btn-primary btn-lg']")).getText();
    }

    public String getFeedbackMessageHead() {
        return wd.findElement(By.xpath(".//div[@id='feedback-message']/h4")).getText();
    }

    public String getFeedbackMessageBody() {
        return wd.findElement(By.xpath(".//div[@id='feedback-message']/p")).getText();
    }

    public void waitFeedbackProgress() {
        new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("feedback-progress")));
        new WebDriverWait(wd, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id("feedback-progress")));
    }

    public String getFeedbackButtonText() {
        return wd.findElement(By.xpath(".//button[@class='btn btn-default']")).getText();
    }

    public void clickFeedbackButton() {
        wd.findElement(By.xpath(".//button[@class='btn btn-default']")).click();
        new WebDriverWait(wd, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id("feedback-message")));
    }

    public boolean findFeedbackMessage() {
        if (wd.findElement(By.id("feedback-message")).isDisplayed()) {
            return true;
        }
        else return false;
    }
}

package ru.sunshine747.appeal.services;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        WebDriverManager.firefoxdriver().setup();
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://hflabs.github.io/suggestions-demo/");
    }

    public void stopTest() {
        wd.quit();
    }

    public void sendMessage() {
        wd.findElement(By.xpath("//form[@id='feedback-form']//button[.='Отправить обращение']")).click();
    }

    public void fillAppealFormWithChoiceVariant(PersonalInfo personalInfo) {
        wd.findElement(By.id("fullname")).click();
        wd.findElement(By.id("fullname")).clear();
        wd.findElement(By.id("fullname")).sendKeys(personalInfo.getFullname());
        wd.findElement(By.xpath(".//div[@class='suggestions-suggestion'][2]")).click();
        wd.findElement(By.id("address")).click();
        wd.findElement(By.id("address")).clear();
        wd.findElement(By.id("address")).sendKeys(personalInfo.getFullAddress());
        wd.findElement(By.id("address-house")).clear();
        wd.findElement(By.id("address-flat")).click();
        wd.findElement(By.id("address-flat")).clear();
        wd.findElement(By.id("address-flat")).sendKeys("");
        wd.findElement(By.id("phone")).click();
        wd.findElement(By.id("phone")).clear();
        wd.findElement(By.id("phone")).sendKeys(personalInfo.getPhone());
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys(personalInfo.getEmail());
        wd.findElement(By.xpath("//form[@id='feedback-form']/div[2]")).click();
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

}

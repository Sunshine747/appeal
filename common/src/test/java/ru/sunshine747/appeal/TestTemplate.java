package ru.sunshine747.appeal;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestTemplate {
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://hflabs.github.io/suggestions-demo/");
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    protected void sendMessage() {
        wd.findElement(By.xpath("//form[@id='feedback-form']//button[.='Отправить обращение']")).click();
    }

    protected void putMessage(String textMessage) {
        wd.findElement(By.xpath("//form[@id='feedback-form']/div[2]")).click();
        wd.findElement(By.id("message")).click();
        wd.findElement(By.id("message")).clear();
        wd.findElement(By.id("message")).sendKeys(textMessage);
    }

    protected void fillAppealForm(PersonalInfo personalInfo) {
        wd.findElement(By.id("fullname")).click();
        wd.findElement(By.id("fullname")).clear();
        wd.findElement(By.id("fullname")).sendKeys(personalInfo.getFullname());
        wd.findElement(By.id("address")).click();
        wd.findElement(By.id("address")).clear();
        wd.findElement(By.id("address")).sendKeys(personalInfo.getFullAddress());
        wd.findElement(By.id("address-house")).clear();
        wd.findElement(By.id("address-flat")).click();
        wd.findElement(By.id("address-flat")).clear();
        wd.findElement(By.id("address-flat")).sendKeys("1");
        wd.findElement(By.id("phone")).click();
        wd.findElement(By.id("phone")).clear();
        wd.findElement(By.id("phone")).sendKeys(personalInfo.getPhone());
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys(personalInfo.getEmail());
    }
}

package ru.sunshine747.appeal.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.sunshine747.appeal.services.PageActions;

public class TestTemplate {

    protected final PageActions page = new PageActions();

    @BeforeMethod
    public void setUp() throws Exception {
        page.openPage();
    }

    @AfterMethod
    public void tearDown() {
        page.stopTest();
    }

}

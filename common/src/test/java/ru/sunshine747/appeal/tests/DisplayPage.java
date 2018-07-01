package ru.sunshine747.appeal.tests;

import org.testng.annotations.Test;
import ru.sunshine747.appeal.services.PageAssertions;

public class DisplayPage extends TestTemplate{

    @Test
    public void displayPageTest() {

        new PageAssertions(page).assertThatPageContentIsCorrect();

    }
}

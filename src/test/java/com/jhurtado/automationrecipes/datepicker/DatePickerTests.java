package com.jhurtado.automationrecipes.datepicker;

import com.jhurtado.automationrecipes.base.BaseTest;
import com.jhurtado.automationrecipes.components.DatePicker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatePickerTests extends BaseTest {

    @BeforeAll
    public static void launchApp(){
        driver.get("file:///Users/jhumbertoh/Proyectos/Publicos/automation-recipes/web/datepicker.html");
    }

    @Test
    public void pastDate(){
        //July 31 1988
        var dateToSelect = LocalDate.of(1988, Month.JULY, 31);
        //Select date
        var selectedDate = new DatePicker(driver).chooseDate(dateToSelect);
        //Verify
        assertEquals(dateToSelect, selectedDate);
    }

    @Test
    public void futureDate(){
        var dateToSelect = LocalDate.now().plusMonths(7);
        var selectedDate = new DatePicker(driver).chooseDate(dateToSelect);
        assertEquals(dateToSelect, selectedDate);
    }

    @Test
    public void currentMonth(){
        var dateToSelect = LocalDate.now().withDayOfMonth(15);
        var selectedDate = new DatePicker(driver).chooseDate(dateToSelect);
        assertEquals(dateToSelect, selectedDate);
    }
}
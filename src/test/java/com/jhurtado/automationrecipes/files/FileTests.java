package com.jhurtado.automationrecipes.files;

import com.jhurtado.automationrecipes.base.BaseTest;
import com.jhurtado.automationrecipes.parabank.pages.FindTransactionsPage;
import com.jhurtado.automationrecipes.parabank.pages.Page;
import com.jhurtado.automationrecipes.utils.SpreadsheetUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileTests extends BaseTest {

    @BeforeAll
    public static void launchApp() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    public void checkTransaction() {
        String user = "john", password = "demo";
        String fileName = "resources/TestData.xlsx";

        var page = new Page(driver);
        page.login(user, password);

        page.clickMenuLink("Find Transactions");

        var spreadsheet = new SpreadsheetUtil(new File(fileName));
        spreadsheet.switchToSheet(user);

        int row = 1;
        String accountId = spreadsheet.getCellData("Account ID", row);
        String transactionId = spreadsheet.getCellData("Transaction ID", row);


        var findTransactionPage = new FindTransactionsPage(driver);
        var transactionPage = findTransactionPage.searchByTransactionId(accountId, transactionId);

        var results = transactionPage.getTransactionResults();

        assertEquals(spreadsheet.getCellData("Date", row), results.get(0));
        assertEquals(spreadsheet.getCellData("Description", row), results.get(1));
        assertEquals(spreadsheet.getCellData("Credit", row), results.get(3));
    }
}
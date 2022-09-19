package com.project.tests;

import com.project.Utils.BrowseUtils;
import com.project.Utils.Driver;
import com.project.pages.googleMap;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class zipCodeTest {

    @After
    public void tearDownScenario(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
        }

        System.out.println("AFTER - tearDown method is running after the scenario");

        Driver.closeDriver();
    }

    googleMap googleMap = new googleMap();

    String filePath = "Umair.xlsx";

    @Test
    public void test1() throws IOException {
        Driver.getDriver().get("https://www.google.com/maps");

        FileInputStream in = new FileInputStream(filePath);
        XSSFWorkbook wBook = new XSSFWorkbook(in);
        XSSFSheet sheet = wBook.getSheet("Ohio");
        int row = 1;
        while (row<=sheet.getPhysicalNumberOfRows()-1){
            googleMap.searchBar.clear();
            String data =sheet.getRow(row).getCell(0).toString();
            googleMap.searchBar.sendKeys(data.substring(0, data.length() - 2), Keys.ENTER);
        BrowseUtils.sleep(2);
            String url = Driver.getDriver().getCurrentUrl();
            String coordinates = url.substring(url.indexOf('@')+1,url.indexOf('@')+23);
            sheet.getRow(row).createCell(4).setCellValue(coordinates);
            row++;
        }



        //save the changes
        //1-opening excel file
        FileOutputStream output = new FileOutputStream(filePath);
        //2-saving
        wBook.write(output);
        output.close();
        wBook.close();
        in.close();

    }


}

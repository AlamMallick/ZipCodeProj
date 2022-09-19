package com.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class googleMap extends basePage{

    @FindBy(css = "input[aria-label='Search Google Maps']")
    public WebElement searchBar;



}

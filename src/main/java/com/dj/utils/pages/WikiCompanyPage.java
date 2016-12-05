package com.dj.utils.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiCompanyPage extends WikiPage {

    private static final Logger LOG = LogManager.getLogger(WikiCompanyPage.class);

    @FindBy(xpath = "//table[@class='infobox hproduct']")
    private WebElement infoBlock;

    @FindBy(xpath = "//table[@class='infobox hproduct']//caption")
    private WebElement companyName;

    @FindBy(xpath = "//table[@class='infobox hproduct']//tr[8]/td/span[@class='country-name']")
    private WebElement headquarters;

    public WikiCompanyPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getInfoBlock() {
        return infoBlock;
    }

    public WebElement getCompanyName() {
        return companyName;
    }

    public WebElement getHeadquarters() {
        return headquarters;
    }
}

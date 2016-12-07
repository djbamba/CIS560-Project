package com.dj.utils.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Optional;

public class WikiCompanyPage extends WikiPage {

    private static final Logger LOG = LogManager.getLogger(WikiCompanyPage.class);

    @FindBy(xpath = "//table[@class='infobox vcard']")
    private WebElement infoBlock;

    @FindBy(xpath = "//table[@class='infobox vcard']//caption")
    private WebElement companyName;

    @FindBy(xpath = "//table[@class='infobox vcard']//tr[8]/td/span[@class='country-name']")
    private WebElement headquarters;

//    private By publisherRowLink = new By.ByXPath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr/td[2]/a");

    private By publisherRow = new By.ByXPath("//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr/td[1]/a");

    public WikiCompanyPage(WebDriver driver) {
        super(driver);
    }

    public WikiCompanyPage(WebDriver driver, String url) {
        super(driver, url);
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

    public By getPublisherRow() {
        return publisherRow;
    }

    public boolean checkIfElementExists(WebElement webElement) {
        boolean exists = false;
        Optional<WebElement> webElementOptional = Optional.of(webElement);

        if (webElementOptional.isPresent()) {
            exists = true;
        }
        return exists;
    }
}

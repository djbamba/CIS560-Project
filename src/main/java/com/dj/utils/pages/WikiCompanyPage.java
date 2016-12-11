package com.dj.utils.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WikiCompanyPage extends WikiPage {

    private static final Logger LOG = LogManager.getLogger(WikiCompanyPage.class);

    @FindBy(xpath = "//table[@class='infobox vcard']")
    private WebElement infoBlock;

    @FindBy(xpath = "//table[@class='infobox vcard']//caption")
    private WebElement companyName;

    @FindBy(xpath = "//h1[@id='firstHeading']")
    private WebElement companyNameByHeading;

    // Location of country headquartersByClass aren't uniform across info blocks
    @FindBy(xpath = "//table[@class='infobox vcard']//tr/td/span[@class='country-name']")
    private WebElement headquartersByClass;

    @FindBy(xpath = "//table[@class='infobox vcard']//tr//td[@class='label']/a[last()]")
    private WebElement headquartersByLink;

    @FindBy(xpath = "//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr/td[1]/a")
    private List<WebElement> publishers;

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

    public WebElement getCompanyNameByHeading() {
        return companyNameByHeading;
    }

    public WebElement getHeadquartersByClass() {
        return headquartersByClass;
    }

    public WebElement getHeadquartersByLink() {
        return headquartersByLink;
    }

    public List<WebElement> getPublishers() {
        return publishers;
    }

    public List<String> getPublisherInfoLinks() {
        List<String> links = new ArrayList<>();

        publishers.forEach((WebElement element) -> links.add(element.getAttribute("href")));

        return links;
    }
}

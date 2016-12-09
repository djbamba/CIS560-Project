package com.dj.utils.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WikiCompanyPage extends WikiPage {

    private static final Logger LOG = LogManager.getLogger(WikiCompanyPage.class);

    @FindBy(xpath = "//table[@class='infobox vcard']")
    private WebElement infoBlock;

    @FindBy(xpath = "//table[@class='infobox vcard']//caption")
    private WebElement companyName;

    @FindBy(xpath = "//table[@class='infobox vcard']//tr/td/span[@class='country-name']")
    private WebElement headquarters;

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

    public WebElement getHeadquarters() {
        return headquarters;
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

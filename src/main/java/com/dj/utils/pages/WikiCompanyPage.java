package com.dj.utils.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WikiCompanyPage extends WikiPage {

    private static final Logger LOG = LogManager.getLogger(WikiCompanyPage.class);

    public WikiCompanyPage(WebDriver driver) {
        super(driver);
    }

    public WikiCompanyPage(WebDriver driver, String url) {
        super(driver, url);
    }

    @FindBy(xpath = "//table[@class='infobox vcard']")
    private WebElement infoBlock;

    // Use if needing to obtain name of new publisher
    @FindBy(xpath = "//table[@class='infobox vcard']//caption")
    private WebElement companyName;

    @FindBy(xpath = "//h1[@id='firstHeading']")
    private WebElement companyNameByHeading;

    // Use if needing to obtain location of new publisher
    // Location of country pubHeadquartersByClass aren't uniform across info blocks
    @FindBy(xpath = "//table[@class='infobox vcard']//tr/td/span[@class='country-name']")
    private WebElement pubHeadquartersByClass;

    @FindBy(xpath = "//table[@class='infobox vcard']//tr//td[@class='label']/a[last()]")
    private WebElement pubHeadquartersByLink;

    @FindBy(xpath = "//table[@class='wikitable sortable jquery-tablesorter']/tbody/tr")
    private List<WebElement> publishers;

    @FindBy(xpath = "//table[@class='wikitable sortable jquery-tablesorter']")
    private List<WebElement> developerTables;

    public WebElement getInfoBlock() {
        return infoBlock;
    }

    public WebElement getCompanyName() {
        return companyName;
    }

    public WebElement getCompanyNameByHeading() {
        return companyNameByHeading;
    }

    public WebElement getPubHeadquartersByClass() {
        return pubHeadquartersByClass;
    }

    public WebElement getPubHeadquartersByLink() {
        return pubHeadquartersByLink;
    }

    public List<WebElement> getPublishers() {
        return publishers;
    }

    public List<WebElement> getDeveloperTables() {
        return developerTables;
    }

    /**
     * Using web element table row obtained from publisher page, grab name from column
     */
    public String getPubName(WebElement publisherRow) {
        By pubName = By.xpath("td[1]");
        WebElement name = publisherRow.findElement(pubName);
        return name.getText();
    }

    /**
     * Using web element table row obtained from publisher page, grab country from column
     * Multiple cases where same country names vary as well as only include state and not country
     */
    public String getPubLocByTd(WebElement publisherRow) {
        By pubLocByTd = By.xpath("td[2]");
        WebElement pubLoc = publisherRow.findElement(pubLocByTd);
        String locText = pubLoc.getText().trim();

        String[] split = locText.split(",");
        String countryName = split[split.length - 1].trim();

        countryName = matchesCountryNameVariation(countryName);
        countryName = matchStateWithCountry(countryName);

        if (locText.equals("")) {
            return "N/A";
        } return countryName;
    }

    /**
     * Checks if there is a country name match, if so replace with what is stored in COUNTRY table in database
     */
    private String matchesCountryNameVariation(String country) {
        switch (country) {
            case "US":
            case "USA":
                country = "United States";
                break;
            case "UK":
                country = "United Kingdom";
                break;
            case "South Korea":
                country = "Republic of Korea";
                break;
            case "Taiwan":
                country = "Province of China Taiwan";
                break;
            case "The Netherlands":
                country = "Netherlands";
                break;
        }
        return country;
    }

    /**
     * Checks if there is a state name match, if so replace with country
     */
    private String matchStateWithCountry(String state) {
        switch (state) {
            case "Amsterdam":
                state = "Netherlands";
                break;
            case "California":
            case "Illinois":
                state = "United States";
                break;

        }
        return state;
    }

}

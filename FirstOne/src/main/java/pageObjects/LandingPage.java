package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;
    By cookiesBlock = By.xpath("//*[@id='CybotCookiebotDialog']");
    By niezBox = By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonNecessary']");
    By prefBox = By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonPreferences']");
    By statBox = By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonStatistics']");
    By markBox = By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonMarketing']");
    By allowChosen = By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowallSelection']");
    By allowAll = By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");
    By navBar = By.xpath("//*[@class='small-12 columns header-navigation-wrapper']");
    By shop = By.xpath("//*[@class='prefix']");
    By tor = By.xpath("(//*[@class='prefix'])[2]");
    By searchButton = By.xpath("//*[@class='button search-bar-toggler float-right']");
    By searchInputField = By.xpath("//*[@placeholder='Czego szukasz?']");



    public LandingPage(WebDriver driver){
        this.driver=driver;
    }
    public WebElement getCookiesBlock()
    {
        return driver.findElement(cookiesBlock);
    }
    public WebElement getNiezBox() { return driver.findElement(niezBox); }
    public WebElement getPrefBox() { return driver.findElement(prefBox); }
    public WebElement getStatBox() { return driver.findElement(statBox); }
    public WebElement getMarkBox() { return driver.findElement(markBox); }
    public WebElement getAllowChosen () { return driver.findElement(allowChosen); }
    public WebElement getAllowAll () { return driver.findElement(allowAll); }
    public WebElement getNavBar () { return driver.findElement(navBar); }
    public WebElement getShop () { return driver.findElement(shop); }
    public WebElement getTor () { return driver.findElement(tor); }
    public WebElement getSearchButton () { return driver.findElement(searchButton); }
    public WebElement getInputField () { return driver.findElement(searchInputField); }




}

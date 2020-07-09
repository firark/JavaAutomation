package carrera;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import resources.base;

import java.io.IOException;

public class acceptCookies extends base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeMethod
    public void Init() throws IOException {
        driver = initDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void validateCookies()
    {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='CybotCookiebotDialog']"),"Niniejsza strona korzysta z plików cookie"));
        LandingPage l = new LandingPage(driver);
        Assert.assertTrue(l.getNiezBox().isSelected());
        if (l.getPrefBox().isSelected()==false)
        l.getPrefBox().click();
        else
            System.out.println("PrefBox was already selected.");
        if (l.getStatBox().isSelected()==false)
        l.getStatBox().click();
        else
            System.out.println("StatBox was already selected.");
        l.getAllowChosen().click();
        Assert.assertFalse(l.getCookiesBlock().isDisplayed(),"CookiesBlock is still displayed after allowing cookies");
        log.info("CookiesBlock successfully hidden");
    }

    @AfterMethod
    public void teardown()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}

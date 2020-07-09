package carrera;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

import java.io.IOException;

public class validTorNowy extends base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeMethod
    public void Init() throws IOException {
        driver = initDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void validTorNowy() throws InterruptedException {
        LandingPage l = new LandingPage(driver);
        Assert.assertTrue(l.getNavBar().isDisplayed(), "No navigation bar. ");
        log.info("Navigation bar displayed.");
        Thread.sleep(4000);
        Actions ac = new Actions(driver);
        ac.moveToElement(l.getTor()).perform();
        ac.moveToElement(driver.findElement(By.linkText("Nowy"))).click().perform();
        Assert.assertEquals(driver.getTitle(), "Tory wyścigowe Carrera");


    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
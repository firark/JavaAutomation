package carrera;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

import java.io.IOException;

public class searchResult extends base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());

    @BeforeMethod
    public void Init() throws IOException {
        driver = initDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void searchResult() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='CybotCookiebotDialog']"),"Niniejsza strona korzysta z plików cookie"));
        LandingPage l = new LandingPage(driver);
        if (l.getMarkBox().isSelected()==false)
        l.getPrefBox().click();
        else
            System.out.println("Marketing CheckBox was already selected.");
        l.getAllowAll().click();
        Thread.sleep(1000);
        l.getSearchButton().click();
        Assert.assertTrue(l.getInputField().isDisplayed());
        l.getInputField().click();
        l.getInputField().sendKeys("paw patrol");
        l.getInputField().sendKeys(Keys.ENTER);

        int displayedAmount = driver.findElements(By.xpath("//*[@class='shop-products-tile columns end small-12 medium-4 large-3']")).size();
        String text = driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/span")).getText();
        String[] trimmedText = text.split(":");
        String amount = trimmedText[1].trim();
        Assert.assertEquals(displayedAmount, amount, "Written and displayed amounts are not equal,");


    }

    @AfterMethod
    public void teardown()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }


}

package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initDriver() throws IOException
    {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("..\\FirstOne\\src\\main\\java\\resources\\data.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","..\\FirstOne\\src\\main\\java\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browserName.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "..\\FirstOne\\src\\main\\java\\resources\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else
            System.out.println("Wrong browser ");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }

    public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException{
        TakesScreenshot ts =(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationFile));
    }


}

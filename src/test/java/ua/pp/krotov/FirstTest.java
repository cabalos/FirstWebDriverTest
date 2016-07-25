package ua.pp.krotov;

import com.thoughtworks.selenium.webdriven.ElementFinder;
import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.tools.ant.taskdefs.Sleep;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.reporters.jq.TimesPanel;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    private WebDriver driver;

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
    }

    @Test // Marking this method as part of the test
    public void gotoSeleniumWikiPage() {
        // Go to the Wikipedia home page
        driver.get("https://en.wikipedia.org/");
        // Find the text input element by its id and type "Selenium"
        driver.findElement(By.id("searchInput")).sendKeys("Selenium");
        // Click search button
        driver.findElement(By.id("searchButton")).click();
        // Get text from header of the Selenium page

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleContains("Selenium"));

        String header = driver.findElement(By.id("firstHeading")).getText();
        // Verify that header equals "Selenium"
        Assert.assertEquals(header, "Selenium");
    }

    @Test // Marking this method as part of the test
    public void gotoZ() throws InterruptedException {
        // Go to the Wikipedia home page
        driver.get("https://new.vk.com/");
        driver.findElement(By.id("index_email")).sendKeys("dezaol@ukr.net");
        driver.findElement(By.id("index_pass")).sendKeys("1111");
        driver.findElement(By.id("index_login_button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("top_profile_link")));

        driver.get("https://new.vk.com/leshchenkovolodymyr");

        String element1 = driver.getTitle();
        System.out.println(element1);

        String ActualResult = driver.findElement(By.className("page_name")).getText();
        String ExpectedResult = "Vladimir Leschenko";
        Assert.assertEquals(ActualResult, ExpectedResult);
    }

    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.quit();
    }

}
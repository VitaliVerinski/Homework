import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class testMts {
    public WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public   void testOnlineReplenishmentBlockTitle() {
        driver.get("http://mts.by");
        WebElement element = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/h2"));
        System.out.println(element.getText());
    }
    @Test
    public void testPaymentSystemLogos() {
        driver.get("http://mts.by");
        WebElement element = driver.findElement(By.className("pay__partners"));
        System.out.println(element.getText());
        Assert.assertNotNull("Логотип не найден");
    }
    @Test
    public void testMoreAboutServiceLink() {
        driver.get("http://mts.by");
        WebElement moreAboutServiceLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreAboutServiceLink.click();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assert.assertEquals("URL не соответствует ожидаемому", expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void testContinueButtonFunctionality() {
        driver.get("http://mts.by");
        driver.findElements(By.linkText("Продолжить"));
        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys("297777777");
        WebElement pay = driver.findElement(By.id("connection-sum"));
        pay.sendKeys("10");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
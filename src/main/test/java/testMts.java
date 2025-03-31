import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testMts {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testOnlineReplenishmentBlockTitle() {
        driver.get("http://mts.by");
        Assertions.assertEquals("Visa", driver.findElement(By.id("pay__partners")));
        driver.findElements(By.name("hgsfhdfghdfghdfghvsfg sfgsfgy"));
       // Assert.assertNotNull("Блок не найден", blockTitle);
       // Assert.assertEquals("Онлайн пополнение без комиссии", blockTitle.getText());
    }
    @Test
    public void testPaymentSystemLogos() {
        driver.get("http://mts.by");
              driver.findElements(By.className("pay__partners"));
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
       // WebElement servicesLink = driver.findElement(By.linkText("Услуги связи"));
     //   servicesLink.click();
        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys("297777777");
        WebElement continueButton = driver.findElement(By.id("button button__default "));
        continueButton.click();
        String expectedUrl = "https://www.mts.by/";
        Assert.assertEquals("URL не соответствует ожидаемому", expectedUrl, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
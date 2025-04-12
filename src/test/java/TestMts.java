import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestMts {
    public WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://mts.by");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Принять']"))).click();
    }

    @Test
    public void testOnlineReplenishmentBlockTitle() {
        WebElement titleElement = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        String titleText = titleElement.getText();
        System.out.println(titleText);
        String expectedTitle = "Онлайн пополнение\n" +
                "без комиссии";
        Assert.assertEquals("Заголовок не соответствует ожидаемому", expectedTitle, titleText);
    }

    @Test
    public void testPaymentSystemLogos() {
        List<WebElement> logos = driver.findElements(By.cssSelector("#pay-section .payment-logos img"));
        String[] expectedAlts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (int i = 0; i < logos.size(); i++) {
            String altText = logos.get(i).getAttribute("alt");
            System.out.println("Логотип " + (i + 1) + ": " + altText);
            Assert.assertEquals(expectedAlts[i], altText);
        }
    }

    @Test
    public void testMoreAboutServiceLink() {
        WebElement moreAboutServiceLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
        moreAboutServiceLink.click();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        System.out.println("Текущий URL: " + driver.getCurrentUrl());
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
        String titleText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("breadcrumbs__list"))).getText();
        System.out.println("Заголовок страницы: " + titleText);
    }

    @Test
    public void testContinueButtonFunctionality() {
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
        phoneNumberField.sendKeys("297777777");
        WebElement payField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-sum")));
        payField.sendKeys("10");
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-connection']/button")));
        continueButton.click();
        WebElement frameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[8]/div/iframe")));
        driver.switchTo().frame(frameElement);
        WebElement cardPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card-page__card")));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
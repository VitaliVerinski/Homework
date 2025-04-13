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
    private MtsPage mtsPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mts.by");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Принять']"))).click();
        mtsPage = new MtsPage(driver);
    }

    @Test
    public void testOnlineReplenishmentBlockTitle() {
        String titleText = mtsPage.getOnlineReplenishmentBlockTitle();
        System.out.println(titleText);

        String expectedTitle = "Онлайн пополнение\n" +
                "без комиссии";

        Assert.assertEquals("Заголовок не соответствует ожидаемому", expectedTitle, titleText);
    }

    @Test
    public void testPaymentSystemLogos() {
        List<WebElement> logos = mtsPage.getPaymentSystemLogos();

        String[] expectedAlts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};

        for (int i = 0; i < logos.size(); i++) {
            String altText = logos.get(i).getAttribute("alt");
            System.out.println("Логотип " + (i + 1) + ": " + altText);
            Assert.assertEquals(expectedAlts[i], altText);
        }
    }

    @Test
    public void testMoreAboutServiceLink() {
            mtsPage.clickMoreAboutServiceLink();

            String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

            System.out.println("Текущий URL: " + driver.getCurrentUrl());

            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

            String titleText = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("breadcrumbs__list"))).getText();

            System.out.println("Заголовок страницы: " + titleText);
    }

            @Test
    public void testContinueButtonFunctionality() {
                mtsPage.enterPhoneNumber("297777777");
                mtsPage.enterPaymentAmount("10");
                mtsPage.clickContinueButton();
                mtsPage.switchToFrame();
                WebElement cardPage = mtsPage.getCardPage();
            }
    @Test
    public void communicationServices() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterPaymentAmount("10");
        mtsPage.clickContinueButton();
        mtsPage.switchToFrame();
        mtsPage.communicationService("3425 345345 34534", "1226");
    }

    @Test
    public void homeInternet () {
        mtsPage.homeInternet("297777777", "10");
    }
    @Test
    public void installment () {
        mtsPage.installment("7777777777", "100");
    }
    @Test
    public void debt () {
        mtsPage.debt("77777777", "100");
    }

    @Test
    public void testClickNumber() {
        mtsPage.ClickNumber("297777777", "100");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
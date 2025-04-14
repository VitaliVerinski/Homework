import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestMts1 {

    public WebDriver driver;

    private MtsPage1 mtsPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mts.by");
        mtsPage = new MtsPage1(driver);
        mtsPage.acceptCookies();
    }

    @Test
    public void testOnlineReplenishmentBlockTitle() {
        String titleText = mtsPage.getOnlineReplenishmentTitle();
        System.out.println(titleText);
        String expectedTitle = "Онлайн пополнение\n" +
                "без комиссии";
        Assert.assertEquals("Заголовок не соответствует ожидаемому", expectedTitle, titleText);
    }

    @Test
    public void testPaymentSystemLogos() {
        String[] expectedAlts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        String[] actualAlts = mtsPage.getPaymentSystemLogos();
        for (int i = 0; i < actualAlts.length; i++) {
            System.out.println("Логотип " + (i + 1) + ": " + actualAlts[i]);
            Assert.assertEquals(expectedAlts[i], actualAlts[i]);
        }
    }

    @Test
    public void testMoreAboutServiceLink() {
        mtsPage.clickMoreAboutService();

        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        System.out.println("Текущий URL: " + mtsPage.getCurrentUrl());
        Assert.assertEquals(expectedUrl, mtsPage.getCurrentUrl());

        String titleText = mtsPage.getBreadcrumbsText();
        System.out.println("Заголовок страницы: " + titleText);
    }

    @Test
    public void testContinueButtonFunctionality() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterPaymentAmount("10");
        mtsPage.clickContinue();
        mtsPage.switchToFrame();
        mtsPage.cardNumber();
    }

    @Test
    public void communicationService() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterPaymentAmount("10");
        mtsPage.clickContinue();
        mtsPage.switchToFrame();
        mtsPage.cardNumber();
        mtsPage.period();
        mtsPage.cvc();
        mtsPage.nameCard();
        mtsPage.topSum();
        mtsPage.buttonSum();
        mtsPage.image();
    }

    @Test
    public void homeInternet() {
        mtsPage.selectArrow();
        mtsPage.homeInternet("297777777", "10");
    }

    @Test
    public void installment() {
        mtsPage.selectArrow();
        mtsPage.installment("7777777777", "100");
    }

    @Test
    public void debt() {
        mtsPage.selectArrow();
        mtsPage.debt("13213246", "100");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
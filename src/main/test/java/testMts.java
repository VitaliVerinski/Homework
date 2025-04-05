import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testMts {
    private WebDriver driver;
    private MtsPage mtsPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mtsPage = new MtsPage(driver);
        driver.get("http://mts.by");
    }

    @Test
    public void testOnlineReplenishmentBlockTitle() {
        String title = mtsPage.getOnlineReplenishmentBlockTitle();
        System.out.println(title);
    }

    @Test
    public void testPaymentSystemLogos() {
        String logos = mtsPage.getPaymentSystemLogos();
        System.out.println(logos);
        Assert.assertNotNull("Логотип не найден", logos);
    }

    @Test
    public void testMoreAboutServiceLink() {
        mtsPage.clickMoreAboutServiceLink();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assert.assertEquals("URL не соответствует ожидаемому", expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testContinueButtonFunctionality() throws InterruptedException {
        mtsPage.fillConnectionDetails("297777777", "10", "1234123412341234");
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

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
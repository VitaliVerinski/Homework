import io.qameta.allure.*;
import org.example.MtsPage1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMts1 {

    public WebDriver driver;
    private MtsPage1 mtsPage;

    @BeforeClass
    @Description("Отчет для задания 17")
    @Link("ссыылка")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mts.by");
        mtsPage = new MtsPage1(driver);
//        mtsPage.acceptCookies();
    }
    @Description("Заголовок")
    @Test
    public void testOnlineReplenishmentBlockTitle() {
        String titleText = mtsPage.getOnlineReplenishmentTitle();
        System.out.println(titleText);
        String expectedTitle = "Онлайн пополнение\n" +
                "без комиссии";
        Assert.assertEquals(titleText, expectedTitle, "Заголовок не соответствует ожидаемому");
    }
    @Description("Логотипы")
    @Test
    public void testPaymentSystemLogos() {
        String[] expectedAlts = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        String[] actualAlts = mtsPage.getPaymentSystemLogos();
        for (int i = 0; i < actualAlts.length; i++) {
            System.out.println("Логотип " + (i + 1) + ": " + actualAlts[i]);
            Assert.assertEquals(actualAlts[i], expectedAlts[i]);
        }
    }
    @Description("Подробнее о сервисе")
    @Test
    public void testMoreAboutServiceLink() {
        mtsPage.clickMoreAboutService();

        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        System.out.println("Текущий URL: " + mtsPage.getCurrentUrl());
        Assert.assertEquals(mtsPage.getCurrentUrl(), expectedUrl);

        String titleText = mtsPage.getBreadcrumbsText();
        System.out.println("Заголовок страницы: " + titleText);
    }
    @Description("Кнопка продолжить")
    @Test
    public void testContinueButtonFunctionality() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterPaymentAmount("10");
        mtsPage.clickContinue();
        mtsPage.switchToFrame();
        mtsPage.cardNumber();
    }
    @Description("Проверка услуг связи")
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
    @Description("проверка домашнего интернета")
    @Test
    public void homeInternet() {
        mtsPage.selectArrow();
        mtsPage.homeInternet("297777777", "10");
    }
    @Description("проверка рассрочки")
    @Test
    public void installment() {
        mtsPage.selectArrow();
        mtsPage.installment("7777777777", "100");
    }
    @Description("проверка задолженности")
    @Test
    public void debt() {
        mtsPage.selectArrow();
        mtsPage.debt("13213246", "100");
    }
@Description("Завершение работы")
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
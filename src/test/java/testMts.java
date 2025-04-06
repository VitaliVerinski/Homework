import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testMts {
    public WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mts.by");
        WebElement button = driver.findElement(By.xpath("//*[text()='Принять']"));
        button.click();
    }
    @Test
    public   void testOnlineReplenishmentBlockTitle() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section"));
        System.out.println(element.getText());
        Assert.assertNotNull("Блок не найден", element);
        WebElement titleElement = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        String titleText = titleElement.getText();
        System.out.println(titleText);
        String expectedTitle = "Онлайн пополнение\n" +
                "без комиссии";
        Assert.assertEquals("Заголовок не соответствует ожидаемому", expectedTitle, titleText);
    }
    @Test
    public void testPaymentSystemLogos() {
        //проверка visa
        WebElement element = driver.findElement(By.className("pay__partners"));
        WebElement visa = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        String altVisa = visa.getAttribute("alt");
        System.out.println("Атрибут altVisa: " + altVisa);
        String expectedVisa = "Visa"; // Замените на ожидаемое значение
        Assert.assertEquals("Атрибут alt не соответствует ожидаемому", expectedVisa, altVisa);
        //проверка Verified By Visa
        WebElement verifiedByVisa = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img"));
        String altVerifiedByVisa = verifiedByVisa.getAttribute("alt");
        System.out.println("Атрибут altVerifiedByVisa: " + altVerifiedByVisa);
        String expectedVerifiedByVisa = "Verified By Visa"; // Замените на ожидаемое значение
        Assert.assertEquals("Атрибут alt не соответствует ожидаемому", expectedVerifiedByVisa, altVerifiedByVisa);
        System.out.println(element.getText());
        //проверка MasterCard
        WebElement master = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img"));
        String altMaser = master.getAttribute("alt");
        System.out.println("Атрибут MasterCard: " + altMaser);
        String expectedMaser = "MasterCard"; // Замените на ожидаемое значение
        Assert.assertEquals("Атрибут alt не соответствует ожидаемому", expectedMaser, altMaser);
        System.out.println(element.getText());
        //проверка Verified By MasterCard Secure Code
        WebElement masterSecure = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img"));
        String altMasterSecure = masterSecure.getAttribute("alt");
        System.out.println("Атрибут MasterCard: " + altMasterSecure);
        String expectedMaserSecure = "MasterCard Secure Code"; // Замените на ожидаемое значение
        Assert.assertEquals("Атрибут alt не соответствует ожидаемому", expectedMaserSecure, altMasterSecure);
        System.out.println(element.getText());
        //проверка Белкарт
        WebElement bel = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img"));
        String altBel = bel.getAttribute("alt");
        System.out.println("Атрибут MasterCard: " + altBel);
        String expectedBel = "Белкарт"; // Замените на ожидаемое значение
        Assert.assertEquals("Атрибут alt не соответствует ожидаемому", expectedBel, altBel);
        System.out.println(element.getText());
    }
    @Test
    public void testMoreAboutServiceLink() {
        //проверка Url
        WebElement moreAboutServiceLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreAboutServiceLink.click();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        Assert.assertEquals("URL не соответствует ожидаемому", expectedUrl, driver.getCurrentUrl());
        //проверка открывшейся страницы
        WebElement titleElement = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/h3[1]"));
        String titleText = titleElement.getText();
        System.out.println(titleText);
        String expectedTitle = "Оплата банковской картой";
        Assert.assertEquals("текст не соответствует ожидаемому", expectedTitle, titleText);
    }
    @Test
    public void testContinueButtonFunctionality() throws InterruptedException {
        //проверка заполнения полей, нажатия на кнопку, открытия фрейма
        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys("297777777");
        WebElement pay = driver.findElement(By.id("connection-sum"));
        pay.sendKeys("10");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
        Thread.sleep(5000);
        WebElement frameElement = driver.findElement(By.xpath("/html/body/div[8]/div/iframe"));
        driver.switchTo().frame(frameElement);
        Assert.assertNotNull("Фрейм не найден", frameElement);
        WebElement number = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));
        Assert.assertNotNull("номер телефона не найден", number);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
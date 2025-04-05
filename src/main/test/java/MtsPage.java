import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MtsPage {
    private WebDriver driver;

    public MtsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для получения заголовка блока пополнения
    public String getOnlineReplenishmentBlockTitle() {
        WebElement element = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/h2"));
        return element.getText();
    }

    // Метод для получения логотипов платежных систем
    public String getPaymentSystemLogos() {
        WebElement element = driver.findElement(By.className("pay__partners"));
        return element.getText();
    }

    // Метод для перехода по ссылке "Подробнее о сервисе"
    public void clickMoreAboutServiceLink() {
        WebElement moreAboutServiceLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreAboutServiceLink.click();
    }

    // Метод для заполнения номера телефона, суммы, нажатие кнопки продолжить и проверки всех полей
    public void fillConnectionDetails(String phoneNumber, String sum, String card) throws InterruptedException {
        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys(phoneNumber);
        WebElement pay = driver.findElement(By.id("connection-sum"));
        pay.sendKeys(sum);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
        Thread.sleep(5000);
        WebElement frameElement = driver.findElement(By.xpath("/html/body/div[8]/div/iframe"));
        driver.switchTo().frame(frameElement);
        WebElement sumTop = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span"));
        WebElement sumButton = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button"));
        WebElement numberPhone = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));
        WebElement numCard = driver.findElement(By.id("cc-number"));
        numCard.sendKeys(card);
        WebElement validityPeriod = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label"));
        WebElement CVC = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label"));
        WebElement UserCardName = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label"));
        WebElement IcoCard = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div"));
    }
    // метод заполнения рассрочки
    public void homeInternet (String internetPhone, String internetSum) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//p[@class='select__option' and contains(text(), 'Домашний интернет')]"));
        element1.click();
        WebElement number = driver.findElement(By.id("internet-phone"));
        number.sendKeys(internetPhone);
        WebElement sum = driver.findElement(By.id("internet-sum"));
        sum.sendKeys(internetSum);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-internet\"]/button"));
        continueButton.click();
    }
    // метод заполнения домашнего интернета
    public void installment (String accountNumber, String instalmentSum) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//p[@class='select__option' and contains(text(), 'Рассрочка')]"));
        element1.click();
        WebElement number = driver.findElement(By.id("score-instalment"));
        number.sendKeys(accountNumber);
        WebElement sum = driver.findElement(By.id("instalment-sum"));
        sum.sendKeys(instalmentSum);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-instalment\"]/button"));
        continueButton.click();
    }
    // метод заполнения задолженности
    public void debt (String numberAccount, String debtSum) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//p[@class='select__option' and contains(text(), 'Задолженность')]"));
        element1.click();
        WebElement number = driver.findElement(By.id("score-arrears"));
        number.sendKeys(numberAccount);
        WebElement sum = driver.findElement(By.id("arrears-sum"));
        sum.sendKeys(debtSum);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-arrears\"]/button"));
        continueButton.click();

    }
}
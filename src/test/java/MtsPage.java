import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By titleLocator = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/h2");
    private By logosLocator = By.cssSelector("#pay-section .payment-logos img");
    private By moreAboutServiceLinkLocator = By.linkText("Подробнее о сервисе");
    private By phoneNumberFieldLocator = By.id("connection-phone");
    private By payFieldLocator = By.id("connection-sum");
    private By continueButtonLocator = By.xpath("//*[@id='pay-connection']/button");
    private By frameLocator = By.xpath("/html/body/div[8]/div/iframe");
    private By cardPageLocator = By.className("card-page__card");
    private By cardLocator = By.id("cc-number");
    private By periodLocator = By.xpath("//*[@placeholder='MM / YY']");
    private By cscLocator = By.xpath("//*[@autocomplete='cc-csc]");
    private By ccnameLocarot = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/input");





    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getOnlineReplenishmentBlockTitle() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        return titleElement.getText();
    }

    // Метод для получения логотипов платежных систем
    public List<WebElement> getPaymentSystemLogos() {
        return driver.findElements(logosLocator);
    }

    // Метод для перехода по ссылке "Подробнее о сервисе"
    public void clickMoreAboutServiceLink() {
        WebElement moreAboutServiceLink = wait.until(ExpectedConditions.elementToBeClickable(moreAboutServiceLinkLocator));
        moreAboutServiceLink.click();
    }
    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberFieldLocator));
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void enterPaymentAmount(String amount) {
        WebElement payField = wait.until(ExpectedConditions.visibilityOfElementLocated(payFieldLocator));
        payField.sendKeys(amount);
    }

    public void clickContinueButton() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
        continueButton.click();
    }

    public void switchToFrame() {
        driver.switchTo().frame(wait.until(ExpectedConditions.presenceOfElementLocated(frameLocator)));
    }

    public WebElement getCardPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardPageLocator));
    }
    public void communicationService(String amount, String period) {
        WebElement payField = wait.until(ExpectedConditions.visibilityOfElementLocated(cardLocator));
        payField.sendKeys(amount);
        WebElement validPeriod = wait.until(ExpectedConditions.visibilityOfElementLocated(periodLocator));
        validPeriod.sendKeys(period);
    }
    public void ClickNumber(String number, String sum) {
        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys(number);
        WebElement pay = driver.findElement(By.id("connection-sum"));
        pay.sendKeys(sum);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
        WebElement frameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(frameLocator));
        driver.switchTo().frame(frameElement);
        WebElement info1 = driver.findElement(By.xpath("//*[@class='pay-description__cost']"));
        System.out.println(info1.getText());
        WebElement info2 = driver.findElement(By.xpath("//*[@id='cc-number']"));
        System.out.println(info2.getText());
        WebElement info3 = driver.findElement(By.xpath("//*[@placeholder='MM / YY']"));
        System.out.println(info3.getText());
       // WebElement info4 = wait.until(ExpectedConditions.visibilityOfElementLocated(cscLocator));
        WebElement info4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cc-number")));
        System.out.println(info4.getText());
        WebElement info5 = wait.until(ExpectedConditions.visibilityOfElementLocated(ccnameLocarot));
        System.out.println(info5.getText());
    }
    // Метод для заполнения номера телефона, суммы, нажатие кнопки продолжить и проверки всех полей
    public void fillConnectionDetails(String phoneNumber, String sum, String card) {
        WebElement phoneNumberField = driver.findElement(By.id("connection-phone"));
        phoneNumberField.sendKeys(phoneNumber);
        WebElement pay = driver.findElement(By.id("connection-sum"));
        pay.sendKeys(sum);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
        WebElement frameElement = driver.findElement(By.xpath("/html/body/div[8]/div/iframe"));
        driver.switchTo().frame(frameElement);
        WebElement sumTop = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span"));
        WebElement sumButton = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button"));
        WebElement numberPhone = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span"));
        WebElement numCard = driver.findElement(By.id("cc-number"));
        numCard.sendKeys(card);
      //  WebElement validityPeriod = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label"));
        WebElement CVC = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label"));
        WebElement userCardName = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label"));
        WebElement icoCard = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div"));
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
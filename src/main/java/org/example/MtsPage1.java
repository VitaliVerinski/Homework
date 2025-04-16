package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsPage1 {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы
    private By acceptButton = By.xpath("//*[text()='Принять']");
    private By onlineReplenishmentTitle = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    private By paymentLogos = By.cssSelector("#pay-section .payment-logos img");
    private By moreAboutServiceLink = By.linkText("Подробнее о сервисе");
    private By phoneNumberField = By.id("connection-phone");
    private By payField = By.id("connection-sum");
    private By continueButton = By.xpath("//*[@id='pay-connection']/button");
    private By breadcrumbsList = By.className("breadcrumbs__list");
    private By frameLocator = By.xpath("/html/body/div[8]/div/iframe");
    private By cardLocator = By.id("cc-number");
    private By periodLocator = By.xpath("//*[@placeholder='MM / YY']");
    private By cvcLocator = By.name("verification_value");
    private By nameCardLocator = By.cssSelector("[formControlName='holder']");
    private By topSumLocator = By.className("pay-description__cost");
    private By buttonSumLocator = By.cssSelector("button.colored.disabled");
    private By selectArrowLocator = By.className("select__arrow");
    private By nameDebtLocator = By.id("score-arrears");
    private By internetPhoneLocator = By.id("internet-phone");
    private By scoreInstalmetLocator = By.id("score-instalment");

    public MtsPage1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void image() {
        WebElement img = driver.findElement(By.cssSelector("img.ng-tns-c891095944-0"));
        Assert.assertTrue("Изображение должно быть отображено", img.isDisplayed());
    }

    public void buttonSum() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSumLocator)).getText();
        WebElement button = driver.findElement(By.cssSelector("button.colored.disabled"));
        String buttonText = button.getText().trim();
        Assert.assertEquals("Неверный текст кнопки", "Оплатить 10.00 BYN", buttonText);
        System.out.println(buttonText);
    }

    public void topSum() {
        wait.until(ExpectedConditions.elementToBeClickable(topSumLocator)).getText();
        WebElement label = driver.findElement(By.className("pay-description__cost"));
        String labelText = label.getText();
        Assert.assertEquals("Неверный текст метки", "10.00 BYN", labelText);
        System.out.println(labelText);
    }

    public void nameCard() {
        wait.until(ExpectedConditions.elementToBeClickable(nameCardLocator)).getText();
        WebElement label = driver.findElement(By.cssSelector("label.ng-tns-c2312288139-3"));
        String labelText = label.getText();
        Assert.assertEquals("Неверный текст метки", "Имя держателя (как на карте)", labelText);
        System.out.println(labelText);
    }

    public void cvc() {
        wait.until(ExpectedConditions.elementToBeClickable(cvcLocator)).getText();
        WebElement label = driver.findElement(By.cssSelector("label.ng-tns-c2312288139-5"));
        String labelText = label.getText();
        Assert.assertEquals("Неверный текст метки", "CVC", labelText);
        System.out.println(labelText);
    }

    public void period() {
        wait.until(ExpectedConditions.elementToBeClickable(periodLocator)).getText();
        WebElement label = driver.findElement(By.cssSelector("label.ng-tns-c2312288139-4"));
        String labelText = label.getText();
        Assert.assertEquals("Неверный текст метки", "Срок действия", labelText);
        System.out.println(labelText);
    }

    public void cardNumber() {
        wait.until(ExpectedConditions.elementToBeClickable(cardLocator)).getText();
        WebElement label = driver.findElement(By.cssSelector("label.ng-tns-c2312288139-1"));
        String labelText = label.getText();
        Assert.assertEquals("Неверный текст метки", "Номер карты", labelText);
        System.out.println(labelText);
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();
    }

    public String getOnlineReplenishmentTitle() {
        return driver.findElement(onlineReplenishmentTitle).getText();
    }

    public String[] getPaymentSystemLogos() {
        List<WebElement> logos = driver.findElements(paymentLogos);
        String[] alts = new String[logos.size()];
        for (int i = 0; i < logos.size(); i++) {
            alts[i] = logos.get(i).getAttribute("alt");
        }
        return alts;
    }

    public void clickMoreAboutService() {
        wait.until(ExpectedConditions.elementToBeClickable(moreAboutServiceLink)).click();
    }

    public void selectArrow() {
        wait.until(ExpectedConditions.elementToBeClickable(selectArrowLocator)).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getBreadcrumbsText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(breadcrumbsList)).getText();
    }

    public void enterPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberField)).sendKeys(phoneNumber);
    }

    public void enterPaymentAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(payField)).sendKeys(amount);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void frameLocator() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public void switchToFrame() {
        driver.switchTo().frame(wait.until(ExpectedConditions.presenceOfElementLocated(frameLocator)));
    }

    // метод заполнения рассрочки
    public void homeInternet(String internetPhone, String internetSum) {
        WebElement element1 = driver.findElement(By.xpath("//p[@class='select__option' and contains(text(), 'Домашний интернет')]"));
        element1.click();
        wait.until(ExpectedConditions.elementToBeClickable(internetPhoneLocator)).getText();
        WebElement number = driver.findElement(By.id("internet-phone"));
        number.sendKeys(internetPhone);
        WebElement sum = driver.findElement(By.id("internet-sum"));
        sum.sendKeys(internetSum);
        String numberPlaceholder = number.getAttribute("placeholder");
        String sumPlaceholder = sum.getAttribute("placeholder");
        System.out.println("Плейсхолдер для номера карты: " + numberPlaceholder);
        System.out.println("Плейсхолдер для номера суммы: " + sumPlaceholder);
        // почему-то сайт перестал принимать рандомные данные (может подключили базу данных для сверки) WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-internet\"]/button"));
        //  continueButton.click();
    }

    // метод заполнения домашнего интернета
    public void installment(String accountNumber, String instalmentSum) {
        WebElement element1 = driver.findElement(By.xpath("//p[@class='select__option' and contains(text(), 'Рассрочка')]"));
        element1.click();
        wait.until(ExpectedConditions.elementToBeClickable(scoreInstalmetLocator)).getText();
        WebElement number = driver.findElement(By.id("score-instalment"));
        number.sendKeys(accountNumber);
        WebElement sum = driver.findElement(By.id("instalment-sum"));
        sum.sendKeys(instalmentSum);
        String numberPlaceholder = number.getAttribute("placeholder");
        String sumPlaceholder = sum.getAttribute("placeholder");
        System.out.println("Плейсхолдер для номера карты: " + numberPlaceholder);
        System.out.println("Плейсхолдер для номера суммы: " + sumPlaceholder);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-instalment\"]/button"));
        continueButton.click();
    }

    // метод заполнения задолженности
    public void debt(String numberAccount, String debtSum) {
        WebElement element1 = driver.findElement(By.xpath("//p[@class='select__option' and contains(text(), 'Задолженность')]"));
        element1.click();
        wait.until(ExpectedConditions.elementToBeClickable(nameDebtLocator)).getText();
        WebElement number = driver.findElement(By.id("score-arrears"));
        number.sendKeys(numberAccount);
        WebElement sum = driver.findElement(By.id("arrears-sum"));
        sum.sendKeys(debtSum);
        String numberPlaceholder = number.getAttribute("placeholder");
        String sumPlaceholder = sum.getAttribute("placeholder");
        System.out.println("Плейсхолдер для номера карты: " + numberPlaceholder);
        System.out.println("Плейсхолдер для номера суммы: " + sumPlaceholder);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-arrears\"]/button"));
        continueButton.click();
    }
}
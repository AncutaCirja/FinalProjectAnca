package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFunctionalityPage extends BasePage {
    public LoginFunctionalityPage(WebDriver driver) {
        super(driver);
    }

    By blackLoginButton = By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/span/span/span/button");
    public void clickOnBlackLoginButton() {
        driver.findElement(blackLoginButton).click();
    }

    By afterLoginBlackLoginButton = By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/span/span/button");
    public void clickOnAfterLoginBlackLoginButton() {
        driver.findElement(afterLoginBlackLoginButton).click();
    }

    By usernameBox = By.id("user-name");
    public void insertFirstValidUsername() {
        driver.findElement(usernameBox).sendKeys("dino");
    }

    public void insertSecondValidUsername() {
        driver.findElement(usernameBox).sendKeys("beetle");
    }

    public void insertThirdValidUsername() {
        driver.findElement(usernameBox).sendKeys("turtle");
    }

    public void insertFourthValidUsername() {
        driver.findElement(usernameBox).sendKeys("locked");
    }

    public void insertInvalidUsername() {
        driver.findElement(usernameBox).sendKeys("userless");
    }

    By passwordBox = By.id("password");
    public void insertValidPassword() {
        driver.findElement(passwordBox).sendKeys("choochoo");
    }

    public void insertInvalidPassword() {
        driver.findElement(passwordBox).sendKeys("asdasdasd");
    }

    By loginButton = By.xpath("/html/body/div[3]/div/div/div[2]/div/form/button");
    public void clickontheloginbutton() {
        driver.findElement(loginButton).click();
    }

    By close = By.xpath("/html/body/div[3]/div/div/div[1]/button");
    public void clickClose() {
        driver.findElement(close).click();
    }


}

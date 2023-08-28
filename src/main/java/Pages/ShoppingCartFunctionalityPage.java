package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartFunctionalityPage extends BasePage {
    public ShoppingCartFunctionalityPage(WebDriver driver) {
        super(driver);
    }

    By shoppingCartButton = By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/span/a[1]");
    public void clickOnTheShoppingCartButton() {
        driver.findElement(shoppingCartButton).click();
    }

    By addItemToTheShoppingCartButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/button[1]");
    public void clickOnAddItemToTheShoppingCartButton() {
        driver.findElement(addItemToTheShoppingCartButton).click();
    }

    By removeItemFromYourCart = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/div/div[5]/button");
    public void clickOnRemoveItemFromYourCart() {
        driver.findElement(removeItemFromYourCart).click();
    }

    By continueShopping = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/a[1]");
    public void clickOnContinueShopping() {
        driver.findElement(continueShopping).click();
    }

    By checkout = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/a[2]");
    public void clickOnCheckout() {
        driver.findElement(checkout).click();
    }

    By firstNameBox = By.id("first-name");
    public void insertUserName() {
        driver.findElement(firstNameBox).sendKeys("userName");
    }

    By lastNameBox = By.id("last-name");
    public void insertLastName() {
        driver.findElement(lastNameBox).sendKeys("userLastName");
    }

    By addressBox = By.id("address");
    public void insertAddress() {
        driver.findElement(addressBox).sendKeys("UserAddress");
    }

    By continueCheckoutButton = By.xpath("/html/body/div/div/div[2]/form/div/div[2]/button");
    public void clickOnTheContinueCheckoutButton() {
        driver.findElement(continueCheckoutButton).click();
    }

    By completeYourOrderButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/a[2]");
    public void clickOnTheCompleteYourOrderButton() {
        driver.findElement(completeYourOrderButton).click();
    }

    By homeButton = By.xpath("/html/body/div/div/div[1]/nav/a");
    public void clickOnTheHomeButton() {
        driver.findElement(homeButton).click();
    }
}

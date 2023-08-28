package TestCasess;

import Pages.BasePage;
import Pages.ShoppingCartFunctionalityPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShoppingCartFunctionalityTestCases extends BasePage {
    private ShoppingCartFunctionalityPage shoppingCartFunctionalityTestCases;

    @BeforeClass
    public void setUp() {
        super.setUp();
        shoppingCartFunctionalityTestCases = new ShoppingCartFunctionalityPage(driver);
    }

    @Test
    public void checkIfTheShoppingCartButtonIsDisplayed() {
        WebElement shoppingCartButton = driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/span/a[1]"));
        Assert.assertTrue(shoppingCartButton.isDisplayed());
    }

    @Test
    public void checkTheFunctionalityOfTheShoppingCartButton() {
        shoppingCartFunctionalityTestCases.clickOnTheShoppingCartButton();
        WebElement yourCart = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/div/h1/small"));
        Assert.assertTrue(yourCart.isDisplayed());
        driver.navigate().back();
    }

    @Test
    public void addAnItemToCartAndCheckIfIsAdded() {
        shoppingCartFunctionalityTestCases.clickOnAddItemToTheShoppingCartButton();
        shoppingCartFunctionalityTestCases.clickOnTheShoppingCartButton();
        WebElement itemInCart = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]"));
        Assert.assertTrue(itemInCart.isDisplayed());
        shoppingCartFunctionalityTestCases.clickOnRemoveItemFromYourCart();
    }

    @Test
    public void removeAnItemFromTheCart() {
        shoppingCartFunctionalityTestCases.clickOnAddItemToTheShoppingCartButton();
        shoppingCartFunctionalityTestCases.clickOnTheShoppingCartButton();
        shoppingCartFunctionalityTestCases.clickOnRemoveItemFromYourCart();
        try {
            WebElement itemInTheCart = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/div"));
            Assert.fail("Item was not removed from the cart!");
        } catch (NoSuchElementException e) {
            System.out.println("Item was successfully removed from the cart.");
        }
    }

    @Test
    public void continueShoppingButtonFunctionality() {
        shoppingCartFunctionalityTestCases.clickOnAddItemToTheShoppingCartButton();
        shoppingCartFunctionalityTestCases.clickOnTheShoppingCartButton();
        shoppingCartFunctionalityTestCases.clickOnContinueShopping();
        WebElement productsOnHomePage = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/div/h1/small"));
        Assert.assertTrue(productsOnHomePage.isDisplayed());
        shoppingCartFunctionalityTestCases.clickOnTheShoppingCartButton();
        shoppingCartFunctionalityTestCases.clickOnRemoveItemFromYourCart();
        driver.navigate().back();
    }

    @Test
    public void checkoutButtonFunctionality() {
        shoppingCartFunctionalityTestCases.clickOnAddItemToTheShoppingCartButton();
        shoppingCartFunctionalityTestCases.clickOnTheShoppingCartButton();
        shoppingCartFunctionalityTestCases.clickOnCheckout();
        WebElement yourInformation = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/h1/small"));
        Assert.assertTrue(yourInformation.isDisplayed());
        driver.navigate().back();
        shoppingCartFunctionalityTestCases.clickOnRemoveItemFromYourCart();
        driver.navigate().back();
    }

    @Test
    public void purchasingFunctionality() {
        shoppingCartFunctionalityTestCases.clickOnAddItemToTheShoppingCartButton();
        shoppingCartFunctionalityTestCases.clickOnTheShoppingCartButton();
        shoppingCartFunctionalityTestCases.clickOnCheckout();
        shoppingCartFunctionalityTestCases.insertUserName();
        shoppingCartFunctionalityTestCases.insertLastName();
        shoppingCartFunctionalityTestCases.insertAddress();
        shoppingCartFunctionalityTestCases.clickOnTheContinueCheckoutButton();
        shoppingCartFunctionalityTestCases.clickOnTheCompleteYourOrderButton();
        WebElement orderComplete = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/div/h1/small"));
        Assert.assertTrue(orderComplete.isDisplayed());
        shoppingCartFunctionalityTestCases.clickOnTheHomeButton();
    }
}

package TestCasess;

import Pages.BasePage;
import Pages.WishListFunctionalityPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WishListFunctionalityTestCases extends BasePage {
    private WishListFunctionalityPage wishListFunctionalityTestCases;

    @BeforeClass
    public void setUp() {
        super.setUp();
        wishListFunctionalityTestCases = new WishListFunctionalityPage(driver);
    }

    @Test
    public void checkIfTheWishlistButtonIsDisplayed() {
        WebElement wishListButton = driver.findElement(By.xpath("//*[@id=\"responsive-navbar-nav\"]/div[2]/span/a[2]"));
        Assert.assertTrue(wishListButton.isDisplayed());
    }

    @Test
    public void checkTheFunctionalityOfTheWishlistButton() {
        wishListFunctionalityTestCases.clickOnTheWishlistButton();
        WebElement wishlist = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/div/h1/small"));
        Assert.assertTrue(wishlist.isDisplayed());
    }

    @Test
    public void addAnItemToTheWishlistAndCheckIfIsAdded() {
        wishListFunctionalityTestCases.clickOnAddItemToWishList();
        wishListFunctionalityTestCases.clickOnTheWishlistButton();
        WebElement itemInTheWishlist = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div/div"));
        Assert.assertTrue(itemInTheWishlist.isDisplayed());
    }

    @Test
    public void removeAnItemFromWishlist() {
        wishListFunctionalityTestCases.clickOnRemoveAnItemFromWishlistButton();
        try {
            WebElement itemInTheWishlist = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div/div"));
            Assert.fail("Item was not removed from the wishlist!");
        } catch (NoSuchElementException e) {
            System.out.println("Item was successfully removed from the wishlist.");
        }
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListFunctionalityPage extends BasePage {
    public WishListFunctionalityPage(WebDriver driver) {
        super(driver);
    }

    By wishlistButton = By.xpath("//*[@id=\"responsive-navbar-nav\"]/div[2]/span/a[2]");
    public void clickOnTheWishlistButton() {
        driver.findElement(wishlistButton).click();
    }

    By addItemToWishList = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/button[2]");
    public void clickOnAddItemToWishList() {
        driver.findElement(addItemToWishList).click();
    }

    By removeAnItemFromWishlistButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div/div/div[2]/button[2]");
    public void clickOnRemoveAnItemFromWishlistButton() {
        driver.findElement(removeAnItemFromWishlistButton).click();
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFunctionalityPage extends BasePage {
    public SearchFunctionalityPage(WebDriver driver) {
        super(driver);
    }

    By searchBar = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/form/div[1]/input");
    public void clickOnTheSearchBar() {
        driver.findElement(searchBar).click();
    }

    public void insertAnInvalidProductIntoSearchBar() {
        driver.findElement(searchBar).sendKeys("unique product");
    }

    public void insertAnValidProductIntoSearchBar() {
        driver.findElement(searchBar).sendKeys("awesome");
    }


    By searchButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/form/div[1]/button");
    public void clickOnTheSearchButton() {
        driver.findElement(searchButton).click();
    }
}

package TestCasess;

import Pages.BasePage;
import Pages.SearchFunctionalityPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchFunctionalityTestCases extends BasePage {
    private SearchFunctionalityPage searchFunctionalityTestCases;

    @BeforeClass
    public void setUp() {
        super.setUp();
        searchFunctionalityTestCases = new SearchFunctionalityPage(driver);
    }

    @Test
    public void checkIfTheSearchButtonIsDisplayed() {
        WebElement searchButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/form/div[1]/button"));
        Assert.assertTrue(searchButton.isDisplayed());
    }

    @Test
    public void checkIfTheSearchBarIsDisplayed() {
        WebElement searchBar = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/form/div[1]/input"));
        Assert.assertTrue(searchBar.isDisplayed());
    }

    @Test
    public void searchFunctionalityUsingAnValidProduct() {
        searchFunctionalityTestCases.clickOnTheSearchBar();
        searchFunctionalityTestCases.insertAnValidProductIntoSearchBar();
        searchFunctionalityTestCases.clickOnTheSearchButton();
        try {
            WebElement searchResults = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div"));
            Assert.assertTrue(searchResults.isDisplayed(), "Search results are displayed.");
        } catch (NoSuchElementException e) {
            Assert.fail("No search results found!");
        }
        driver.navigate().refresh();
    }

    @Test
    public void searchFunctionalityUsingAnINValidProduct() {
        searchFunctionalityTestCases.clickOnTheSearchBar();
        searchFunctionalityTestCases.insertAnInvalidProductIntoSearchBar();
        searchFunctionalityTestCases.clickOnTheSearchButton();
        try {
            WebElement searchResults = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div"));
            Assert.fail("Search results are displayed.");
        } catch (NoSuchElementException e) {
            System.out.println("No valid search results found!");
        }
        driver.navigate().refresh();
    }
}

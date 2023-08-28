package TestCasess;

import Pages.BasePage;
import Pages.DropdownListFunctionalityPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DropdownListButtonFunctionalityTestCases extends BasePage {
    private DropdownListFunctionalityPage dropdownListButtonFunctionalityTestCases;

    @BeforeClass
    public void setUp() {
        super.setUp();
        dropdownListButtonFunctionalityTestCases = new DropdownListFunctionalityPage(driver);
    }

    @Test
    public void checkIfTheDropdownListButtonIsDisplayed() {
        WebElement dropdownListButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/form/div[2]/select"));
        Assert.assertTrue(dropdownListButton.isDisplayed());
    }

    @Test
    public void checkTheFunctionalityOfTheDropdownListButton() {
        dropdownListButtonFunctionalityTestCases.clickOnTheDropdownListButton();
        WebElement firstItemInDropdownList = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/form/div[2]/select/option[1]"));
        Assert.assertTrue(firstItemInDropdownList.isDisplayed());
        WebElement secondItemDropdownList = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/form/div[2]/select/option[2]"));
        Assert.assertTrue(secondItemDropdownList.isDisplayed());
        WebElement thirdItemInDropdownList = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/form/div[2]/select/option[3]"));
        Assert.assertTrue(thirdItemInDropdownList.isDisplayed());
        WebElement fourthItemInDropdownList = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/form/div[2]/select/option[4]"));
        Assert.assertTrue(fourthItemInDropdownList.isDisplayed());
    }

    @Test
    public void testSortingAZ() {
        dropdownListButtonFunctionalityTestCases.clickOnTheDropdownListButton();
        dropdownListButtonFunctionalityTestCases.clickOnTheSecondItemInTheDropdownList();
        dropdownListButtonFunctionalityTestCases.clickOnTheFirstItemInTheDropdownList();
        List<WebElement> childs = driver.findElements(By.cssSelector(".container .card"));
        List<String> originalInventoryNameList = new ArrayList<>();
        for (int i = 0; i < childs.size(); i++) {
            String inventoryName = childs.get(i).findElement(By.cssSelector(".card-link")).getText();
            originalInventoryNameList.add(inventoryName);
        }
        List<String> sortedInventoryNameList = new ArrayList<>(originalInventoryNameList);
        Collections.sort(sortedInventoryNameList);
        Assert.assertEquals(sortedInventoryNameList, originalInventoryNameList);
    }

    @Test
    public void testSortingZA() {
        dropdownListButtonFunctionalityTestCases.clickOnTheDropdownListButton();
        dropdownListButtonFunctionalityTestCases.clickOnTheSecondItemInTheDropdownList();
        List<WebElement> childs = driver.findElements(By.cssSelector(".container .card"));
        List<String> originalInventoryNameList = new ArrayList<>();
        for (int i = 0; i < childs.size(); i++) {
            String inventoryName = childs.get(i).findElement(By.cssSelector(".card-link")).getText();
            originalInventoryNameList.add(inventoryName);
        }
        List<String> sortedInventoryNameList = new ArrayList<>(originalInventoryNameList);
        Collections.sort(originalInventoryNameList, Collections.reverseOrder());
        Assert.assertEquals(sortedInventoryNameList, originalInventoryNameList);
    }

    @Test
    public void testSortingLowToHigh() {
        dropdownListButtonFunctionalityTestCases.clickOnTheDropdownListButton();
        dropdownListButtonFunctionalityTestCases.clickOnTheThirdItemInTheDropdownList();
        List<WebElement> childs = driver.findElements(By.cssSelector(".container .card"));
        List<Double> originalInventoryPriceList = new ArrayList<>();

        for (int i = 0; i < childs.size(); i++) {
            String inventoryPrice = childs.get(i).findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/p[1]")).getText();
            double priceValue = Double.parseDouble(inventoryPrice.replace("$", ""));
            originalInventoryPriceList.add(priceValue);
        }
        List<Double> sortedInventoryPriceList = new ArrayList<>(originalInventoryPriceList);
        Collections.sort(sortedInventoryPriceList);
        Assert.assertEquals(sortedInventoryPriceList, originalInventoryPriceList);
    }

    @Test
    public void testSortingHighToLow() {
        dropdownListButtonFunctionalityTestCases.clickOnTheDropdownListButton();
        dropdownListButtonFunctionalityTestCases.clickOnTheFourthItemInTheDropdownList();
        List<WebElement> childs = driver.findElements(By.cssSelector(".container .card"));
        List<Double> originalInventoryPriceList = new ArrayList<>();

        for (int i = 0; i < childs.size(); i++) {
            String inventoryPrice = childs.get(i).findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/p[1]")).getText();
            double priceValue = Double.parseDouble(inventoryPrice.replace("$", ""));
            originalInventoryPriceList.add(priceValue);
        }
        List<Double> sortedInventoryPriceList = new ArrayList<>(originalInventoryPriceList);
        Collections.sort(originalInventoryPriceList, Collections.reverseOrder());
        Assert.assertEquals(sortedInventoryPriceList, originalInventoryPriceList);
    }
}

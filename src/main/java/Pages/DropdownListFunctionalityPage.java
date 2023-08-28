package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropdownListFunctionalityPage extends BasePage {
    public DropdownListFunctionalityPage(WebDriver driver) {
        super(driver);
    }

    By dropdownListButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/form/div[2]/select");
    public void clickOnTheDropdownListButton() {
        driver.findElement(dropdownListButton).click();
    }

    By firstItemInTheDropdownList = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/form/div[2]/select/option[1]");
    public void clickOnTheFirstItemInTheDropdownList() {
        driver.findElement(firstItemInTheDropdownList).click();
    }

    By secondItemInTheDropdownList = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/form/div[2]/select/option[2]");
    public void clickOnTheSecondItemInTheDropdownList() {
        driver.findElement(secondItemInTheDropdownList).click();
    }

    By thirdItemInTheDropdownList = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/form/div[2]/select/option[3]");
    public void clickOnTheThirdItemInTheDropdownList() {
        driver.findElement(thirdItemInTheDropdownList).click();
    }

    By fourthItemInTheDropdownList = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/form/div[2]/select/option[4]");
    public void clickOnTheFourthItemInTheDropdownList() {
        driver.findElement(fourthItemInTheDropdownList).click();
    }
}

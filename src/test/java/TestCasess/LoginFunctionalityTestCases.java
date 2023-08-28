package TestCasess;

import Pages.BasePage;
import Pages.LoginFunctionalityPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginFunctionalityTestCases extends BasePage {
    private LoginFunctionalityPage loginFunctionalityTestCases;

    @BeforeClass
    public void setUp() {
        super.setUp();
        loginFunctionalityTestCases = new LoginFunctionalityPage(driver);
    }

    @Test
    public void checkIfTheBlackLoginButtonIsDisplayed() {
        WebElement blackLoginButton = driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div/div[2]/span/span/span/button"));
        Assert.assertTrue(blackLoginButton.isDisplayed());
    }

    @Test
    public void checkTheFunctionalityOfTheBlackLoginButton() {
        loginFunctionalityTestCases.clickOnBlackLoginButton();
        WebElement login = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div"));
        Assert.assertTrue(login.isDisplayed());
        loginFunctionalityTestCases.clickClose();
    }

    @Test
    public void testWithFirstValidUsernameAndValidPassword() {
        loginFunctionalityTestCases.clickOnBlackLoginButton();
        loginFunctionalityTestCases.insertFirstValidUsername();
        loginFunctionalityTestCases.insertValidPassword();
        loginFunctionalityTestCases.clickontheloginbutton();
        String username = "dino";
        String actualUsername = driver.findElement(By.xpath("//*[@id=\"responsive-navbar-nav\"]/div[2]/span/span/span/a")).getText();
        Assert.assertEquals(actualUsername, username, "Login Successful");
        loginFunctionalityTestCases.clickOnAfterLoginBlackLoginButton();
    }

    @Test
    public void testWithSecondValidUsernameAndValidPassword() {
        loginFunctionalityTestCases.clickOnBlackLoginButton();
        loginFunctionalityTestCases.insertSecondValidUsername();
        loginFunctionalityTestCases.insertValidPassword();
        loginFunctionalityTestCases.clickontheloginbutton();
        String username = "beetle";
        String actualUsername = driver.findElement(By.xpath("//*[@id=\"responsive-navbar-nav\"]/div[2]/span/span/span/a")).getText();
        Assert.assertEquals(actualUsername, username, "Login Successful");
        loginFunctionalityTestCases.clickOnAfterLoginBlackLoginButton();
    }

    @Test
    public void testWithThirdValidUsernameAndValidPassword() {
        loginFunctionalityTestCases.clickOnBlackLoginButton();
        loginFunctionalityTestCases.insertThirdValidUsername();
        loginFunctionalityTestCases.insertValidPassword();
        loginFunctionalityTestCases.clickontheloginbutton();
        String username = "turtle";
        String actualUsername = driver.findElement(By.xpath("//*[@id=\"responsive-navbar-nav\"]/div[2]/span/span/span/a")).getText();
        Assert.assertEquals(actualUsername, username, "Login Successful");
        loginFunctionalityTestCases.clickOnAfterLoginBlackLoginButton();
    }

    @Test
    public void testWithFourthValidUsernameAndValidPassword() {
        loginFunctionalityTestCases.clickOnBlackLoginButton();
        loginFunctionalityTestCases.insertFourthValidUsername();
        loginFunctionalityTestCases.insertValidPassword();
        loginFunctionalityTestCases.clickontheloginbutton();
        String expectedErrorMessage = "The user has been locked out.";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/form/p")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
        loginFunctionalityTestCases.clickClose();
    }

    @Test
    public void testWithNoCredentials() {
        loginFunctionalityTestCases.clickOnBlackLoginButton();
        loginFunctionalityTestCases.clickontheloginbutton();
        String expectedErrorMessage = "Please fill in the username!";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/form/p")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
        loginFunctionalityTestCases.clickClose();
    }

    @Test
    public void testWithInvalidUsernameAndValidPassword() {
        loginFunctionalityTestCases.clickOnBlackLoginButton();
        loginFunctionalityTestCases.insertInvalidUsername();
        loginFunctionalityTestCases.insertValidPassword();
        loginFunctionalityTestCases.clickontheloginbutton();
        String expectedErrorMessage = "Incorrect username or password!";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/form/p")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
        loginFunctionalityTestCases.clickClose();
    }

    @Test
    public void testWithFirstValidUsernameAndInvalidPassword() {
        loginFunctionalityTestCases.clickOnBlackLoginButton();
        loginFunctionalityTestCases.insertFirstValidUsername();
        loginFunctionalityTestCases.insertInvalidPassword();
        loginFunctionalityTestCases.clickontheloginbutton();
        String expectedErrorMessage = "Incorrect username or password!";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/form/p")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
        loginFunctionalityTestCases.clickClose();
    }

    @Test
    public void testWithFourthValidUsernameAndInvalidPassword() {
        loginFunctionalityTestCases.clickOnBlackLoginButton();
        loginFunctionalityTestCases.insertFourthValidUsername();
        loginFunctionalityTestCases.insertInvalidPassword();
        loginFunctionalityTestCases.clickontheloginbutton();
        String expectedErrorMessage = "Incorrect username or password!";
        String actualErrorMessage = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/form/p")).getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid credentials error message displayed");
        loginFunctionalityTestCases.clickClose();
    }
}

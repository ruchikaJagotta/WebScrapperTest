package com.testing.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.constants.TestConstants;
import com.testing.webdriver.HtmlUnitDriverCustom;

public class TestLogin implements TestConstants {

	private WebDriver driver;

	@BeforeTest
	public void getWebDriver() {
		driver = new HtmlUnitDriver(true);
		/**
		 * For interactive Browser, Uncomment below lines and comment out above 
		 * HtmlUnitDriver initialization
		 */
		/*  
		 	System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		*/
		driver.get(URL_APPLICATION);
		
	}

	@Test
	public void verifyLoginWithCorrectCredentials() {
		loginWithCredentials(USER_NAME_CORRECT, PASSWORD_CORRECT);
		validateResultText(RESULT_WELCOME_TEXT);
	}

	@Test(priority = 1)
	public void verifyLoginWithInCorrectCredentials() {
		loginWithCredentials(USER_NAME_INCORRECT, PASSWORD_INCORRECT);
		validateResultText(RESULT_ACCESS_DENIED_TEXT);
	}

	@Test(priority = 2)
	public void verifyLoginWithCorrectCredentialsButRemovedCookies() {
		loginWithCredentials(USER_NAME_CORRECT, PASSWORD_CORRECT);
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		validateResultText(RESULT_MISSING_COOKIE_TEXT);
	}

	@Test(priority = 3)
	public void verifyLoginWithCorrectCredentialsButHttp() {
		/*
		 * Override HtmlUnitDriver to disable URLRedirect Option
		 */
		driver = new HtmlUnitDriverCustom(true);
		driver.get(URL_APPLICATION);
		loginWithCredentials(USER_NAME_CORRECT, PASSWORD_CORRECT);
		validateResultText(RESULT_REDIRECTING_TEXT);
	}

	@AfterMethod
	public void takeScreenShotOnComplete(ITestResult testResult) throws IOException {
		if (driver instanceof HtmlUnitDriver) {
			return;
		}
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,1000)");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("../Screenshot/" + testResult.getName() + ".jpg"));
	}

	private void loginWithCredentials(String userNameValue, String passwordValue) {
		WebElement userField = driver.findElement(By.name(USER_FIELD_ID));
		WebElement passwordField = driver.findElement(By.name(PWD_FIELD_ID));
		userField.sendKeys(userNameValue);
		passwordField.sendKeys(passwordValue);
		WebElement form = driver.findElement(By.tagName(FORM_LOGIN));
		form.submit();
	}

	private void validateResultText(final String expectedText) {
		WebElement resultField = driver.findElement(By.xpath(RESULT_FIELD_XPATH));
		Assert.assertEquals(resultField.getText(), expectedText);
		navigateBack();
	}

	private void navigateBack() {
		WebElement backButton = driver.findElement(By.xpath(LINK_BACK_XPATH));
		backButton.click();

		WebElement resultField = driver.findElement(By.xpath(RESULT_FIELD_XPATH));
		Assert.assertEquals(resultField.getText(), LABEL_LOGIN_TEXT);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	@AfterSuite
	public void sendMail()
	{
		// Logic to send reportmail to users
	}
	
	
}

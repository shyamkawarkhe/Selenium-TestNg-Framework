package testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Resources.baseClass;
import com.Resources.commonMethods;
import com.Resources.constants;

import pageObjectModel.homePageObjects;
import pageObjectModel.loginPageObject;
import pageObjectModel.registerPageObjects;

public class RegisterTestCases extends baseClass {

	
	public static String randomEmail="";
	
	@Test
	public void verifyRegisterationWithInBlankData() throws IOException, InterruptedException {

	

		homePageObjects hpo = new homePageObjects(driver);

	  commonMethods.putExplicitWait(driver,5, hpo.clickOnMyAccount());
		hpo.clickOnMyAccount().click();
		hpo.clickOnRegister().click();

		registerPageObjects rpo = new registerPageObjects(driver);

		rpo.enterFirstName().sendKeys("");

		rpo.enterLastName().sendKeys("");

		rpo.enterEmail().sendKeys("");
		
		rpo.entertelephone().sendKeys("");
		rpo.enterpassword().sendKeys("");
		rpo.enterconfirmpass().sendKeys("");
		rpo.clickOnSubscribe().click();
		//rpo.acceptPrivacyPolicy().click();
		rpo.clickOnContinueButton().click();

		commonMethods.handleAssertions(rpo.captureFirstNameErrorMsg().getText(), constants.firtNameErroMsg );
		 
		commonMethods.handleAssertions(rpo.captureLastNameErrorMsg().getText(), constants.lastNameErrorMsg );

		
		
	}

	
	@Test(dependsOnMethods="verifyRegisterationWithInBlankData")
	public void verifyRegisterationWithValidData() throws IOException, InterruptedException {

	

		randomEmail=generateRandomEmail();
		registerPageObjects rpo = new registerPageObjects(driver);

	    commonMethods.putExplicitWait(driver, 10, rpo.enterFirstName());
		rpo.enterFirstName().clear();
		rpo.enterFirstName().sendKeys(constants.firstname);
		rpo.enterLastName().sendKeys(constants.lastname);
		rpo.enterEmail().sendKeys(randomEmail);
		rpo.entertelephone().sendKeys(constants.telephone);
		rpo.enterpassword().sendKeys(constants.password);
		rpo.enterconfirmpass().sendKeys(constants.confirmpassword);
		rpo.clickOnSubscribe().click();
		Thread.sleep(2000);
		rpo.acceptPrivacyPolicy().click();
		rpo.clickOnContinueButton().click();
		
		commonMethods.handleAssertions(driver.getCurrentUrl(), constants.successUrl);
		
		 
		
	

	}

}

package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Resources.baseClass;
import com.Resources.constants;

import pageObjectModel.homePageObjects;
import pageObjectModel.loginPageObject;

public class LoignTestCases extends baseClass {

	@Test
	public void validLoginTest() throws IOException {

		homePageObjects hpo = new homePageObjects(driver);

		hpo.clickOnMyAccount().click();
		hpo.clickOnLogin().click();

		loginPageObject lpo = new loginPageObject(driver);

		lpo.enterEmail().sendKeys(RegisterTestCases.randomEmail);
		lpo.enterLPassword().sendKeys(constants.password);
		lpo.clickOnLogin().click();
	}

}

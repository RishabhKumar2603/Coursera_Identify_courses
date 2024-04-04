package testCases;

import org.testng.annotations.Test;

import pageObject.FormPage;
import testBase.BaseClass;

public class TC_003_FormFill extends BaseClass{

//	@Test(priority = 1)
//	public void goHome() {
//		FormPage fp = new FormPage(driver);
//		fp.goingHomePage();
//	}
	
	@Test(priority = 2)
	public void goEnterprise() {
		FormPage fp = new FormPage(driver);
		fp.goToEnterprise();
	}

	
	@Test(priority = 3)
	public void goCampus() {
		FormPage fp = new FormPage(driver);
		fp.goToCampus();
	}
	
	@Test(priority = 4)
	public void fillingForm() throws InterruptedException {
		FormPage fp = new FormPage(driver);
		fp.enterFirstName();
		fp.enterLastName();
		fp.enterEmail();
		fp.enterPhone();
		fp.selectInstituteType();
		fp.enterInstituteName();
		fp.selectJobRole();
		fp.selectDepartment();
		fp.enterDescription();
		fp.selectCountry();
		Thread.sleep(2000);
		screenshot("FormRandomData");
		fp.submitForm();
		
	}
}

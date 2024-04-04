package testCases;

//import java.io.IOException;
import java.util.ArrayList;

//import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.FormPage;
import testBase.BaseClass;
import utilities.DataProviders;
//import utilities.ExcelUtility;

public class TC_004_FormFillDataDriven extends BaseClass{

	public static ArrayList<String> list;
	@Test(dataProvider="LoginData" ,dataProviderClass=DataProviders.class)
	public void dataFill(String fname,String lname,String email,String phone,String itype,String iname,String job,String department,String needs,String country,String ss ) {
		
		logger.info("********Tc_004_FormFillDataDriven starts********");
		try {
		FormPage fp = new FormPage(driver);
		fp.goToEnterprise();
		fp.goToCampus();
		scrolling(500);
		Thread.sleep(2000);
		fp.enterFirstName(fname);
		fp.enterLastName(lname);
		fp.enterEmail(email);
		fp.enterPhone(phone);
		fp.selectInstituteType(itype);
		fp.enterInstituteName(iname);
		fp.selectJobRole(job);
		fp.selectDepartment(department);
		fp.enterDescription(needs);
		fp.selectCountry(country);
		
		fp.submitForm();
		screenshot(ss);
		
		fp.errrorMsgCapture();
		logger.info("********Tc_004_FormFillDataDriven ends********");
	}
	catch(Exception e) {
		Assert.fail();
	}
}
}
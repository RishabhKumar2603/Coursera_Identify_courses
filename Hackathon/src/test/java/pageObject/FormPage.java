package pageObject;

import java.io.IOException;
//import java.util.ArrayList;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

//import net.bytebuddy.utility.RandomString;
import testBase.BaseClass;
//import utilities.ExcelUtility;

//import java.text.Normalizer.Form;

public class FormPage extends BasePage{
	
public FormPage(WebDriver driver) {
	super(driver);
	
}


// form elements
@FindBy(xpath="//a[normalize-space()='For Enterprise']")
WebElement forEnterprise;

@FindBy(xpath="//a[normalize-space()='For Campus']")
WebElement forCampus;

@FindBy(xpath="//input[@id='FirstName']")
WebElement firstName;

@FindBy(xpath="//input[@id='LastName']")
WebElement lastName;

@FindBy(xpath="//input[@id='Email']")
WebElement email;

@FindBy(xpath="//input[@id='Phone']")
WebElement phone;

@FindBy(xpath="//select[@id='Institution_Type__c']")
WebElement institutionType ;

@FindBy(xpath="//input[@id='Company']")
WebElement institutionName ;

@FindBy(xpath="//select[@id='Title']")
WebElement jobRoles;

@FindBy(xpath="//select[@id='Department']")
WebElement department ;

@FindBy(xpath="//select[@id='What_the_lead_asked_for_on_the_website__c']")
WebElement needsDescription ;

@FindBy(xpath="//select[@id='Country']")
WebElement  country;

@FindBy(xpath="//select[@id='State']")
WebElement selectState ;

@FindBy(xpath="//button[normalize-space()='Submit']")
WebElement submit ;

@FindBy(xpath="//select[@id='Self_reported_employees_to_buy_for__c']")
WebElement expectedLearners ;

@FindBy(xpath="//textarea[@id='rentalField5']")
WebElement describeNeeds ;


//FORM FILLING METHODS
public void goToEnterprise() {
	forEnterprise.click();
}
	
public void goToCampus() {
	forCampus.click();
}

public void enterFirstName() {
	BaseClass w = new BaseClass();
	firstName.sendKeys(w.randomString());
}
public void enterFirstName(String name) {
	firstName.sendKeys(name);
}


public void enterLastName() {
	BaseClass w = new BaseClass();
	lastName.sendKeys(w.randomString());
}
public void enterLastName(String name) {
	lastName.sendKeys(name);
}


public void enterEmail() {
	BaseClass w = new BaseClass();
	email.sendKeys(w.randomAlphaNumeric()+"@gmail.com");
}
public void enterEmail(String id) {
 email.sendKeys(id);
}


public void enterPhone() {
	BaseClass w = new BaseClass();
	phone.sendKeys(w.randomNumber());
}
public void enterPhone(String num) {
	phone.sendKeys(num);
}


public void selectInstituteType() {
	BaseClass w = new BaseClass();
	new Select(institutionType).selectByIndex(w.randomNumber(6));
}
public void selectInstituteType(String ins) {
	if(ins.isEmpty()) {
		new Select(institutionType).selectByIndex(0);
	}
	else {
	new Select(institutionType).selectByVisibleText(ins);
	}
}


public void enterInstituteName() {	
	BaseClass w = new BaseClass();
	institutionName.sendKeys(w.randomString());
}
public void enterInstituteName(String ins) {	
	institutionName.sendKeys(ins);
}


public void selectJobRole() {	
	BaseClass w = new BaseClass();
	new Select(jobRoles).selectByIndex(w.randomNumber(11));
}
public void selectJobRole(String job) {	
	if(job.isEmpty()) {
		new Select(jobRoles).selectByIndex(0);
	}else {
	new Select(jobRoles).selectByVisibleText(job);
	}
}


public void selectDepartment() {
	BaseClass w = new BaseClass();
	int index = w.randomNumber(11);
	try {
	if(department.isDisplayed())
	new Select(department).selectByIndex(index);
	}
	catch(Exception e) {}
}
public void selectDepartment(String dep) {
	
	try {
		if(dep.isEmpty()) {
			if(department.isDisplayed()) {
				new Select(department).selectByIndex(0);
				}
		}
	else {
		if(department.isDisplayed()) {
			new Select(department).selectByVisibleText(dep);
		}
	}
	}
	catch(Exception e) {}

}


public void enterDescription() {
	BaseClass w = new BaseClass();
	int a =  w.randomNumber(7);
	
	new Select(needsDescription).selectByIndex(a);
	if(a==1) {
		new Select(expectedLearners).selectByIndex(w.randomNumber(8));
	}
	else if (a==7) {
		describeNeeds.sendKeys(w.randomString());
		new Select(expectedLearners).selectByIndex(w.randomNumber(8));
	}		
}
public void enterDescription(String des) {
	BaseClass w = new BaseClass();
	if(des.isEmpty()) {
		new Select(needsDescription).selectByIndex(0);
	}
	else {
	new Select(needsDescription).selectByVisibleText(des);
	if(des.equals("Meet with Coursera Sales Team")) {
		new Select(expectedLearners).selectByIndex(w.randomNumber(8));
	}
	else if (des.equals("Other")) {
		describeNeeds.sendKeys(w.randomString());
		new Select(expectedLearners).selectByIndex(w.randomNumber(8));
	}
	}
}


public void selectCountry() {
	BaseClass w = new BaseClass();
	new Select(country).selectByIndex(w.randomNumber(252));
	
}
public void selectCountry(String count) {
	BaseClass w = new BaseClass();
	new Select(country).selectByVisibleText(count);
	if(count.equals("India") || count.equals("Canada")||count.equals("United States")) {
		new Select(selectState).selectByIndex(w.randomNumber(20));
	}
}


public void submitForm() {	
//	submit.click();
	country.submit();
}


public void errrorMsgCapture() {
	try {
//	WebElement selection = driver.findElement(By.xpath("//select[contains(@class,'mktoInvalid')]"));
//	WebElement text = driver.findElement(By.xpath("//input[contains(@class,'mktoInvalid')]"));
	WebElement invalidMsg = driver.findElement(By.xpath("//div[contains(@class,'mktoErrorMsg')]"));
	System.out.println("The error  msg is : "+invalidMsg.getText());
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

}

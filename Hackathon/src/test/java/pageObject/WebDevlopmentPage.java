package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import testBase.BaseClass;

public class WebDevlopmentPage extends BasePage{

	public WebDevlopmentPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@data-testid='search-filter-group-Language']//div[@role='group']//div//div[@data-testid='English-false']")
	WebElement englishCheckbox;
	
	@FindBy(xpath="//div[@data-testid='Beginner-false']")
	WebElement beginnerCheckbox;
	
	@FindBy(xpath="//ul[@class='cds-9 css-5t8l4v cds-10']/li[1]//a")
	WebElement firstCourseName;
	
	@FindBy(xpath="//ul[@class='cds-9 css-5t8l4v cds-10']/li[1]//div[contains(@class,'product-reviews')]/p")
	WebElement firstCourseRating;
	
	@FindBy(xpath="//ul[@class='cds-9 css-5t8l4v cds-10']/li[1]//div[contains(@class,'cds-CommonCard-meta')]/p")
	WebElement firstCourseDuration;
	
	
	@FindBy(xpath="//ul[@class='cds-9 css-5t8l4v cds-10']/li[2]//a")
	WebElement secondCourseName;
	
	@FindBy(xpath="//ul[@class='cds-9 css-5t8l4v cds-10']/li[2]//div[contains(@class,'product-reviews')]/p")
	WebElement secondCourseRating;
	
	@FindBy(xpath="//ul[@class='cds-9 css-5t8l4v cds-10']/li[2]//div[contains(@class,'cds-CommonCard-meta')]/p")
	WebElement secondCourseDuration;
	
	
	public void clickOnEnglishCheckbox() {
		englishCheckbox.click();
	}
	
	public void clickOnBeginnerCheckbox() {
		beginnerCheckbox.click();
	}
	
	public void nameOfFirstCourse() {
		System.out.println("First Course Details: ");
		System.out.println("Name: "+firstCourseName.getText());
		
		
	}
	
	public void ratingOfFirstCourse() {
		System.out.println("Rating: "+firstCourseRating.getText());
	}
	
	public void durationOfFirstCourse() {
	String fullStr = firstCourseDuration.getText();
	String[] strArray = fullStr.split("·");
	System.out.println("Duration: "+strArray[2]);
	}
	
	public void nameOfSecondCourse() {
		System.out.println("Second Course Details: ");
		System.out.println("Name: "+secondCourseName.getText());
	}	
	
	public void ratingOfSecondCourse() {
		System.out.println("Rating: "+secondCourseRating.getText());	
	}
	
public void durationOfSecondCourse() {
	String fullStr = secondCourseDuration.getText();
	String[] strArray = fullStr.split("·");
	System.out.println("Duration: "+strArray[2]);
//	System.out.println(strArray[1]);
	}
	
}

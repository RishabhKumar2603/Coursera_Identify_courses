package pageObject;



import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LanguageLearning extends BasePage {

	

	public LanguageLearning(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder='What do you want to learn?']")
	WebElement searchBox;
	
//	WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']"));
	
	@FindBy(xpath = "//li[@id='react-autowhatever-1-section-1-item-0']")
	WebElement searchResult;
	
	@FindBy(xpath = "//button[@aria-label='Show more Language options']")
	WebElement showMoreButton;
	
	@FindBy(xpath = "//div[@id='checkbox-group']/div")
	List<WebElement> languages ;
	
	@FindBy(xpath = "//button[@class='cds-149 cds-button-disableElevation cds-button-ghost css-1s96oj']")
	WebElement closeButton;
	
	@FindBy(xpath = "//div[@data-testid='search-filter-group-Level']//div[@role='group']/div")
	List<WebElement> levels;
	
	public void searchLanguageLearning() {
		searchBox.sendKeys("Language Learning");
	}
	
	public void clickOnSearchResult() {
		searchResult.click();
	}
	
	public void clickOnShowMore() {
		showMoreButton.click();
	}
	
	public void languages() {
		System.out.println("No. of languages : "+ languages.size());
		System.out.println("Different languagaes are : ");
		for(WebElement ele : languages) {
			System.out.println(ele.getText());
		}	
	}
	
	public void clickOnClose() {
		closeButton.click();
	}
	
	public void levels() {
		System.out.println("No. of levels : "+ levels.size());
		System.out.println("Different levels are : ");
		for(WebElement ele : levels) {
			System.out.println(ele.getText());
		}	
	}
	
}

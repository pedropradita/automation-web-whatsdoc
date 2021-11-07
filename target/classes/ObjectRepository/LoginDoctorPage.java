package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDoctorPage {

	public WebDriver driver;

	public LoginDoctorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[type='submit']")
	WebElement loginButton;
	@FindBy(xpath = "//div[@class='phone__InputPhoneGroup-sc-7deou5-2 gflsXA']/following-sibling::span")
	WebElement alertPhone;
	@FindBy(xpath = "//input[@name='pin']/following-sibling::span")
	WebElement alertPin;
	@FindBy(css = "input[class=' form-control']")
	WebElement fieldPhone;
	@FindBy(css = "input[name='pin']")
	WebElement fieldPin;
	@FindBy(css = "div[class='notice__NoticeError-sc-1wh5878-2 hkzzHj']")
	WebElement alertPopup;
	@FindBy(css = "div[class=' flag-dropdown']")
	WebElement dropdownButton;
	@FindBy(css = "li[data-flag-key='flag_no_0']")
	WebElement dropdownIndo;
	@FindBy(css = "input[type='search']")
	WebElement dropdownSearch;	
	@FindBy(css = "ul[class=' country-list']")
	WebElement dropdownList;
	@FindBy(css = "a[class='button__LinkRef-al7qla-2 iYgXXt']")
	WebElement textLinkForgotPin;
	
	
	
	
	public WebElement LoginButton() {
		return loginButton;
	}
	
	public WebElement AlertPhone() {
		return alertPhone;
	}
	
	public WebElement AlertPin() {
		return alertPin;
	}
	
	public WebElement FieldPhone() {
		return fieldPhone;
	}
	
	public WebElement FieldPin() {
		return fieldPin;
	}
	
	public WebElement AlertPopup() {
		return alertPopup;
	}
	
	public WebElement DropdownButton() {
		return dropdownButton;
	}
	
	public WebElement DropdownSearch() {
		return dropdownSearch;
	}
	
	public WebElement DropdownIndo() {
		return dropdownIndo;
	}
	
	public WebElement DropdownList() {
		return dropdownList;
	}
	
	public WebElement TextLinkForgotPin() {
		return textLinkForgotPin;
	}
		
}

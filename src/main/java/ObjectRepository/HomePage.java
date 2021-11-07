package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[class='nav-link btn text-white  btn-primary px-2']")
	WebElement loginButton;
	@FindBy(css = "a[href*='login']")
	WebElement loginWebapp;
	
	
	public WebElement LoginButton() {
		return loginButton;
	}
	
	public WebElement LoginWebapp() {
		return loginWebapp;
	}
	
	
	
	
	
	

}

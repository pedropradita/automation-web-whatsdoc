package script;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectRepository.ForgotPinPage;
import ObjectRepository.Global;
import ObjectRepository.HomePage;
import ObjectRepository.LoginDoctorPage;
import resources.Base;

public class LoginDoctorTest extends Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	Global g;
	HomePage h;
	LoginDoctorPage l;
	ForgotPinPage f;

	@BeforeMethod
	public void BefMet() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("urlwhatsdoc"));

		g = new Global(driver);
		h = new HomePage(driver);
		l = new LoginDoctorPage(driver);
		f = new ForgotPinPage(driver);

		h.LoginButton().click();
		h.LoginWebapp().click();

	}

	@AfterMethod
	public void AfMet() {
		driver.close();
		driver.quit();
	}

	@Test(groups = "WhatsDoc")
	public void LoginAlertNull() {

		System.out.println("Case null login alert");

		String alertPhone = "This field is Required";
		String alertPin = "This field is Required";

		l.LoginButton().click();

		Assert.assertEquals(g.CheckAlert(l.AlertPhone(), "Phone", alertPhone), alertPhone);
		Assert.assertEquals(g.CheckAlert(l.AlertPin(), "Pin", alertPin), alertPin);
	}

	@Test(groups = "WhatsDoc")
	public void LoginAlertInvalid() {

		System.out.println("Case invalid login alert");

		String invalid = "1";
		String alertPhone = "Minimum is 4 digits";
		String alertPin = "Must be 6 digits";

		l.FieldPhone().sendKeys(Keys.BACK_SPACE);
		l.FieldPin().sendKeys(invalid);
		l.LoginButton().click();

		Assert.assertEquals(g.CheckAlert(l.AlertPhone(), "Phone", alertPhone), alertPhone);
		Assert.assertEquals(g.CheckAlert(l.AlertPin(), "Pin", alertPin), alertPin);
	}

	@Test(groups = "WhatsDoc")
	public void LoginAlertUserInvalid() {

		System.out.println("Case invalid user login alert");

		String invalid = "123456";
		String alert = "User not found";

		l.FieldPhone().sendKeys(invalid);
		l.FieldPin().sendKeys(invalid);
		l.LoginButton().click();

		Assert.assertEquals(g.CheckAlert(l.AlertPopup(), "Invalid user", alert), alert);
	}

	@Test(groups = "WhatsDoc")
	public void LoginAlertMismatch() {

		System.out.println("Case mismatch login alert");

		String invalid = g.GetRandomNumberString();
		String inPhone = "112233";
		String alert = "Phone number or PIN mismatch, please try again, or reach out to contact@hiwhatsdoc.com.";
		String alerta = "Account suspended! Please try again later, or reach out to contact@hiwhatsdoc.com.";
		String alerti = "Phone number or PIN mismatch";

		l.FieldPhone().sendKeys(inPhone);
		l.FieldPin().sendKeys(invalid);
		l.LoginButton().click();

		String alerts = l.AlertPopup().getText().split(",")[0];
		
		if (alerti.equals(alerts)) {
			Assert.assertEquals(g.CheckAlert(l.AlertPopup(), "Mismatch", alert), alert);
		} else {
			Assert.assertEquals(g.CheckAlert(l.AlertPopup(), "Suspend", alerta), alerta);
		}
	}

	@Test(groups = "WhatsDoc")
	public void LoginAlertSuspend() throws InterruptedException {

		System.out.println("Case suspend login alert");

		String invalid = "112233";
		String alertw = "Account suspended";
		String alert = "Account suspended! Please try again later, or reach out to contact@hiwhatsdoc.com.";
		
		do {
		driver.navigate().refresh();
		l.FieldPhone().sendKeys(invalid);
		l.FieldPin().sendKeys(invalid);
		l.LoginButton().click();
		}while (!l.AlertPopup().getText().split("!")[0].equals(alertw));
		
		Assert.assertEquals(g.CheckAlert(l.AlertPopup(), "Suspend", alert), alert);
	}

	@Test(groups = "WhatsDoc")
	public void WaitingActivation() {

		System.out.println("Case waiting activation login alert");

		String phone = "89519801734";
		String search = "indo";
		String pass = "030991";
		String alert = "Pending account activation, please try again later, or reach out to contact@hiwhatsdoc.com.";

		l.DropdownButton().click();
		l.DropdownSearch().sendKeys(search);
		l.DropdownIndo().click();
		l.FieldPhone().sendKeys(phone);
		l.FieldPin().sendKeys(pass);
		l.LoginButton().click();

		Assert.assertEquals(g.CheckAlert(l.AlertPopup(), "Waiting activation", alert), alert);
	}

	@Test(groups = "WhatsDoc")
	public void ForgotPinTextLink() throws InterruptedException, MalformedURLException, IOException {

		System.out.println("Case forgot pin text link");

		String url = "https://app.whatsdoc.com/doctor/forgot";

		l.TextLinkForgotPin().click();

		Thread.sleep(1000);

		Assert.assertEquals(g.CheckUrl(f.driver, "Forgot pin", url), url);
		Assert.assertTrue(g.CheckConnection(f.driver) < 400);
	}
}
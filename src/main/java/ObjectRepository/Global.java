package ObjectRepository;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class Global {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	public Global(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String CheckAlert(WebElement object, String name, String alerttxt) {

		String title = object.getText();
		if (title.equals(alerttxt)) {
			log.info(name + " alert is enable " + title);
		} else {
			log.error(name + " alert text is different " + title);
		}
		
		return title;
	}

	public String CheckUrl(WebDriver object, String name, String urltab) {

		String url = object.getCurrentUrl();
		if (url.equals(urltab)) {
			log.info(name + " URL is right " + url);
		} else {
			log.error(name + " URL is wrong " + url);
		}
		
		return url;
	}

	public int CheckConnection(WebDriver object) throws MalformedURLException, IOException {

		String url = object.getCurrentUrl();
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();

		if (respCode < 400) {
			log.info("The link with " + url + " is status ok with code " + respCode);
		} else {
			log.error("The link with " + url + " is broken with code " + respCode);
		}
		
		return respCode;
	}
	
	public String GetRandomNumberString() {

	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	    return String.format("%06d", number);
	}
}

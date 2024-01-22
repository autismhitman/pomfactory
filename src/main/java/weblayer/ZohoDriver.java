package weblayer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import base.pages.ZohoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import listener.ZohoEventListener;
import session.ZohoTestSession;

public class ZohoDriver extends AbstractZohoValidationDriver {

	
	
	@Override
	public void launchBrowser(String browser) {
		ChromeOptions co = new ChromeOptions();
		List<String> options = new ArrayList<>();
		options.add("--disable-extensions");
		options.add("start-maximized");
		options.add("--disable-notifications");
		options.add("--disable-geolocation");
		options.add("--disable-media-stream");
		options.add("--remote-allow-origins=*");
		options.add("ignore-certificate-errors");
		// options.add("--headless=new");
		// options.add("unsafely-treat-insecure-origin-as-secure");
		options.add("--incognito");
		options.add("--disable-dev-shm-usage");
		options.add("--disable-application-cache");
		options.add("--disable-gpu");
		options.add("--no-sandbox");
		options.add("--disable-gpu");

		 WebDriverManager.chromedriver().setup();
		 WebDriver wdriver = new ChromeDriver(co.addArguments(options));
		 WebDriverListener listener = new ZohoEventListener();
		 driver = new EventFiringDecorator<WebDriver>(listener).decorate(wdriver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}

	@Override
	public void navigate(String url) {
	 
		driver.get(url);
	}

	@Override
	public void quit() {
	 
		System.out.println("zo hodriver quit");
	}

	@Override
	public void logout() {
		 
		System.out.println("zo hodriver logout");
	}
 

	@Override
	public WebDriver getCurrentDriver() {
		 
		return driver;
	}

 

	
	 
	 

}

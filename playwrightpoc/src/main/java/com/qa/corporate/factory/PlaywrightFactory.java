package com.qa.corporate.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	
	Playwright playwright;
	Browser browser;
	Properties prop;
	
	//Initialize the browser
	public Page initBrowser(Properties prop) {
		
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser name is: "+browserName);
		
		playwright = Playwright.create();
		BrowserContext browserContext;
		Page page;	
		
		
		switch(browserName) {		
		case "chromium":
			//browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000));
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;			
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;			
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;			
		case "chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		default:
			System.out.println("Please pass the the valid/correct browser name...");
			break;			
		}		
		browserContext = browser.newContext();
		page=browserContext.newPage();
		page.navigate(prop.getProperty("url"));
		page.waitForLoadState();
		return page;		
	}
	
	//This method is used for initialize the properties from config file
	public Properties init_prop() throws FileNotFoundException{
		FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
		prop = new Properties();
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return prop;
	}

}

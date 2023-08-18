package com.qa.corporate.base;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.pramac.corporate.pages.ContactUs;
import com.qa.corporate.factory.PlaywrightFactory;

public class BaseTest {
	
	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	
	protected ContactUs contactPage;
	
	@BeforeTest
	public void setup() throws FileNotFoundException {
		pf =  new PlaywrightFactory();
		prop = pf.init_prop();
		page = pf.initBrowser(prop);			
		contactPage = new ContactUs(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}

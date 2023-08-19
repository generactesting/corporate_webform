package com.pramac.corporate.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class ContactUs {
	
	private Page page;
	private String firstName="input[name='first-name']";
	private String lastName="input[name='last-name']";
	private String company="input[name='your-company']";
	private String jobTitle="input[name='title']";
	private String email="input[name='your-email']";
	private String phoneCode="input[name='your-tel']";
	private String phone="input[name='your-tel']";
	private String street="input[name='street']";
	private String city="input[name='city']";
	private String country="#ui-id-1";
	private String state="#ui-id-2";
	private String zipcode="input[name='zip']";
	private String areYouDealer="#ui-id-3";
	private String howCanWeHelp="#ui-id-4";
	//*[@id="ui-id-4"]
	//private String howCanWeHelp="//select[@id='ui-id-4']";
	private String yourMessage="textarea[name='your-message']";
	private String readPrivacyNotice="//span[contains(text(),'I agree')]";
	private String myConsentTo="span[data-name='acceptance-one'] span[class='wpcf7-list-item first'] span[class='wpcf7-list-item-label']";
	private String transferOfPersonalData = "span[data-name='acceptance-two'] span[class='wpcf7-list-item first'] span[class='wpcf7-list-item-label']";
	private String sendButton = "input[value='Send']";
	private String successMessage = "#p[role='status']";
	
	
	
	public ContactUs(Page page) {
		this.page = page;
	}
	
	public String getContactUsTitle() {
		return page.title();
	}
	
	
	public void submitCustomerDetails(String firstName, String lastName, String company, String jobTitle, 
			String email, String phone, String street, String city, String country, String state, 
			String zipcode, String areYouDealer, String howCanWeHelp, String yourMessage, 
			String readPrivacyNotice, String myConsentTo, String transferOfPersonalData) {
		page.fill(this.firstName, firstName);
		page.fill(this.lastName, lastName);
		page.fill(this.company, company);
		page.fill(this.jobTitle, jobTitle);
		page.fill(this.email, email);
		//page.selectOption(this.phoneCode, phoneCode);
		page.fill(this.phone, phone);
		page.fill(this.street, street);
		page.fill(this.city, city);
		page.locator("#ui-id-3").selectOption("No");

		page.selectOption(this.country, country);
		page.selectOption(this.state, state);
		page.fill(this.zipcode, zipcode);
		page.locator(this.areYouDealer).selectOption(areYouDealer);
		page.locator(this.howCanWeHelp).selectOption(howCanWeHelp);
		page.fill(this.yourMessage, yourMessage);
		page.getByText("I agree").click();
		page.getByText("No", new Page.GetByTextOptions().setExact(true)).nth(3).click();
		page.getByText("Yes").nth(3).click();
		page.click(sendButton);		
	}
	
	

	
	
//    public boolean isFormSubmittedSuucessfully() {
//		page.waitForLoadState();			
//		return page.isVisible(successMessage);
//    }

}

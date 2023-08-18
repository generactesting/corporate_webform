package com.qa.corporate.tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.corporate.base.BaseTest;


public class ContactPageTest extends BaseTest {

@Test	
public void testContactUsPage() throws IOException {		
		
	boolean messageIsVisible = true;
	FileInputStream fis = new FileInputStream("./TestData/Pramac_Corporate_Testdata.xlsx");
    Workbook workbook = new XSSFWorkbook(fis);
    Sheet sheet = workbook.getSheetAt(0);
    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
        Row row = sheet.getRow(i);
        DataFormatter formatter = new DataFormatter();
        String firstName = row.getCell(0).getStringCellValue();
        //System.out.println("firstName: "+firstName);
        String lastName = row.getCell(1).getStringCellValue();
        //System.out.println("lastName: "+lastName);
        String company = row.getCell(2).getStringCellValue();
        //System.out.println("company: "+company);
        String jobTitle = row.getCell(3).getStringCellValue();
        //System.out.println("jobTitle: "+jobTitle);
        String email = row.getCell(4).getStringCellValue();
        //System.out.println("email: "+email);
        Object phoneCode1=formatter.formatCellValue(row.getCell(5));
        String phoneCode=(String) phoneCode1;
        
        Object phone1=formatter.formatCellValue(row.getCell(6));
        String phone=(String) phone1;
        
        Object street1=formatter.formatCellValue(row.getCell(7));
        String street=(String) street1;
        //System.out.println("street: "+street);
        
        Object city1=formatter.formatCellValue(row.getCell(8));
        String city=(String) city1;
        //System.out.println("city: "+city);
        String country = row.getCell(9).getStringCellValue();
        //System.out.println("country: "+country);
    	String state = row.getCell(10).getStringCellValue();
    	//System.out.println("state: "+state);
    	String zipcode = row.getCell(11).getStringCellValue();    	
    	//System.out.println("zipcode: "+zipcode);
    	String areYouDealer = row.getCell(12).getStringCellValue();
        String howCanWeHelp = row.getCell(13).getStringCellValue();
        String yourMessage = row.getCell(14).getStringCellValue();
        String readPrivacyNotice = row.getCell(15).getStringCellValue();
        String myConsentTo = row.getCell(16).getStringCellValue();
        String transferOfPersonalData = row.getCell(17).getStringCellValue();
	    
        contactPage.submitCustomerDetails(firstName, lastName, company, jobTitle, email, phone, street, city, country, state, zipcode, areYouDealer, howCanWeHelp, yourMessage, readPrivacyNotice, myConsentTo, transferOfPersonalData);
        //contactPage.submitCustomerDetails(firstName, lastName, company, jobTitle, email, phoneCode, phone, street, city, country, state, zipcode, areYouDealer, howCanWeHelp, yourMessage, readPrivacyNotice, myConsentTo, transferOfPersonalData);
        //contactPage.submitCustomerDetails("Mark", "AutoTest", "MaxWell Company", "Finance Manager", "mark@maxwell.com", "34534516781", "Srteet01", "City01", "United Kingdom", "Antrim", "A1 B2", "Yes", "General Enquiry", "To Test ISO Codes", "I agree", "No", "Yes");
		
		//Verifying Logout button is visible or not
//        boolean successMessageIsVisible = contactPage.isFormSubmittedSuucessfully();
//		//Assert.assertEquals(messageIsVisible, successMessageIsVisible);
//		if (successMessageIsVisible) {
//		    System.out.println("## PASS ## " + firstName+" " +lastName);
//		} else {
//			System.out.println("@@ FAIL @@ " + firstName+" " +lastName);
//		}
		
	}	
}
}

package com.comsand.integrationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shoppoint.generic.Fileutility.ExcelUtility;
import com.shoppoint.generic.Fileutility.FileUtility;
import com.shoppoint.generic.objectrepository.AdminHomePage;
import com.shoppoint.generic.objectrepository.AdminLoginpage;
import com.shoppoint.generic.objectrepository.Bookspage;
import com.shoppoint.generic.objectrepository.Homepage;
import com.shoppoint.generic.objectrepository.Mycartpage;
import com.shoppoint.generic.objectrepository.paymentpage;
import com.shoppoint.generic.objectrepository.productpage;
import com.shoppoint.generic.webdriverutility.WebdriverUtility;
import com.shoppoint.genericutility.Baseclass;

public class ToConfirmOrderTest extends Baseclass{
	
	@Test
	public void confirmOrdertest() throws Throwable {
	       ExcelUtility eu = new ExcelUtility();
	        FileUtility fu = new FileUtility();
			
			String data = eu.getDataFromExcelFile("Sheet1", 2, 3);
			String data2 = "Thea Stilton and the Tropical Treasure";
			String billinAdd = eu.getDataFromExcelFile("Sheet1", 11, 2);
			String billinState = eu.getDataFromExcelFile("Sheet1", 12, 2);
			String billinCity = eu.getDataFromExcelFile("Sheet1", 13, 2);
			String billpincode = eu.getDataFromExcelFile("Sheet1", 14, 2);
			String shippinAdd = eu.getDataFromExcelFile("Sheet1", 15, 2);
			String shippinState = eu.getDataFromExcelFile("Sheet1", 16, 2);
			String shippinCity = eu.getDataFromExcelFile("Sheet1", 17, 2);
			String shippincode = eu.getDataFromExcelFile("Sheet1", 18, 2);
			
			String adminUN = fu.getDataFromPropertyFile("adminusername");
			String adminPassword = fu.getDataFromPropertyFile("adminpassword1");
			
			
			Homepage hp = new Homepage(driver);
			hp.getBookslink().click();
			
			Bookspage bp = new Bookspage(driver);
			bp.getComicslink().click();
		
			Actions act = new Actions(driver);
			act.scrollByAmount(0, 500).perform();
			
			driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
			
			productpage pp = new productpage(driver);
			pp.getAddtocartlink().click();
			
			WebdriverUtility wu = new WebdriverUtility();
			wu.switchToAlertAccept(driver);
			
			Mycartpage mp = new Mycartpage(driver);
			mp.getBillingaddresstbx().sendKeys(billinAdd);
			mp.getBillingstatetbx().sendKeys(billinState);
			mp.getBillingcitytbx().sendKeys(billinCity);
			mp.getBillingcode().sendKeys(billpincode);
			mp.getShippingaddresstbx().sendKeys(shippinAdd);
			mp.getShippingstatetbx().sendKeys(shippinState);
			mp.getShippingcitytbx().sendKeys(shippinCity);
			mp.getShippingpincodetbx().sendKeys(shippincode);
			
			mp.getProceedtocheckoutlink().click();
			
			paymentpage pp1 = new paymentpage(driver);
			pp1.getCodradiobutton().click();
			pp1.getSubmitbutton().click();
			
			hp.getLogoutlink().click();
			
			hp.getAdminlink().click();
			
			AdminLoginpage ap = new AdminLoginpage(driver);
			
			ap.getUsernameTF().sendKeys(adminUN);
			ap.getPasswordTF().sendKeys(adminPassword);
			ap.getSubmitBtn().click();
			
			AdminHomePage ahp = new AdminHomePage(driver);
			ahp.getOrderManagementLink().click();
			ahp.getTodayOrdersLink().click();
			
			String actText = driver.findElement(By.xpath("//td[text()='"+data+"']")).getText();
			Assert.assertEquals(actText, data2);
			System.out.println("Order is displayed for Admin");

	}

}

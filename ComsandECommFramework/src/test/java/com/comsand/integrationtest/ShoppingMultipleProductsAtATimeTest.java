package com.comsand.integrationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.shoppoint.generic.Fileutility.ExcelUtility;
import com.shoppoint.generic.objectrepository.Bookspage;
import com.shoppoint.generic.objectrepository.Electronicspage;
import com.shoppoint.generic.objectrepository.Homepage;
import com.shoppoint.generic.objectrepository.Mycartpage;
import com.shoppoint.generic.objectrepository.paymentpage;
import com.shoppoint.generic.objectrepository.productpage;
import com.shoppoint.generic.webdriverutility.WebdriverUtility;
import com.shoppoint.genericutility.Baseclass;

public class ShoppingMultipleProductsAtATimeTest extends Baseclass{
	
	@Test
	public void multipleProducttest() throws Throwable {
		ExcelUtility eu = new ExcelUtility();
		
		String data = eu.getDataFromExcelFile("Sheet1", 2, 3);
		String product2 = eu.getDataFromExcelFile("Sheet1", 4, 3);
		String billinAdd = eu.getDataFromExcelFile("Sheet1", 11, 2);
		String billinState = eu.getDataFromExcelFile("Sheet1", 12, 2);
		String billinCity = eu.getDataFromExcelFile("Sheet1", 13, 2);
		String billpincode = eu.getDataFromExcelFile("Sheet1", 14, 2);
		String shippinAdd = eu.getDataFromExcelFile("Sheet1", 15, 2);
		String shippinState = eu.getDataFromExcelFile("Sheet1", 16, 2);
		String shippinCity = eu.getDataFromExcelFile("Sheet1", 17, 2);
		String shippincode = eu.getDataFromExcelFile("Sheet1", 18, 2);
		
		Homepage hp = new Homepage(driver);
		hp.getBookslink().click();
		
		Bookspage bp = new Bookspage(driver);
		bp.getComicslink().click();
	
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 200).perform();
	
		driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
		
		productpage pp = new productpage(driver);
		pp.getAddtocartlink().click();
		
		WebdriverUtility wu = new WebdriverUtility();
		wu.switchToAlertAccept(driver);
		
		Mycartpage mp = new Mycartpage(driver);
		mp.getContinueshippinglink().click();
		
		hp.getElectronicslink().click();
		
		Electronicspage ep = new Electronicspage(driver);
		ep.getMobileslinks().click();
		
		Actions act1 = new Actions(driver);
		act1.scrollByAmount(0, 200).perform();
		
		driver.findElement(By.xpath("//a[text()='"+product2+"']")).click();
		pp.getAddtocartlink().click();
		
		wu.switchToAlertAccept(driver);
		
		
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
		
		
	}

}

package com.comsand.integrationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shoppoint.generic.Fileutility.ExcelUtility;
import com.shoppoint.generic.objectrepository.Bookspage;
import com.shoppoint.generic.objectrepository.Homepage;
import com.shoppoint.generic.objectrepository.Mycartpage;
import com.shoppoint.generic.objectrepository.productpage;
import com.shoppoint.generic.webdriverutility.WebdriverUtility;
import com.shoppoint.genericutility.Baseclass;

public class UpdateProductInCartTest extends Baseclass{
	
	@Test
	public void updateProductInCarttest() throws Throwable {
        ExcelUtility eu = new ExcelUtility();
		
		String data = eu.getDataFromExcelFile("Sheet1", 2, 3);
		String quantity = eu.getDataFromExcelFile("Sheet1", 2, 4);
		
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
		
		WebElement quatityTF = driver.findElement(By.xpath("(//a[text()='"+data+"'])[2]/../../..//input[@type='text']"));
		quatityTF.clear();
		quatityTF.sendKeys(quantity);
		
		Mycartpage mcp = new Mycartpage(driver);
		mcp.getUpdateshoppingcartlink().click();
		//wu.switchToAlertAccept(driver);
		
		//hp.getMycartlink().click();
		String actQuantity = driver.findElement(By.xpath("(//a[text()='"+data+"'])[2]/../../..//input[@type='text']")).getAttribute("value");
		System.out.println(actQuantity);
		Assert.assertEquals(actQuantity, quantity);
		System.out.println("Quantity of the product Verified");
	}

}

package com.comsand.systemtest;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.shoppoint.generic.Fileutility.ExcelUtility;
import com.shoppoint.generic.objectrepository.Bookspage;
import com.shoppoint.generic.objectrepository.Homepage;
import com.shoppoint.generic.objectrepository.productpage;
import com.shoppoint.generic.webdriverutility.WebdriverUtility;
import com.shoppoint.genericutility.Baseclass;

public class RemoveProductFromWishlistTest extends Baseclass{
	
	@Test
	public void removeProductFromWishlsttest() throws Throwable {
		ExcelUtility eu = new ExcelUtility();
		
		String data = eu.getDataFromExcelFile("Sheet1", 2, 3);
		Homepage hp = new Homepage(driver);
		hp.getBookslink().click();
		
		Bookspage bp = new Bookspage(driver);
		bp.getComicslink().click();
	
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 200).perform();
	
		driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
		
		productpage pp = new productpage(driver);
		pp.getWishlistlink().click();
		
		driver.findElement(By.xpath("//a[text()='"+data+"']/../../..//i[@class='fa fa-times']")).click();
		
		WebdriverUtility wu = new WebdriverUtility();
		wu.switchToAlertAccept(driver);
		
	}

}

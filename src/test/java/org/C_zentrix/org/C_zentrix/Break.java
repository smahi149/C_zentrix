package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class Break extends MethodClass
{
	public static void Break() throws InterruptedException
	{
		Thread.sleep(2000);
		// break
		if(isElementPresent(By.id("take_break")))
		{	
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.document.getElementById('take_break').click()");
	//    driver.findElement(By.name("take_break")).click();
	    Select se2 = new Select(driver.findElement(By.name("break_reason_dd")));
        se2.selectByValue("break");
        Thread.sleep(500);
		}
		if(isElementPresent(By.name("final_take_break")))
		{	
        driver.findElement(By.name("final_take_break")).click();
        Thread.sleep(2000);
		}
    }
	
}

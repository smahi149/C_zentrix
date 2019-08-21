package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Back extends MethodClass
{
	public static void  Back() throws InterruptedException
	{
		Thread.sleep(4000);
		if(isElementPresent(By.id("back_from_break")))
		{
		//driver.findElement(By.name("back_from_break")).click();
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.document.getElementById('back_from_break').click()");
		}
	}
}

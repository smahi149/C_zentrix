package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class MakeCall extends MethodClass
{
	 static int   call_count_excel;
	public static void makecall() throws InterruptedException
	{
		Thread.sleep(2000);
		if(isElementPresent(By.name("switch_to_preview")))
		{
		 // driver.switchTo().frame("main_call_window");
		 	//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("window.document.getElementById('switch_to_preview').click()");
			driver.findElement(By.name("switch_to_preview")).click();	
			System.out.println("click on preview");
        }
	
		 Hs=Hw.getSheet("Sheet1");
	  	  call_count_excel=Hs.getLastRowNum()-3;
	   	  System.out.println("total number in excel\t "+call_count_excel);
	   	  for(int i=1;i<=call_count_excel;i++)
		      {
		 		 String number=Hs.getRow(i).getCell(1).getStringCellValue();
		 		 driver.findElement(By.xpath("//*[@id=\"n\"]")).clear();
		         driver.findElement(By.xpath("//*[@id=\"n\"]")).sendKeys(number);
		         driver.findElement(By.name("dial_phone")).click();
		      }
	   	  Thread.sleep(3000);
	  	if(isElementPresent(By.xpath("//*[@id=\"get_disposition\"]")))
		{
	  	  driver.findElement(By.xpath("//*[@id=\"get_disposition\"]")).click();
	      Select sel=new Select(driver.findElement(By.name("disposition_dd")));
			     sel.selectByVisibleText("simi");
			     Thread.sleep(1000);
	       driver.findElement(By.name("set_disposition")).click();
        }
	  	 Thread.sleep(1000);
		if(isElementPresent(By.name("disconnect")))
		{
		   driver.findElement(By.name("disconnect")).click();
		}
	   	  driver.findElement(By.name("switch_to_progressive")).click();
	 }
}

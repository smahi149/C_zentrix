package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Conference extends MethodClass
{
	 public static void conf() throws InterruptedException  
	 {
		 
		 if(isElementPresent(By.name("redial_phone")))
			{
		  	   driver.findElement(By.name("redial_phone")).click();
		  	 Thread.sleep(1000);
	        }
		 if(isElementPresent(By.name("call_conference")))
			{
		  	   driver.findElement(By.name("call_conference")).click();
		  	// Thread.sleep(4000);
	        }
	}
}

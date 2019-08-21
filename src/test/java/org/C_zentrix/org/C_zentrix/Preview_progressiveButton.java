package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import com.relevantcodes.extentreports.LogStatus;

public class Preview_progressiveButton extends MethodClass
{
	public static void preView() throws InterruptedException
	{
		Thread.sleep(1000);
		if(isElementPresent(By.name("switch_to_preview")))
		 {
			//  driver.switchTo().frame("main_call_window");
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("window.document.getElementById('switch_to_preview').click()");
			  driver.findElement(By.name("switch_to_preview")).click();	
			
			  System.out.println("click on preview");
		}
	}
	public static void  previewExtentreport()
    {
	Logger log=Logger.getLogger("Preview button test case extent report method");
	PropertyConfigurator.configure("Log4j.Properties");
	log.info("start preview button   test case extent report");
    	 if(dialer_type.equals("PREVIEW"))
	       {
	     	 logger = extent.startTest("Preview ");
	 	     //Assert.assertTrue(true);
	    	 logger.log(LogStatus.PASS, "Preview  test case is pass ");
	    	 logger.log(LogStatus.PASS, " dialer_type from agent live table  before click on preview button ::\t"+dialer_type_before_pre);
	    	 logger.log(LogStatus.PASS, " dialer_type from agent live table ::\t"+dialer_type);
	    	 logger.log(LogStatus.PASS, " Campaign id from agent table ::\t"+campaign_id1);
	    	 logger.log(LogStatus.PASS, " Campaign id from agent_live table ::\t"+campaign_id);
	      }
	     else
	      {
	   	   logger = extent.startTest("PREVIEW ");
	 	   //Assert.assertTrue(true);
	    	 logger.log(LogStatus.FAIL, " dialer_type from agent live table  before click on preview button ::\t"+dialer_type_before_pre);
            logger.log(LogStatus.FAIL, "Preview  test case is fail because some data not available in data base");
	 	   logger.log(LogStatus.FAIL, " dialer_type from agent live table  ::\t"+dialer_type);
	      logger.log(LogStatus.FAIL, " Campaign id from agent table ::\t"+campaign_id1);
	      logger.log(LogStatus.FAIL, " Campaign id from agent_live table ::\t"+campaign_id);
	     
        System.out.println("Ready_button  test case is fail because some data not available in data base(some column missing in table campaign)");
	      }
    }
	 
	public static void progRessive() throws InterruptedException
	{
		Thread.sleep(1000);
		if(isElementPresent(By.name("switch_to_progressive")))
		 {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.document.getElementById('switch_to_progressive').click()");
		//	driver.findElement(By.name("switch_to_progressive")).click();	
			System.out.println("click on progressive");
		}
	}
	public static void  progressiveExtentreport()
    {
		Logger log=Logger.getLogger("Progressive button test case extent report");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start pogressive button   test case extent report method");
    	 if(autoMode==0)
	       {
	     	 logger = extent.startTest("PROGRESSIVE ");
	 	     //Assert.assertTrue(true);
	    	 logger.log(LogStatus.PASS, "Progressive  test case is pass ");
	    	 logger.log(LogStatus.PASS, " autoMode  from agent_live table ::\t"+autoMode);
	    	// logger.log(LogStatus.PASS, " dialer_type from agent live table  before click on PROGRESSIVE button ::\t"+dialer_type_before_pre);
	    	 logger.log(LogStatus.PASS, " dialer_type from agent live table ::\t"+dialer_type);
	    	 logger.log(LogStatus.PASS, " Campaign id from agent table ::\t"+campaign_id1);
	    	 logger.log(LogStatus.PASS, " Campaign id from agent_live table ::\t"+campaign_id);
	      }
	     else
	      {
	   	   logger = extent.startTest("PROGRESSIVE ");
           logger.log(LogStatus.FAIL, "Progressive  test case is fail because some data not available in data base");
           logger.log(LogStatus.FAIL, " autoMode  from agent_live table ::\t"+autoMode);
	 	   //Assert.assertTrue(true);
	    // logger.log(LogStatus.FAIL, " dialer_type from agent live table  before click on PROGRESSIVE button ::\t"+dialer_type_before_pre);
	 	   logger.log(LogStatus.FAIL, " dialer_type from agent live table  ::\t"+dialer_type);
	      logger.log(LogStatus.FAIL, " Campaign id from agent table ::\t"+campaign_id1);
	      logger.log(LogStatus.FAIL, " Campaign id from agent_live table ::\t"+campaign_id);
	     
        System.out.println("Ready_button  test case is fail because some data not available in data base(some column missing in table campaign)");
	      }
    }
	 

}

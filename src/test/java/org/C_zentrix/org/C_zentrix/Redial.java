package org.C_zentrix.org.C_zentrix;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

public class Redial extends MethodClass
{
	public static void redial() throws InterruptedException
	{
		if(isElementPresent(By.name("redial_phone")))
		{
	  	   driver.findElement(By.name("redial_phone")).click();
	  	 Thread.sleep(4000);
        }
		
	
		if(isElementPresent(By.name("disconnect")))
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.document.getElementById('disconnect').click()");
		}
	}
	/* public static void  extent_()
	    {
	    	 if(agent_state.equals("FREE")&&dialer_type.equals("PROGRESSIVE"))
		       {
		     	 logger = extent.startTest("Ready_button ");
		 	     //Assert.assertTrue(true);
		    	 logger.log(LogStatus.PASS, "Ready_button  test case is pass ");
		    	logger.log(LogStatus.PASS, " agent_state from agent_live table After click on ready Button ::\t"+agent_state);
		    	 logger.log(LogStatus.PASS, " dialer_type from data base ::\t"+dialer_type);
		    	 logger.log(LogStatus.PASS, " Campaign id from agent table ::\t"+campaign_id1);
		    	 logger.log(LogStatus.PASS, " Campaign id from agent_live table ::\t"+campaign_id);
		      }
	    	else if(dialer_type.equals("PREVIEW"))
	    	 {
	    		 logger = extent.startTest("Ready_button ");
		 	     //Assert.assertTrue(true);
		    	 logger.log(LogStatus.PASS, "Ready_button  test case is pass ");
		    
	             logger.log(LogStatus.PASS, " agent_state from agent_live table  After click on ready Button ::\t"+agent_state);
		    	 logger.log(LogStatus.PASS, " dialer_type from data base ::\t"+dialer_type);
		    	 logger.log(LogStatus.PASS, " Campaign id from agent table ::\t"+campaign_id1);
		    	 logger.log(LogStatus.PASS, " Campaign id from agent_live table ::\t"+campaign_id);
	    	 }
		     else
		      {
		   	   logger = extent.startTest("Ready_button ");
		 	   //Assert.assertTrue(true);
		 	  logger.log(LogStatus.FAIL, "Ready_button  test case is fail because some data not available in data base");
		 	  logger.log(LogStatus.FAIL, " agent_state from agent_live table After click on ready Button ::\t"+agent_state);
		      logger.log(LogStatus.FAIL, " dialer_type from data base ::\t"+dialer_type);
		      logger.log(LogStatus.FAIL, " Campaign id from agent table ::\t"+campaign_id1);
		      logger.log(LogStatus.FAIL, " Campaign id from agent_live table ::\t"+campaign_id);
		      System.out.println("Ready_button  test case is fail because some data not available in data base(some column missing in table campaign)");
		      }
	    }
	*/
}

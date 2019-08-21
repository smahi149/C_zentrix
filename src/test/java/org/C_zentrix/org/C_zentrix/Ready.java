package org.C_zentrix.org.C_zentrix;
import org.openqa.selenium.By;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Ready extends MethodClass
{
	static String Readybutton="";
	public static void ready() throws InterruptedException
	{
		Thread.sleep(1000);
    	//Ready the agent
		if(isElementPresent(By.name("ready")))
		{
			driver.findElement(By.name("ready")).click();
			System.out.println("click on ready button");
			Readybutton="Ready";
	    }
    }
	 public static void  extentReport()
	    {
	    	Logger log=Logger.getLogger("Ready button test case extent report");
			PropertyConfigurator.configure("Log4j.Properties");
			log.info("start ready button   test case extent report method ");
	    	 if(agent_state.equals("FREE")&&dialer_type.equals("PROGRESSIVE")&&Readybutton.equals("Ready"))
		       {
		     	 logger = extent.startTest("Ready_button ");
		 	     //Assert.assertTrue(true);
		    	 logger.log(LogStatus.PASS, "Ready_button  test case is pass ");
		    	
		    	 logger.log(LogStatus.PASS, " agent_state from Agent_live table Before click on ready Button::\t"+agent_state_before_login);
	             logger.log(LogStatus.PASS, " agent_state from Agent_live  After click on ready Button ::\t"+agent_state);
		    	 logger.log(LogStatus.PASS, " dialer_type from Agent_live ::\t"+dialer_type);
		    	 logger.log(LogStatus.PASS, " Campaign id from agent table ::\t"+campaign_id1);
		    	 logger.log(LogStatus.PASS, " Campaign id from agent_live table ::\t"+campaign_id);
		      }
	    	else if(dialer_type.equals("PREVIEW")&&agent_state.equals("FREE")&&Readybutton.equals("Ready"))
	    	 {
	    		 logger = extent.startTest("Ready_button ");
		 	     //Assert.assertTrue(true);
		    	 logger.log(LogStatus.PASS, "Ready_button  test case is pass ");
		   
		    	 logger.log(LogStatus.PASS, " agent_state from Agent_live Before click on ready Button::\t"+agent_state_before_login);
	             logger.log(LogStatus.PASS, " agent_state from Agent_live After click on ready Button ::\t"+agent_state);
		    	 logger.log(LogStatus.PASS, " dialer_type from Agent_live ::\t"+dialer_type);
		    	 logger.log(LogStatus.PASS, " Campaign id from agent table ::\t"+campaign_id1);
		    	 logger.log(LogStatus.PASS, " Campaign id from agent_live table ::\t"+campaign_id);
	    	 }
		     else
		      {
		   	   logger = extent.startTest("Ready_button ");
		 	   //Assert.assertTrue(true);
		 	   logger.log(LogStatus.FAIL, "Ready_button  test case is fail because some data not available in data base");
		 
			  logger.log(LogStatus.FAIL, " agent_state from data base Before click on ready Button::\t"+agent_state_before_login);
	          logger.log(LogStatus.FAIL, " agent_state from data base After click on ready Button ::\t"+agent_state);
		      logger.log(LogStatus.FAIL, " dialer_type from data base ::\t"+dialer_type);
		      logger.log(LogStatus.FAIL, " Campaign id from agent table ::\t"+campaign_id1);
		      logger.log(LogStatus.FAIL, " Campaign id from agent_live table ::\t"+campaign_id);
		    if(Readybutton.equals(""))
		    {
		    	  logger.log(LogStatus.FAIL, " Ready button not found");
		    }
		      }
	    }

	 
}

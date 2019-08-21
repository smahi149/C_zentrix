package org.C_zentrix.org.C_zentrix;
import java.io.InputStream;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
//import org.apache.tools.ant.types.resources.selectors.Compare;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test_czentrix extends MethodClass
{   
 
  @BeforeTest
   public  void before() throws Exception 
	{
	  System.out.println("Start Browser test case");
	  Logger loggerr=Logger.getLogger("Test_czentrix");
	  PropertyConfigurator.configure("Log4j.properties");
	  extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html",true);
	  extent.addSystemInfo("Host name", "softwsre Testing Material");
	  extent.addSystemInfo("Environment", "Automation Testing");
	  extent.addSystemInfo("User Name", "C_zentrix");
	  loggerr.info("start before testcase");
try {
	  System.out.println("Start Try block ");
	  logger = extent.startTest("openbrowser");
      logger.log(LogStatus.PASS, "browser test case is pass");
	  System.out.println("call open Browser method ");
	  MethodClass.openBrowser();
	  System.out.println("close open broeser method in try block");
	  loggerr.info("close browser test case in try block");
    } 
 catch(Exception e)
	  {
	   System.out.println(e.getMessage()+" catch block");
	  } 
        System.out.println(" closed Browser test case");
		loggerr.info("close Browser testcase");
	}
 /* @Test(priority=1)
  public void ready() throws InterruptedException
  {
	  Ready.ready();
	  Data();
	  Ready.extentReport();
  }*/
  

   @Test(priority=2)
  public void preView() throws InterruptedException
  {
	  Preview_progressiveButton.preView();
	  Data();
	  Preview_progressiveButton.previewExtentreport();
  }
    @Test(priority=3)
  public void progressive() throws InterruptedException
  {
	  Preview_progressiveButton.progRessive();
	  Data();
	  Preview_progressiveButton.progressiveExtentreport();
  }
   
      @Test(priority=4)
 public void Break() throws InterruptedException
 {
	  Break.Break();

 }

  @Test(priority=5)
  public void Back() throws InterruptedException  
  {
	  Back.Back();
  }
 
  
@Test(priority=6)
public void makeCall() throws Exception 
{
	MakeCall.makecall();
}

  
  @Test(priority=7)
  public void redial() throws InterruptedException 
  {
	  Redial.redial();
  }
  
  
  @Test(priority=8)
  public void conference() throws InterruptedException 
  {
	  Conference.conf();
  }

}

package org.C_zentrix.org.C_zentrix;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class MethodClass 
{  
	public static String sql,agent_live,campaign_id1,customer_table,phone_no,L_id_f_extended,dial_lead_look,p_f_d_lookup,L_id_F_d_state,p_no_F_d_state,current_report,agent_status;  // for query
	public static String  dialer_type,agent_state,campaign_id,break_type,is_paused,p_no_f_dial,p_no_f_extended,agent_state_before_login,dialer_type_before_pre;
	public static int call_count,pause_duration,break_count,autoMode,automode1,is_hold,lead_id,lead_i_f_dial,L_id_f_exte,L_id_f_D_lookup,L_id_f_state,re_d_flag,rd_flag,Agent_name_F_agent_live,agent_live_flag;
    public static ExtentReports extent;
    public static  ExtentTest   logger;
    public static  WebDriver driver;
    public static   FileInputStream f2;
    public static   HSSFWorkbook Hw;
    public static   HSSFSheet Hs;
    public static  SoftAssert assertion= new SoftAssert();
    public static String sql1;
    public static String baseUrl; //for url
    public static void openBrowser() throws IOException, Exception 
	{
    	Logger log=Logger.getLogger("open browser method");
		PropertyConfigurator.configure("Log4j.Properties");
		log.info("start open browser method");
		f2=new FileInputStream("C:\\Users\\tvt\\eclipse-workspace\\Bar1\\TestData\\agentui.xls");
		Hw=new HSSFWorkbook(f2);
	    Hs=Hw.getSheet("Sheet1");
		String excel_url=Hs.getRow(1).getCell(0).getStringCellValue();
		System.out.println(excel_url);
	    System.setProperty("webdriver.gecko.driver", "D:\\himanshu\\driver\\firefoxdriver64\\geckodriver.exe");
     	driver = new FirefoxDriver();
		System.out.println("opening browser");
	//	baseUrl = "http://192.168.1.57/";//172.16.2.19
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.get(excel_url);			 
		driver.findElement(By.name("agent")).clear();
		driver.findElement(By.name("agent")).sendKeys("2121");		
		  if(isElementPresent(By.name("agent_login")))
	      {
		     driver.findElement(By.name("agent_login")).click();
		  }
    	  Data();
		  agent_state_before_login=agent_state;
		  dialer_type_before_pre=dialer_type;
		  automode1=autoMode;
		  System.out.println(agent_state_before_login);
			System.out.println("before login");
			driver.switchTo().frame("main_call_window");
			System.out.println("enter in frame");
   }
   
 // ScreenShot method
	public static  void screen(WebDriver driver,String Screenshotname)
	{    
		System.out.println("start screen shot method start");
	  try {
		   TakesScreenshot ts= (TakesScreenshot)driver;
		   File source= ts.getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(source, new File("./Screenshot1/"+Screenshotname+".png"));
		  System.out.println("taken");
		  } 
	 catch (Exception e) 
		   {
		    e.printStackTrace();
		    System.out.println("Exception while taking screen shot"+e.getMessage());
		  } 
	       System.out.println("close screen shot method");
   }
	//database
	public static void Data()
	{
		System.out.println("start database method");
		  //String input = args.length == 0 ? "1818-11-11" : args[0]; for save special type data
	      Connection con=null;
		  Statement st=null;
		  ResultSet rs=null;
  try{
		  try {
		  Class.forName("com.mysql.jdbc.Driver");//.newInstance();
		  }
		  catch(Exception e)
		  {
			  System.out.println(e.getMessage());
			  System.out.println("exception");
		  }
		     Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("Driver loaded");
			 con=DriverManager.getConnection("jdbc:mysql://192.168.1.57/czentrix_campaign_manager","himanshu68","Himanshu@68");
			 if(con!=null) {
	             System.out.println("Connected to the database");
	         }else {
	             System.out.println("Failed to connect to  database");
	         }
			 String num,camp_id="1609";
			 Hs=Hw.getSheet("Sheet1");
			 num=Hs.getRow(1).getCell(1).getStringCellValue();
			 System.out.println("number from excel"+num);
			sql= "select count(*) from current_report";
            agent_status="select * from agent_live where agent_id='2121'";
			agent_live="select * from agent_live";
            campaign_id1="select campaign_id from agent where agent_name='simi'";
            customer_table="select lead_id from customer_"+camp_id+" where phone1="+num;
            phone_no="select phone1 from customer_"+camp_id+" where phone1="+num;
            L_id_f_extended="select lead_id from extended_customer_"+camp_id+" where phone1="+num;
            p_no_f_extended="select phone1 from extended_customer_"+camp_id+" where phone1="+num;
            dial_lead_look="select lead_id from dial_Lead_lookup_"+camp_id+" where phone="+num;
            p_f_d_lookup="select phone from dial_Lead_lookup_"+camp_id+" where phone="+num;
            L_id_F_d_state="select lead_id from dial_state_"+camp_id+" where phone_no_0="+num;
            p_no_F_d_state="select phone_no_0 from dial_state_"+camp_id+" where phone_no_0="+num;
            current_report="select cust_disposition from current_report where cust_ph_no="+num;
			st=con.createStatement();
	        rs=st.executeQuery(agent_live);
	      while(rs.next())
	 			 {
	 		     	agent_state =rs.getString(4);
	 		    	System.out.println("agent_state   is::"+agent_state);
	 		    	dialer_type =rs.getString(9);
	 		    	System.out.println("dialer_type   is::"+dialer_type);
	 		    	is_paused =rs.getString(12);
	 		    	System.out.println("is_paused   is::"+is_paused);
	 		    	break_type=rs.getString(22);
	 		    	System.out.println("brak_type   is::"+break_type);
	 		     	pause_duration=rs.getInt(23);
			    	System.out.println("pause_duration   is::"+pause_duration);
			    	campaign_id =rs.getString(24);
	 		    	System.out.println("campaign_id   is::"+campaign_id);
			    	autoMode=rs.getInt(25);
			    	System.out.println("autoMode   is::"+autoMode);
			    	is_hold =rs.getInt(33);
	 		    	System.out.println("is_hold   is::"+is_hold);
	 		    	break_count=rs.getInt(60);
	 		    	System.out.println("break_count   is::"+break_count);
	 		    	rd_flag=rs.getInt(39);
	 		    	System.out.println("rd_flag   is::"+rd_flag);
	 		    }	
	 		      rs=st.executeQuery(sql);
				// System.out.println("database table row is\t"+rs.getRow()); 
			     while(rs.next())
				 {
			    	 call_count =rs.getInt(1);
				  System.out.println(" call count  is::"+call_count);
		         }
				 rs=st.executeQuery(campaign_id1);
				 while(rs.next())
				 {
				    campaign_id1 =rs.getString(1);
					System.out.println("campaign_id from agent table  is::"+campaign_id1);
			     }
			 
		  
			 
			 
			  
			 
		    
			
	    }	 
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }

	}

	
	public static   boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;                                           
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	// Alert method

	  public static boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  public static String closeAlertAndGetItsText() {
		    boolean acceptNextAlert = false;
			try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }

		    @AfterMethod
			 public void getResult(ITestResult result)
			 {     
			  if(result.getStatus()==ITestResult.FAILURE) 
			   {
			    logger.log(LogStatus.FAIL, "Test case failed is "+result.getName());
			    logger.log(LogStatus.FAIL, "Test case failed is "+result.getThrowable());
			   }
			  else if(result.getStatus()==ITestResult.SKIP)
			   {
			    logger.log(LogStatus.SKIP, "Test case skipped is"+result.getName());
			   }
			   extent.endTest(logger);
			}
			    @AfterTest
			    public void endReport()
			    {
			    	extent.flush();
			    	//extent.close();
			    }
}



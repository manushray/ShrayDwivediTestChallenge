package shrayTestChallenge.gnucashAndriod;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import shrayTestChallenge.gnucashAndriod.Pages.App;
import shrayTestChallenge.gnucashAndriod.codeBase.Base;



//@Listeners(mobileAndriod.mobileAndriodChallenge.ExtentReportListener.ExtentReportNG.class)
public class AppTest extends Base
{
	static App app;

    public AppTest( ) throws Exception
    {
        super();
        initialisation();
        log.info("Code is coming in Constructor method of AppTest class");
    }
    
    @BeforeMethod
    public static void setup() throws Exception {
    	
    	 app =new App(driver);
    	 log.info("Code is coming in Before method of AppTest class");
    }
    
    @Test
    public static void applaunchWelcomemethodTest() throws Exception {
    String title=app.applaunchWelcomeMethod();
    	System.out.println("title got from app is:"+title);
    	Assert.assertEquals(title, "Welcome to GnuCash");
    }
    
    @Test
    public static void currencmethodTest() throws Exception {
    String title=app.defaultCurrMethod();
    	System.out.println("title got from app is:"+title);
    	Assert.assertEquals(title, prop.getProperty("currency_type"));
    }
    
    @Test
    public static void accntmethodTest() throws Exception {
    String title=app.accntSetupMethod();
    	System.out.println("title got from app is:"+title);
    	Assert.assertEquals(title, prop.getProperty("accnt_type"));
    }
    
    @Test
    public static void feedbackmethodTest() throws Exception {
    String title=app.feedbackMethod();
    	System.out.println("title got from app is:"+title);
    	Assert.assertEquals(title, prop.getProperty("feedback_option"));
    }
    
    @Test
    public static void reviewmethodTest() throws Exception {
    app.reviewMethod();
    
    }
    
    @AfterMethod
    public static void tearDown(ITestResult result) {
    	log.info("Code is coming in After method of AppTest class");
    	driver.quit();

    }
    
    
  
}
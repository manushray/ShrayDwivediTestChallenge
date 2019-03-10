package shrayTestChallenge.gnucashAndriod;

/*************************************** PURPOSE **********************************
- This class automate is used for maintaining the TEST Case using TestNG. In before class method I am calling all the method 
which is used for installation of the application so that it wont repeat again & again for other test cases.
*/

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import shrayTestChallenge.gnucashAndriod.Pages.App;
import shrayTestChallenge.gnucashAndriod.Pages.AppDashboard;
import shrayTestChallenge.gnucashAndriod.Pages.RecentDeleteEditTabMethod;

import shrayTestChallenge.gnucashAndriod.Pages.SalaryAccntFavorite;
import shrayTestChallenge.gnucashAndriod.Pages.TransactionMethod;
import shrayTestChallenge.gnucashAndriod.codeBase.Base;


@Listeners(shrayTestChallenge.gnucashAndriod.ExtentReportListener.ExtentReportNG.class)
public class AppDashboardTest extends Base{

	static AppDashboard appdash;
	static App app;
	static TransactionMethod trnx;
	static RecentDeleteEditTabMethod recentdeledittab;
	static SalaryAccntFavorite sal;
	static boolean flag;
	
	
	public AppDashboardTest() {
		super();
        
	}
	
	@BeforeClass
	public void applaunchMethod() throws Exception {
		initialisation();
        app=new App(driver);
        app.applaunchWelcomeMethod();
        app.defaultCurrMethod();
        app.accntSetupMethod();
        app.feedbackMethod();
        appdash=app.reviewMethod();
        
	}
	
	@Test(priority=1)
    public static void appDashBoardMethodTest() throws Exception {
		trnx=appdash.assetMethod();
    }
	
	@Test(priority=2)
    public static void appNewTransactionmethodTest() throws Exception {
		
		trnx.newCreateTrnsxMethod(prop.getProperty("Desc_add_cash_wallet"),prop.getProperty("amount"));
		flag=trnx.walletCashValidationMethod();
		Assert.assertEquals(flag, true);
		recentdeledittab=trnx.recentpass();
    }
	
	@Test(priority=3)
    public static void appRecentNewAccntDeleteEditTabmethodTest() throws Exception {
		recentdeledittab.recentEditDeletetab();		
		sal=recentdeledittab.salAccountPass();	
    }
		
	@Test(priority=4)
    public static void appSalaryAccntmethodTest() throws Exception {
		Thread.sleep(1800);
		flag=sal.salaryaccntFavoriteMethod();
		Assert.assertEquals(flag, true);
    }
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}

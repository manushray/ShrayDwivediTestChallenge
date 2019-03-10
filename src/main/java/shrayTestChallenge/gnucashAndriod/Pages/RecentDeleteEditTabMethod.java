package shrayTestChallenge.gnucashAndriod.Pages;


/*************************************** PURPOSE **********************************
- This class automate the functionality  of Recent Tab,Creation of New Account/Sub-Account , Edit & Delete functionality of the application.
*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class RecentDeleteEditTabMethod extends AppDashboard{

	
	static WebDriverWait wait = new WebDriverWait(driver,60);
	
public RecentDeleteEditTabMethod() {
	
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		log.info("Code is coming in Constructor method of Transaction class");
	}
	
	
	public void recentEditDeletetab() throws InterruptedException {
		/* Recent Tab functionality*/
		touchAction.tap(new PointOption().withCoordinates(260, 347)).perform();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("primary_text")).click();
		recenttrnx.click();
		String val=headerValue.getText();
		System.out.println("Value from recent tab:"+val);
		Assert.assertEquals(val, prop.getProperty("Desc_add_cash_wallet"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.navigate().back();
		Thread.sleep(1200);
		touchAction.tap(new PointOption().withCoordinates(711, 370)).perform();		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		createnewtab.click();
		accntnamecreation.sendKeys("accnt name creation testing");
		accntdescription.sendKeys("Details about new creation can be written here");
		savebtn.click();
		Thread.sleep(1500);
		
		/* Edit functionality*/
		
		touchAction.tap(new PointOption().withCoordinates(1365, 2174)).perform();
		Thread.sleep(1500);
		touchAction.tap(new PointOption().withCoordinates(925, 2329)).perform();
		WebElement editfunc;
		editfunc= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input_account_name")));
		editfunc.click();
		editfunc.clear();
		accntnamecreation.sendKeys("accnt name edited testing");
		colorpicker.click();
		driver.findElement(By.id("color_picker_swatch")).click();
		placeholdercheckbox.click();
		savebtn.click();		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		touchAction.tap(new PointOption().withCoordinates(1365, 2169)).perform();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		/* Delete functionality*/
		touchAction.tap(new PointOption().withCoordinates(1000, 2313)).perform();
	}
	
	public AppDashboard editpass() {
		
		return new AppDashboard();
	}

	public SalaryAccntFavorite salAccountPass() {
		return new SalaryAccntFavorite();
	}
}

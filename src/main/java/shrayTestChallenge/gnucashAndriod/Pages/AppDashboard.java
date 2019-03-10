package shrayTestChallenge.gnucashAndriod.Pages;

/*************************************** PURPOSE **********************************
- This class automate the functionality  of Dashboard,EDIT functionality of the application and is used to store the WebElement using 
PageFactory model.

*/


import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import shrayTestChallenge.gnucashAndriod.codeBase.Base;

public class AppDashboard extends Base {
	
	public static int walletcashdeposit;
	public static int accntbal;
	public static TouchAction touchAction=new TouchAction(driver);
	static WebDriverWait wait = new WebDriverWait(driver,60);
		
	
	
	@AndroidFindBy(id="primary_text")
	WebElement assetsbtn;
	
	@AndroidFindBy(id="primary_text")
	WebElement curntassestbtn;
	
	@AndroidFindBy(id="create_transaction")
	WebElement addcashwalletbtn;
	
	
	@AndroidFindBy(id="input_transaction_name")
	WebElement adddesctextfield;
	
	@AndroidFindBy(id="input_transaction_amount")
	WebElement cashamounttextfield;
	
	@AndroidFindBy(id="menu_save")
	WebElement savebtn;
	
	@AndroidFindBy(id="account_balance")
	WebElement checkaccntbal;
	
	@AndroidFindBy(id="button1")
	WebElement dismissbtn;
	
	@AndroidFindBy(id="list_item_2_lines")
	WebElement recenttrnx;
	
	@AndroidFindBy(id="trn_description")
	WebElement headerValue;
	
	@AndroidFindBy(id="fab_create_account")
	WebElement createnewtab;
	
	@AndroidFindBy(id="fab_create_transaction")
	WebElement salarycreditbtn;
	
	
	@AndroidFindBy(id="input_account_name")
	WebElement accntnamecreation;
	
	@AndroidFindBy(id="input_account_description")
	WebElement accntdescription;
	
	@AndroidFindBy(id="input_color_picker")
	WebElement colorpicker;
	
	@AndroidFindBy(id="checkbox_placeholder_account")
	WebElement placeholdercheckbox;
	
	@AndroidFindBy(id="favorite_status")
	WebElement favstatbtn;
	
	
	public AppDashboard() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	public TransactionMethod assetMethod() throws InterruptedException {
		
		WebElement dismiss;
		dismiss= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button1")));
		dismiss.click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//	driver.findElement(By.xpath("//android.widget.TextView[@text='Assets']")).click();
		touchAction.tap(new PointOption().withCoordinates(266, 532)).perform();				
		accntselectMethod("Assets");
		addcashwalletbtn.click();
		return new TransactionMethod();
		
	}

	
	public void editMethod() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		accntnamecreation.clear();
		accntnamecreation.sendKeys("accnt name edited testing");
		colorpicker.click();
		driver.findElement(By.id("color_picker_swatch")).click();
		placeholdercheckbox.click();
		savebtn.click();
	}
		
	
	public boolean accntselectMethod(String Value) {
		boolean flag=false;
		List<WebElement> elements = driver.findElements(By.id("primary_text"));
		for(WebElement wb : elements) {
			System.out.println("The WebElement are:"+wb.getText());
			if(wb.getAttribute("text").contains(Value)) {
				
				flag=true;
				 wb.click(); 
				 break;
			}
}
		return flag;
	}
	
	


	
    
}


package shrayTestChallenge.gnucashAndriod.Pages;

/*************************************** PURPOSE **********************************
- This class automate the installation of the application till it got launched.
*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import shrayTestChallenge.gnucashAndriod.codeBase.Base;


public class App extends Base {

	@AndroidFindBy(className="android.widget.TextView")
	WebElement applaunch;
	
	@AndroidFindBy(id="title")
	WebElement titleelement;
	
	@AndroidFindBy(id="btn_save")
	WebElement nextbtn;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Create default accounts')]")
	WebElement MedianValue;
	
	@AndroidFindBy(xpath="//*[contains(@text,'EUR')]")
	WebElement currbtn;
	
	
	
	//Initializing the Page Object
	public App(AppiumDriver<WebElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log.info("Code is coming in Constructor method of App class");
	}


	
	
	public String applaunchWelcomeMethod() throws Exception {
		applaunch.click();
		log.info("Code is coming in applaunchMethod of App class");
		return titleelement.getText();
	}
	
	
	
	
	
	public String defaultCurrMethod() throws Exception {
		nextbtn.click();
		log.info("Code is coming in defaultCurrMethod of App class");
		optionclickMethod(prop.getProperty("currency_type"));		
		nextbtn.click();
		return titleelement.getText();
	}
	
	public String accntSetupMethod() throws Exception {
		
		log.info("Code is coming in accntSetupMethod of App class");
		optionclickMethod(prop.getProperty("accnt_type"));
		nextbtn.click();
		return titleelement.getText();
	}
	
	public String feedbackMethod() throws Exception {
		
		log.info("Code is coming in feedbackMethod of App class");
		optionclickMethod(prop.getProperty("feedback_option"));
		nextbtn.click();
		return titleelement.getText();
	}
	
	public AppDashboard reviewMethod() throws Exception {
		log.info("Code is coming in reviewMethod of App class");
		String curr=textreturnMethod(prop.getProperty("currency_type"));
		Assert.assertEquals(curr,prop.getProperty("currency_type"));
		String accnt=textreturnMethod(prop.getProperty("accnt_type"));
		Assert.assertEquals(accnt,prop.getProperty("accnt_type"));
		String feedback=textreturnMethod(prop.getProperty("feedback_option"));;
		Assert.assertEquals(feedback,prop.getProperty("feedback_option"));
		nextbtn.click();
		return new AppDashboard();
	}
	
}
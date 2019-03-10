package shrayTestChallenge.gnucashAndriod.Pages;

/*************************************** PURPOSE **********************************
- This class automate the functionality  of New Transaction Module and Validation of Wallet Account functionality of the application.
*/

import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TransactionMethod extends AppDashboard {
	
	private static float newbal;
	private static float expectbal;

	
public TransactionMethod() {
	
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		log.info("Code is coming in Constructor method of Transaction class");
	}
	
public void newCreateTrnsxMethod(String descdetail,String amnt) {
		
		adddesctextfield.sendKeys(descdetail);
		cashamounttextfield.sendKeys(amnt);
		int cashfromstrngtoint=Integer.parseInt(prop.getProperty("amount"));
		walletcashdeposit=walletcashdeposit+cashfromstrngtoint;
		System.out.println("Cash deposited in Wallet:"+walletcashdeposit);
		savebtn.click();
		
	}


public boolean walletCashValidationMethod() {
    boolean flag;
	String bal=checkaccntbal.getText();
	bal=bal.replaceAll("[^\\d.]", "");
	newbal=Float.parseFloat(bal);
	expectbal=Float.parseFloat(prop.getProperty("amount"));
	accntbal=accntbal-walletcashdeposit;
	System.out.println("Bal. in Account:"+accntbal);
	driver.navigate().back();
	driver.navigate().back();
	if(expectbal==newbal) {
		flag=true;
	}else {
		flag=false;
	}
	return flag;
}

public RecentDeleteEditTabMethod recentpass() {
	
	return new RecentDeleteEditTabMethod();
}
	
}

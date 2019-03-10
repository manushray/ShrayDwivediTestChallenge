package shrayTestChallenge.gnucashAndriod.Pages;


/*************************************** PURPOSE **********************************
- This class automate the functionality  of Salary(Account in Dashboard),Favorite functionality of the application 

*/


import java.util.concurrent.TimeUnit;

import io.appium.java_client.touch.offset.PointOption;

public class SalaryAccntFavorite extends TransactionMethod{
	
	
	
	public boolean salaryaccntFavoriteMethod() throws InterruptedException {
		/*Salary Functionality */
		
		touchAction.tap(new PointOption().withCoordinates(250, 1463)).perform();
		Thread.sleep(1500);
		touchAction.tap(new PointOption().withCoordinates(600, 1781)).perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		salarycreditbtn.click();
		newCreateTrnsxMethod("salary credited","5000");
		driver.navigate().back();
		driver.navigate().back();

		
		/* Favorite Functionality */
		Thread.sleep(1500);
		touchAction.tap(new PointOption().withCoordinates(1347, 515)).perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		touchAction.tap(new PointOption().withCoordinates(260, 347)).perform();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		touchAction.tap(new PointOption().withCoordinates(1186, 359)).perform();
		boolean flag=accntselectMethod("Assets");
		return flag;
	}
	
}

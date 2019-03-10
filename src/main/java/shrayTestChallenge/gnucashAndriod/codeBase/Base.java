package shrayTestChallenge.gnucashAndriod.codeBase;


/*************************************** PURPOSE **********************************
- This class is the base class where driver is initialized along with the configuration of reading a file within the package defined
and method which is used to find the element on the basis of class Name & attributes
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import android.os.Build;
import android.util.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.*;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Base 
{
    
	public static AppiumDriver<WebElement> driver;
	public static Properties prop;
	public static Logger log= LogManager.getLogger(Base.class);
	public static DesiredCapabilities cap = new DesiredCapabilities();
	
	public Base(){
		
		try {
			prop =new Properties();
			
			FileInputStream ip= new FileInputStream("./src/main/java/shrayTestChallenge/gnucashAndriod/configuration/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public static void initialisation() throws Exception {
			
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Andriod Emulator");
			cap.setCapability(MobileCapabilityType.APP,prop.getProperty("App_Path"));
			cap.setCapability("appWaitActivity","org.gnucash.android.ui.wizard.FirstRunWizardActivity");
			cap.setCapability("autoGrantPermissions",true);
			cap.setCapability("appPackage","org.gnucash.android");
			cap.setCapability("activityName","org.gnucash.android.ui.wizard.FirstRunWizardActivity");
			driver= new AndroidDriver<WebElement>(new URL(prop.getProperty("Appium_URL")),cap);
			log.info("Code is coming in initialisation method of Base class");
			 
			

}
	
	public void optionclickMethod(String Value) {
		List<WebElement> elements = driver.findElements(By.className("android.widget.CheckedTextView"));
		for(WebElement wb : elements) {
			if(wb.getAttribute("text").equals(Value)) {
				wb.click(); 
				
				break;
			}
		}
		
	}
	
	public String textreturnMethod(String Value) {
		List<WebElement> elements = driver.findElements(By.className("android.widget.TextView"));
		String strngvalue=null;
		for(WebElement wb : elements) {
			if(wb.getAttribute("text").equals(Value)) {
				 strngvalue=wb.getText(); 
				
				break;
			}
		}
		return strngvalue;
	}
	
	
	
	
		
	
}
# ShrayDwivediTestChallenge


Task 1: 

Test Suite is present in TestSuite.xlsx File.

Task 2:
Task for Automation where all the test case idea, prioritization,pro-con of automated test cases summary is present in Task_Automation.docx

Prerequisites – SYSTEM SETUP

Appium: v1.8 or above, if not installed then you can install it from below mentioned URL:https://bitbucket.org/appium/appium.app/downloads/

Java: v1.8 v)(if not installed use: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
GnucashAndroid_v2.4.0.apk: Copy the .apk file to your "Andriod/sdk/platform-tools/" path. I used Mac so my path was "/Users/sdwivedi/Library/Andriod/sdk/platform-tools"

Andriod Emulator: you can use any emulator of your choice, I used Andriod Virtual Device Manager. Once you launch the Emulator you should see the "gnucash" app in the App section. (if you don’t have it then download the android studio from the following link : "https://developer.android.com/studio/" you can launch the emulator from "Android Studio > tools > AVD Manager")

Eclipse

Maven: Apache Maven 3.5.4 , if it’s not installed please install from "https://maven.apache.org/install.html"

How to Clone the project from GitHub:

#Clone the code by using below command at your folder destination where you want the code. 
git clone https://github.com/manushray/ShrayDwivediTestChallenge.git

#Open the Eclipse follow the below steps:
1.	Click on the "File > Import "
2.	Navigate to Maven > Existing Maven Projects & click on "Next".
3.	Browse to the location of folder where you have clone the code & click on "Finish"

Description About Code/Framework :

I have created a partial Automation Framework comprise of (Selenium+ JAVA+ Page Object Model+ TestNG+ Appium +Extent Report) .
•	"Base" class is Parent of all the classes  where Driver initialisation + capabilities are defined which is present under package name "shrayTestChallenge.gnucashAndriod.codeBase"
•	All the application code is present under package: “shrayTestChallenge.gnucashAndriod.Pages”
•	Reporting is done by Extent Report whose code is present under package: “shrayTestChallenge.gnucashAndriod.ExtentReportListener”
•	Test Cases are handled by TestNG and as I have build my code using MAVEN hence its present under “src/test/java”

As I have made my code dynamic from where you can change the parameter and data set/Test scenario by changing in the config.properties file which is present under package name "src/main/java/shrayTestChallenge/gnucashAndriod/configuration/config.properties”

Please change the below mentioned parameter to run the script:
1.	 Appium_URL (you have to give your appium server Host:port) like http://0.0.0.0:4723/wd/hub so your URL will look like "http://Host:port/wd/hub"
2.	App_Path (you have to give your GnucashAndroid_v2.4.0.apk file installed path that would be) "your file location of /Andriod/sdk/platform-tools/ GnucashAndroid_v2.4.0.apk" mine was "/Users/sdwivedi/Library/Android/sdk/platform-tools/GnucashAndroid_v2.4.0.apk"

You have to make 2 changes and run the code either by command line or from Eclipse itself:
BUT MAKE SURE YOUR APPIUM & EMULATOR SHOULD BE UP & RUNNING

#Command Line Command:

•	go to the project folder and run the below command: 
o	mvn clean install 

#Eclipse:

•	Click on "Project > Run As > Maven test"


The whole code will run in around 2:23min 

Once Code will run , please refresh the project so that you can view the result either on eclipse console or in FinalExtentReport.html(this you have to view in Browser)this is for better reporting purpose.

Description About Flow of the Automated Test Scenario:

1.	Setup/Installation.
2.	Dashboard (3tab page: Recent, All, Favorites)
3.	Assets > Current Assets > Cash in Wallet > New Transaction.
4.	Recent Tab > Cash in Wallet > Transaction (To validate the functionality)
5.	All > New Account > Edit > Delete.
6.	Salary Account > Transaction > All .
7.	Assets > Favorite Icon > Recent tab > Favorites Tab (To validate the functionality).


PS: I have used id , search webelement on basis of attribute & using PointOption > TouchAction using co-ordinates wherever required.Also I have used all Wait command types including implicit wait, Explicit wait & Thread.sleep to showcase that if required I can work with any of these techniques.

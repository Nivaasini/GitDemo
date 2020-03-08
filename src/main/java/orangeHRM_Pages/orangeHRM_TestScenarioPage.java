package orangeHRM_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import baseClassLib.BaseClass;
import orangeHRM_Properties.orangeHRM_EducationProperities;
import orangeHRM_Properties.orangeHRM_HomeProperities;
import orangeHRM_Properties.orangeHRM_LoginProperities;

public class orangeHRM_TestScenarioPage extends BaseClass {

	@Test
	public void loginPage(String url, String UserName, String Password) throws Exception
	{

		//Chrome Driver Initialization
		System.setProperty("webdriver.chrome.driver","C:/Drivers/chromedriver.exe");
		driver = new ChromeDriver();			
		driver.manage().window().maximize();

		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Launch Application
		driver.get(url);

		//Verify Orange Login page is displayed
		driver.findElement(orangeHRM_LoginProperities.pgLogin);

		//Enter the user name
		driver.findElement(orangeHRM_LoginProperities.weUserName).click();
		driver.findElement(orangeHRM_LoginProperities.weUserName).sendKeys(UserName);

		//Enter the Password
		driver.findElement(orangeHRM_LoginProperities.wePassword).click();
		driver.findElement(orangeHRM_LoginProperities.wePassword).sendKeys(Password);

		//Click on Login button
		driver.findElement(orangeHRM_LoginProperities.btnLogin).submit();


	}

	@Test
	public void HomePage() throws Exception

	{

		//Verify Admin logged into application successfully
		driver.findElement(orangeHRM_HomeProperities.pgAdminHome);

		//CLick on Admin menu --> Qualifications --> Education
		driver.findElement(orangeHRM_HomeProperities.btnAdmin).click();
		driver.findElement(orangeHRM_HomeProperities.btnQualifications).click();
		driver.findElement(orangeHRM_HomeProperities.lnkEducation).click();



	}	

	@Test
	public void EducationPage(String Level1, String Level2) throws Exception
	{

		//Verify Education record list page is displayed
		driver.findElement(orangeHRM_EducationProperities.pgEducation);
		Thread.sleep(3000);

		//Add at least two records (Levels) under Education
		//Click on Add button
		driver.findElement(orangeHRM_EducationProperities.btnAdd).click();
		Thread.sleep(2000);

		//Enter the level value 
		driver.findElement(orangeHRM_EducationProperities.weEducationLevel).sendKeys(Level1);
		Thread.sleep(2000);

		//Click on Save Button
		driver.findElement(orangeHRM_EducationProperities.btnSave).submit();
		String text = driver.findElement(orangeHRM_EducationProperities.weMessageValidation).getText().trim();
		System.out.println(text);
		if(text.contains("Successfully Saved"))

		{
			System.out.println("Message is validated Successfully for 1st level");
		}
		else
		{
			System.out.println("Miss Match Occurs in message validation text Content");
		}
		//Click on Add button
		driver.findElement(orangeHRM_EducationProperities.btnAdd).click();
		Thread.sleep(2000);

		//Enter the level value 
		driver.findElement(orangeHRM_EducationProperities.weEducationLevel).sendKeys(Level2);
		Thread.sleep(2000);

		//Click on Save Button
		driver.findElement(orangeHRM_EducationProperities.btnSave).submit();
		String text1 = driver.findElement(orangeHRM_EducationProperities.weMessageValidation).getText().trim();
		System.out.println(text1);
		if(text.contains("Successfully Saved"))

		{
			System.out.println("Message is validated Successfully for 2nd level");
		}
		else
		{
			System.out.println("Miss Match Occurs in message validation text Content");
		}
		Thread.sleep(3000);

		//Select any Level and Delete
		driver.findElement(orangeHRM_EducationProperities.wechkBox).click();
		Thread.sleep(2000);
		driver.findElement(orangeHRM_EducationProperities.btnDelete).submit();
		String DeleteText = driver.findElement(orangeHRM_EducationProperities.weMessageValidation).getText().trim();
		System.out.println(DeleteText);
		if(DeleteText.contains("Successfully Deleted"))

		{
			System.out.println("Message is validated Successfully for Deletion");
		}
		else
		{
			System.out.println("Miss Match Occurs in message validation text Content");
		}
		
		//Verify Deleted Level should not be there in the page
		int Size = driver.findElements(orangeHRM_EducationProperities.txtMBA).size();
		if(Size==0)
			System.out.println("Deleted value is not displayed in site");
		
		
		//Logout
		driver.findElement(orangeHRM_HomeProperities.pgAdminHome).click();
		driver.findElement(orangeHRM_EducationProperities.btnLogout).click();
		driver.quit();
			













	}
}





package orangeHRM_Test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelLib.ExcelLib;
import jxl.read.biff.BiffException;
import orangeHRM_Pages.orangeHRM_TestScenarioPage;

public class orangeHRM_DemoTest {
	@DataProvider
	public Object[][] data() throws BiffException, IOException 
	{
		ExcelLib xl = new ExcelLib("Test", this.getClass().getSimpleName());
		return xl.getTestdata();
	}
	@Test(dataProvider = "data")
	public void TestDemo(String url, String UserName, String Password,String Level1, String Level2) throws Exception
	{
		//Instantiate the page
		orangeHRM_TestScenarioPage LP = new orangeHRM_TestScenarioPage();


		LP.loginPage(url, UserName, Password);
		LP.HomePage();
		LP.EducationPage(Level1, Level2);
	}
}

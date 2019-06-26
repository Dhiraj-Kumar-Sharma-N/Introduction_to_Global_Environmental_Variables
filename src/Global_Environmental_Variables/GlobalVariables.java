package Global_Environmental_Variables;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class GlobalVariables {
	
	public WebDriver driver= null;

	
	@Test
	
	
	public void Login () throws IOException {
		
		Properties propObj = new Properties();
		
		FileInputStream FileLocationObj = new FileInputStream("C:\\Users\\dsharman2\\Sample-workspace\\Introduction_to_Global_Variables\\src\\Global_Environmental_Variables\\data.properties");
		
		propObj.load(FileLocationObj);
		
		System.out.println(propObj.getProperty("URL"));
		
		System.out.println(propObj.getProperty("Username"));
		
		System.out.println(propObj.getProperty("Password"));
		
// Browser launch Code 		
		
if (propObj.getProperty("Browser").equalsIgnoreCase("Firefox")) {
	
	
	System.setProperty("webdriver.gecko.driver","C://UDEMY_Selenium//Web Drivers//geckodriver.exe");
	
	driver= new FirefoxDriver();
		
	System.out.println(" Firefox Browser launched Successfully ");
		
}	
	
else if (propObj.getProperty("Browser").equalsIgnoreCase("Chrome")) {
	
	System.setProperty("webdriver.chrome.driver","C:\\UDEMY_Selenium\\Web Drivers\\chromedriver.exe");
	
	driver= new ChromeDriver();
	
	System.out.println("Chrome Browser launched Successfully ");

}

else if (propObj.getProperty("Browser").equalsIgnoreCase("IE")) {
	

	System.setProperty("webdriver.ie.driver","C:\\UDEMY_Selenium\\Web Drivers\\IEDriverServer.exe");
		
		WebDriver driver= new InternetExplorerDriver();
		
		
		System.out.println("IE Browser launched Successfully ");
		
		driver.manage().window().maximize();
		
		
}

		driver.get(propObj.getProperty("URL"));
		
		driver.quit();

}
}
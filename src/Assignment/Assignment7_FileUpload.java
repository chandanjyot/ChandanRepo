package Assignment;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Assignment7_FileUpload {
	
	static WebDriver d = setChromeDrivePath();
	
	public static void main(String[] args) throws InterruptedException {


		
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.get("file:///C:/Users/chandanjyot/Desktop/Assignment_7.html");
		
		WebElement browse = d.findElement(By.xpath("//input[@type='file']"));
		browse.sendKeys("C:/Users/chandanjyot/Desktop/403Error.jpeg");
		
		String script = executeJavascriptWithReturn("return document.getElementsByName('uploadsubmit')[0].value").toString();
		
		Thread.sleep(1000);
		
		System.out.println(script);

}

	protected static Object executeJavascriptWithReturn(String script) {
		  return ((JavascriptExecutor) d).executeScript(script);
		 }
	
public static ChromeDriver setChromeDrivePath() {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	DesiredCapabilities cap = DesiredCapabilities.chrome();
	cap.setCapability(ChromeOptions.CAPABILITY, options);
	return new ChromeDriver(cap);
	}
}
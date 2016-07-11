package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Assignment8_Alert {
	
	public static void main(String[] args) throws InterruptedException {


		WebDriver d = setChromeDrivePath();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		d.get("https://joecolantonio.com/SeleniumTestPage.html");
		
		WebElement AlertLink = d.findElement(By.xpath("//h2//a[2]"));
		AlertLink.click();
		
		Thread.sleep(1000);
		
		Alert alert = d.switchTo().alert();
		System.out.println("Alert Text: " +alert.getText());
		alert.accept();
		
		d.close();

		
		}

	public static ChromeDriver setChromeDrivePath() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return new ChromeDriver(cap);
	}
}

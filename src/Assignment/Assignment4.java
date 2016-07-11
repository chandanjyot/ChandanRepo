package Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {

		int construction = 0;
		int found = 0;

		WebDriver d = setChromeDrivePath();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("http://newtours.demoaut.com/");

		
		List<WebElement> li = d.findElements(By.tagName("a"));

		int size = d.findElements(By.tagName("a")).size();

		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(li.get(i).getText());
			li.get(i).click();
			
			if (d.getTitle().contains("Construction")) {
				System.out.println("page is under Construction");
				construction++;
				}

			else {
				found++;
				System.out.println("page is found");
			}
			d.navigate().back();
			Thread.sleep(1000);
			li = d.findElements(By.tagName("a"));
			
		}
		
		System.out.println(construction + " pages are under construction and " + found + " pages are developed ");
		
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

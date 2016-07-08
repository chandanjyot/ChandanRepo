package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;



public class googleSearch_Assignment {
	
	static WebDriver d = setChromeDrivePath();
	
	
		public static void main(String[] args) throws InterruptedException{
			d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			d.get("https://www.google.com");
			//verify google logo via id
			WebElement logo = d.findElement(By.id("hplogo"));
			if(logo.isDisplayed())
				System.out.println("google logo is present");
			else
				System.out.println("logo not found");
			
			//perform search by css
			WebElement searchBox = d.findElement(By.cssSelector("#lst-ib"));
			searchBox.sendKeys("test");
			
			//click on search button by xpath
			d.findElement(By.id("sblsbb")).click();
			
			//results by class name
			//d.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			int results = d.findElements(By.className("r")).size();
			
			System.out.println(results);
		//	d.close();


}

		public static ChromeDriver setChromeDrivePath() {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			return new ChromeDriver(cap);

}
}
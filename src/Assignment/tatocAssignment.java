package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class tatocAssignment {

	static WebDriver d = setChromeDrivePath();
	
	public static void main(String[] args) throws InterruptedException{
		d.get("http://10.0.1.86/tatoc");
		
		//click on Basic course link
		sleep(2);
		WebElement BasicCourse_link = d.findElement(By.xpath("//*[@class='page']//a[1]"));
		BasicCourse_link.click();
		System.out.println("Basic Course Link Clicked");
	
		//click on red box for error page
		sleep(2);
		WebElement redBox = d.findElement(By.xpath("(//div[@class='redbox'])[position()=1]"));
		redBox.isDisplayed();
		redBox.click();
		
		System.out.println("Red box Link Clicked");
		
		if(d.findElement(By.xpath("//div[@class='page']//span")).isDisplayed())
		System.out.println("Error appears");
		
		//navigate back to grid page
		d.findElement(By.xpath("//*[@class='page']//a[1]")).click();
		
		
		//click on green box
		sleep(2);
		WebElement greenBox = d.findElement(By.xpath("//div[@class='greenbox']"));
		greenBox.isDisplayed();
		greenBox.click();
		System.out.println("Green box Link Clicked");
		
		//matching box colors
		WebElement repaintFrame =d.findElement(By.id("main"));
		d.switchTo().frame(repaintFrame);
		
		WebElement Box1 = d.findElement(By.xpath(".//div[@id='answer'][text()='Box 1']"));
		String box1_color = Box1.getAttribute("class");
		System.out.println("box 1 color:" +box1_color);
			
		WebElement frame =d.findElement(By.id("child"));
		d.switchTo().frame(frame);
		
		WebElement Box2 = d.findElement(By.xpath(".//div[@id='answer'][text()='Box 2']"));
		String box2_color = Box2.getAttribute("class");
		System.out.println("box 2 color:" +box2_color);
		
		
		while (!(box1_color.equalsIgnoreCase(box2_color))){
			d.switchTo().parentFrame();
			WebElement repaintLink = d.findElement(By.xpath("//a[text()='Repaint Box 2']"));
			System.out.println("found repaintLink");
		repaintLink.click();
		d.switchTo().defaultContent();
		   d.switchTo().frame(repaintFrame);
		   d.switchTo().frame(frame);
		 box2_color = d.findElement(By.xpath("//div[@id='answer']")).getAttribute("class");
		}
		
		//proceeding to drag page
		d.switchTo().defaultContent();	
		d.switchTo().frame(repaintFrame);
		d.findElement(By.xpath("//a[text()='Proceed']")).click();
		
		//verify drag error
		d.switchTo().defaultContent();
		d.findElement(By.xpath("//a[text()='Proceed']")).click();
		sleep(2);
		if(d.findElement(By.xpath("//h1[text()='Error']")).isDisplayed())
		System.out.println("page not found");
		
		d.navigate().back();
		
		
		Actions action = new Actions(d);
		WebElement Sourcelocator = d.findElement(By.xpath("//div[text()='DRAG ME']"));
		WebElement Destinationlocator = d.findElement(By.xpath(".//div[text()='DROPBOX']"));
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
		d.findElement(By.xpath("//a[text()='Proceed']")).click();
		
		sleep(1);
		//error in pop up window
		d.findElement(By.xpath("//a[text()='Proceed']")).click();
		sleep(1);
		if(d.findElement(By.xpath("//h1[text()='Error']")).isDisplayed())
			System.out.println("pop-up window page not found");
		
		d.navigate().back();
		WebElement popUp_Link = d.findElement(By.xpath("//a[text()='Launch Popup Window']"));
		popUp_Link.click();
		
		System.out.println("Title of the page before - switchingTo: " + d.getTitle());
		 for(String winHandle : d.getWindowHandles()){
	         d.switchTo().window(winHandle);
	       }
	      System.out.println("Title of the page after - switchingTo: " + d.getTitle());
	      
	      WebElement popTextBox = d.findElement(By.xpath(".//input[@id='name']"));
	      popTextBox.sendKeys("Chandan Jyot");
	      
	      WebElement submitButton = d.findElement(By.xpath(".//input[@id='submit']"));
	      submitButton.click();
		}
	

	
	
	
	
	public static ChromeDriver setChromeDrivePath() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return new ChromeDriver(cap);

	}
	
	static void sleep(int number) {
		try {
			Thread.sleep(number * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

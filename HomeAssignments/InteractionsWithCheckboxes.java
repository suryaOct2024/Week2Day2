package week2.day2.HomeAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InteractionsWithCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.manage().window().maximize();
			
		
		//Click on the "Basic Checkbox” 
		
		driver.findElement(By.xpath("//span[text()='Basic']")).click();
				
		// Click on the "Notification Checkbox." 
		
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		
		// Verify that the expected message is displayed. 
		//Enter the below freeze code in the console
		//setTimeout(function(){debugger;},5000); 
		Thread.sleep(1000);
		String notifStr = driver.findElement(By.className("ui-growl-title")).getText();
		if(notifStr.equals("Checked"))
			System.out.println("Notification Check box is selected");
		else
			System.out.println("Notification Check box is not selected");
		
		// Click on your favorite language 
		
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		
		// Click on the "Tri-State Checkbox.
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
		//WebElement element = driver.findElement(By.xpath("(//span[contains(@class,'ui-chkbox-icon')])[8]"));
		WebElement element = driver.findElement(By.id("j_idt87:ajaxTriState"));
		if(element.isEnabled())
		{
			System.out.println("Tristate checkbox is enabled");
			element.click();
		}
		else
			System.out.println("Tristate checkbox is disabled");
		
		
		
		// Verify which tri-state option has been chosen. 
		
		if(element.isSelected())
			System.out.println("Tristate checkbox is selected");
		else
			System.out.println("Tristate checkbox is NOT selected");
		
		// Click on the "Toggle Switch."
		
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		
		// Verify that the expected message is displayed. 
		
		String toggleStr = driver.findElement(By.xpath("//span[text()='Checked']")).getText();
		if(toggleStr.equals("Checked"))
			System.out.println("Expected Message:Toggle switch Checked");
		else
			System.out.println("Expected Message: Toggle switch UnChecked");
		
		// Verify if the Checkbox is disabled. 
		
		WebElement disabledWE = driver.findElement(By.xpath("//input[@aria-label='Disabled']"));
		
		if(disabledWE.isEnabled())
			System.out.println("Checkbox is NOT Disabled");
		else
			System.out.println("Checkbox is Disabled");
			
		
		//Select multiple options on the page
		
		WebElement citiesWE = driver.findElement(By.xpath("//div[@id='j_idt87:multiple']//ul[@data-label='Cities']"));
		citiesWE.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[@data-item-value='Miami']//div[2]")).click();
		driver.findElement(By.xpath("//li[@data-item-value='Rome']//div[2]")).click();
		driver.findElement(By.xpath("//li[@data-item-value='Amsterdam']//div[2]")).click();
		
		String multcity1 = driver.findElement(By.xpath("//ul[@data-label='Cities']//li[1]")).getAttribute("data-item-value");
		String multcity2 = driver.findElement(By.xpath("//ul[@data-label='Cities']//li[2]")).getAttribute("data-item-value");
		String multcity3 = driver.findElement(By.xpath("//ul[@data-label='Cities']//li[3]")).getAttribute("data-item-value");
		
		System.out.println("Multiple Cities selected are:");
		System.out.println(multcity1);
		System.out.println(multcity2);
		System.out.println(multcity3);
		
		driver.close();

	}

}

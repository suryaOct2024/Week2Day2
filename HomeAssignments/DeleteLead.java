package week2.day2.HomeAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Phone")).click();
		
		//driver.findElement(By.name("phoneAreaCode")).sendKeys("120");
		driver.findElement(By.name("phoneNumber")).sendKeys("2109097623");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//Capture the lead ID of the first resulting lead.
		WebElement lead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String leadID = lead.getText();
		System.out.println("First Lead ID:"+leadID);
		
		//Click the first resulting lead. 
		
		lead.click();
		
	/*	driver.findElement(By.linkText("My Leads")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	*/			
		//Click the "Delete" button.
		
		driver.findElement(By.linkText("Delete")).click();
				
		//Click "Find leads" again. 
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Enter the captured lead ID. 
		
		driver.findElement(By.name("id")).sendKeys(leadID);
				
		//Click the "Find leads" button. 
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
				
		//Verify the presence of the message "No records to display" in the Lead List. 
		//This message confirms the successful deletion. 
		
		String text = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		if(text.equals("No records to display"))
			System.out.println("Successful Deletion");
		else
			System.out.println("Deletion is NOT successful!");
		
		//Close the browser. 
		
		driver.close();
		
	}

}

package week2.day2.HomeAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("TestFName");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("TestLName");
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys("TestFNameLcl");
		
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testdept");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Testdescription");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test1@testleaf.org");
		
		
		WebElement stateWE = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateDD = new Select(stateWE);
		stateDD.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Test Note");
		driver.findElement(By.name("submitButton")).click();
		
		String title = driver.getTitle();
		System.out.println("Title of the Update page:"+title);
		
		driver.close();

	}

}

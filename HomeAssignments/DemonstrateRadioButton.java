package week2.day2.HomeAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemonstrateRadioButton {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		driver.manage().window().maximize();
		
		//Select 'Your most favourite browser' from the radio buttons 
		driver.findElement(By.xpath("//label[text()='Firefox']")).click();
		
		//Click on a radio button, then click on the same radio button again to verify that 
		//it becomes ‘unselected’. 
		
		driver.findElement(By.xpath("//label[text()='Chennai']")).click();
		driver.findElement(By.xpath("//label[text()='Chennai']")).click();
		
		Boolean chkSelect = driver.findElement(By.xpath("//label[text()='Chennai']")).isSelected();
		if(!chkSelect)
			System.out.println("The Radio button is deselected for 2nd click");
		else
			System.out.println("The Radio button is still selected for the 2nd click");
		
		//Identify the radio button that is initially selected by default. 
		
		boolean selected = driver.findElement(By.xpath("//label[text()='Safari']")).isEnabled();
		if(selected)
			System.out.println("The default button is:"+driver.findElement(By.xpath("//label[text()='Safari']")).getText());
		
		//Check and select the age group (21-40 Years) if not already selected. 
		
		Boolean age = driver.findElement(By.xpath("//label[text()='21-40 Years']")).isSelected();
		System.out.println("Age selection:"+age);
		if(!age)
			driver.findElement(By.xpath("//label[text()='21-40 Years']")).click();
		
		
	}

}

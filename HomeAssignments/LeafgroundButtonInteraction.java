package week2.day2.HomeAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafgroundButtonInteraction {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		
		//Click on the button with the text ‘Click and Confirm title.’
		
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		String title = driver.getTitle();
		
		//Verify that the title of the page is ‘dashboard.’ 
		
		if(title.equals("Dashboard"))
			System.out.println("Title of the webpage is Dashboard");
		else
			System.out.println("Title of the webpage is not Dashboard");
		
		driver.navigate().back();
				
		//Check if the button with the text ‘Confirm if the button is disabled’ is disabled.
					
		Boolean text = driver.findElement(By.xpath("//h5[text()='Confirm if the button is disabled.']")).isEnabled();
		if(!text)
			System.out.println("The 'Disabled' button is disabled");
		else
			System.out.println("The 'Disabled' button is NOT disabled");
		
		//Find and print the position of the button with the text ‘Submit.’ 
		
		Point location = driver.findElement(By.xpath("(//span[text()='Submit'])[1]")).getLocation();
		System.out.println("The position of 'Submit' is:("+location.x+","+location.y+")");
		
		//Find and print the background color of the button with the text ‘Find the Save button color.’ 
		
		String bgcolor = driver.findElement(By.xpath("//span[text()='Save']")).getCssValue("background-color");
		System.out.println("Background color of 'Save' button:"+bgcolor);
		
		//Find and print the height and width of the button with the text ‘Find the height and width of this button.’
		
		Dimension size = driver.findElement(By.xpath("(//span[text()='Submit'])[2]")).getSize();
		System.out.println("Height of the 'Submit' button:"+size.height);
		System.out.println("Width of the 'Submit' button:"+size.width);
		
		//Close the browser window. 
		
		driver.close();

	}

}

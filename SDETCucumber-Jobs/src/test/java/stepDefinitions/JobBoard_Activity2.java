package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobBoard_Activity2 {
	 WebDriver driver;
	    WebDriverWait wait;
	    
	    @Given("^User is on Jobs Home Page$")
	    public void userIsOnGooglePage() throws Throwable {
	        //Create a new instance of the Firefox driver
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, 15);
	                
	        //Open the browser
	        driver.get("https://alchemy.hguy.co/jobs/");
	        driver.manage().window().maximize();
	    }
	    
	    @When("^Search for jobs$")
	    public void userTypesInCheeseAndHitsENTER() throws Throwable {
	    	driver.findElement(By.xpath("https://alchemy.hguy.co/jobs/jobs/")).click();
	    	driver.findElement(By.id("search_keywords")).sendKeys("Testing");
	    	boolean status = driver.findElement(By.id("job_type_freelance")).isSelected();
	    	if(status == true) {
	    		driver.findElement(By.id("job_type_freelance")).click();
	    	}
	    	driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
	    }

	    @Then("^Apply for job$")
	    public void showHowManySearchResultsWereShown() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("user-search-input")));
	        driver.findElement(By.id("user-search-input")).sendKeys("Rashi");
	        driver.findElement(By.id("search-submit")).click();
	        List<WebElement> list = driver.findElements(By.xpath("//td/strong/a"));
	        boolean matched = false;
	        for (WebElement val :list) {
	        	if(val.getText() == "Rashi") {
	        		matched = true;
	        		 break;
	        	}else {
	        		matched = false;
	        	}
	        }
	        	if(matched = true) 
	        		System.out.println("User is found");
	        	else
	        		System.out.println("User is not found");
	          
	       }

    @And("^Close the browser$")
	    public void closeTheBrowser() throws Throwable {
	        driver.close();
	    }

}

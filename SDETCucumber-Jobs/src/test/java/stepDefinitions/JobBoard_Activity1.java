package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobBoard_Activity1 {
	 WebDriver driver;
	    WebDriverWait wait;
	    
	    @Given("^User is on Wp Admin Home Page$")
	    public void userIsOnGooglePage() throws Throwable {
	        //Create a new instance of the Firefox driver
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, 15);
	                
	        //Open the browser
	        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	        driver.manage().window().maximize();
	        driver.findElement(By.id("user_login")).sendKeys("root");
	        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	        driver.findElement(By.id("wp-submit")).click();
	    }
	    
	    @When("^User Locate the Add New Button and hits ENTER$")
	    public void userTypesInCheeseAndHitsENTER() throws Throwable {
	    	driver.findElement(By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-users']")).click();
	    	driver.findElement(By.xpath("//a[@href='user-new.php']")).click();
	    	driver.findElement(By.id("user_login")).sendKeys("Rashi");
	    	driver.findElement(By.id("email")).sendKeys("rashi@mail.com");
	    	driver.findElement(By.id("createusersub")).click();
	       // driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
	    }

	    @Then("^Verify user was created$")
	    public void showHowManySearchResultsWereShown() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("user-search-input")));
	        driver.findElement(By.id("user-search-input")).sendKeys("Rashi");
	        driver.findElement(By.id("search-submit")).click();
	        List<WebElement> list = driver.findElements(By.xpath("//td/strong/a"));
	        for (WebElement val :list) {
	        	if(val.getText() == "Rashi") {
	        		System.out.println("User is found");
	        	}
	          }
	       }

	    /*@And("^Close the browser$")
	    public void closeTheBrowser() throws Throwable {
	        driver.close();
	    }*/

}

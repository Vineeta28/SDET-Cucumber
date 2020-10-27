package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobBoard_Activity3 {
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^User is on Jobs Page$")
    public void userIsOnJobsPage() throws Throwable {
        //Create a new instance of the Firefox driver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
                
        //Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().maximize();
    }
    
    @When("^Fill the information \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void userfilltheInfo(String gmail, String title, String location,String description, String cmpny_name) throws Throwable {
      driver.findElement(By.xpath("//a[@href='https://alchemy.hguy.co/jobs/post-a-job/']")).click();
  	  driver.findElement(By.id("create_account_email")).sendKeys(gmail);
  	  driver.findElement(By.id("job_title")).sendKeys(title);
  	  driver.findElement(By.id("job_location")).sendKeys(location);
  	  driver.switchTo().frame("job_description_ifr");
  	  System.out.println("Putting values");
  	  driver.findElement(By.xpath("//body/p")).sendKeys(description);
  	  System.out.println("Moving to default content");
  	  driver.switchTo().defaultContent();
  	  driver.findElement(By.id("application")).sendKeys("https://alchemy.jobs.com");
  	  driver.findElement(By.id("company_name")).sendKeys(cmpny_name);
  	  driver.findElement(By.name("submit_job")).click();
  	  driver.findElement(By.id("job_preview_submit_button")).click();
  	  driver.findElement(By.xpath("//a[text()='click here']")).click();
  	  
  	 

    }

    @Then("^Search for the job \"(^\")\"$")
    public void searchJob(String title) throws Throwable {
    	driver.findElement(By.xpath("//a[@href = 'https://alchemy.hguy.co/jobs/jobs/']")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href = 'https://alchemy.hguy.co/jobs/jobs/']")));
        driver.findElement(By.id("search_keywords")).sendKeys(title);
    	driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
    	String path = "//h3[text()='"+title+"'";
        Assert.assertEquals(driver.findElement(By.xpath(path)).getText().toString(), title);
    }
   
   @And("^Close all the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }
}

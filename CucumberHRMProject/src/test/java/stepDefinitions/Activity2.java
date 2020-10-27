package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class Activity2 {
	WebDriver driver;
    WebDriverWait wait;
    
	/*@Given("^Open the OrangeHRM page$")
		public void userOnHomepage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
                
        //Open the browser
        driver.get("http://alchemy.hguy.co:8080/orangehrm");
        driver.manage().window().maximize();
	}*/
  	
	/*@When("^Login with credentials provided$")
		public void loginPage() {
		driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
	}*/
	
	@Then("^Navigate to the Recruitment page$")
		public void navigateRecrtPage() {
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_recruitment_viewCandidates")));
		driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
	}
		
	@And("^click on the Add button to add candidate information$")
		public void addBtn() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnAdd")));
		driver.findElement(By.id("btnAdd")).click();
	}
		
	@Then("^On the next page, fill in the details of the candidate$")
		public void fillDetails() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("addCandidate_firstName")));
		driver.findElement(By.id("addCandidate_firstName")).sendKeys("Joey");
		driver.findElement(By.id("addCandidate_lastName")).sendKeys("Chandler");
		driver.findElement(By.id("addCandidate_email")).sendKeys("xyz.abc@mail.com");
		Select dropDown = new Select(driver.findElement(By.id("addCandidate_vacancy")));
    	dropDown.deselectByVisibleText("Engineer25");
		driver.findElement(By.id("addCandidate_resume")).sendKeys("C:\\vineeta\\Alchemy - SDET training\\Resume.docx");
		driver.findElement(By.id("btnSave")).click();
	}
		
		@Then("^Navigate back to the Recruitments page to confirm candidate entry$")
			public void confirmCandidateEntry() {
			Select dropDown = new Select(driver.findElement(By.id("candidateSearch_jobVacancy")));
	    	dropDown.deselectByVisibleText("Engineer25");
	    	driver.findElement(By.id("candidateSearch_candidateName")).sendKeys("Joey Chandler");
			driver.findElement(By.id("btnSrch")).click();
			Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Engineer25']")).getText().toString(), "Engineer25");
		}
		
		@And("^Close the browser$")
	    public void closeTheBrowser() throws Throwable {
	        driver.close();
	    }
}

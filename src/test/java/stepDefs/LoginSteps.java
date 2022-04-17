package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = BaseClass.driver;
	
	@Given("I have open the Swag Labs Application")
	public void i_have_open_the_Swag_Labs_Application() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	   driver.get("https://www.saucedemo.com"); 
		Thread.sleep(5000); 
	}
	
	@When("I enters username {string}")
	public void i_enters_username(String UserNameVal) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.name("user-name"));
		UserName.sendKeys(UserNameVal);
	}

	@When("I enters password {string}")
	public void i_enters_password(String PasswordVal) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(PasswordVal);

	}

	@When("I click on login button")
	public void i_click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement LoginBtn = driver.findElement(By.name("login-button"));
		LoginBtn.click();
	}

	@Then("I Should be landed on the Products Page")
	public void i_Should_be_landed_on_the_Products_Page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside the product page");
	}

	@Then("I Should be Getting the {string}")
	public void i_Should_be_Getting_the(String ExpMsg) {
	    // Write code here that turns the phrase above into concrete actions
	   
	 WebElement ErrorMsg = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface')]")); 
    String ActualMsg = ErrorMsg.getText();
    
    Assert.assertEquals(ExpMsg, ActualMsg);
    
}


	
	
}
	
	
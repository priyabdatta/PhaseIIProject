package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ProductsSteps {
	WebDriver driver = BaseClass.driver;
	
	@Given("User is on SauceDemo login page")
	public void user_is_on_SauceDemo_login_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		  driver.get("https://www.saucedemo.com"); 
			Thread.sleep(5000); 
	}

	@When("User enters Username {string} and Password {string}")
	public void user_enters_Username_and_Password(String standard_user, String secret_sauce) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.name("user-name"));
		UserName.sendKeys(standard_user);
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(secret_sauce);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_Login_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement LoginBtn = driver.findElement(By.name("login-button"));
		LoginBtn.click();
	}
	
	@When("User is on Products Page")
	public void user_is_on_Products_Page() {
	    // Write code here that turns the phrase above into concrete actions  
		String ExpTitle="PRODUCTS";
    	WebElement product=driver.findElement(By.xpath("//span[@class='title']"));
    	String actual=product.getText();
    	Assert.assertEquals(ExpTitle, actual);
    	System.out.println("User is on Products Page");  
		
	} 
	

	@Then("user compare the following products prices")
	public void user_compare_the_following_products_prices(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
		int rows = dataTable.height();
		for(int i=0;i<rows;i++) {
			
			String product= dataTable.cell(i, 0);
			String price= dataTable.cell(i, 1);
			String actualprice=driver.findElement(By.xpath("//div[text()='"+product+"']/following::div[@class='inventory_item_price'][1]")).getText();
			Assert.assertEquals(price, actualprice);
		}
	    
	}

}

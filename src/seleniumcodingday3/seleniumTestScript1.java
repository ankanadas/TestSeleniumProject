package seleniumcodingday3;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class seleniumTestScript1 {
	@Test
	public void webDriverCommands(){
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir")+File.separator+"geckodriver.exe");
		WebDriver wd= new FirefoxDriver();
		wd.get("http://automationpractice.com/index.php");
		
		System.out.println(wd.getCurrentUrl());
		System.out.println(wd.getTitle());
		wd.manage().window().maximize();
		
		WebElement signInLink=wd.findElement(By.xpath("//a[contains(text(),'Sign in')]"));//will identify signInLink
		signInLink.click();//Click the signInLink
		wd.findElement(By.xpath("//input[@id='email']")).sendKeys("practice@example.com");
		WebElement password=wd.findElement(By.id("passwd"));
		password.sendKeys("12345");
		wd.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		
		wd.quit();
	}
	@Test
	public void webDriverCommands2(){
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir")+File.separator+"geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	
	driver.get("http://automationpractice.com/index.php");
	WebElement signInLink=driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));//will identify signInLink
	signInLink.click();//Click the signInLink
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("practice@example.com");
	WebElement password=driver.findElement(By.id("passwd"));
	password.sendKeys("12345");
	driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
//	driver.findElement(By.xpath("//img[@alt='My Store']")).click();
	WebDriverWait wait= new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='center_column']")));
	driver.findElement(By.xpath("//a[@class='account']")).click();

//	Actions action = new Actions(driver);
//	WebElement productImage=driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']"));
//	action.moveToElement(productImage).build().perform();
	
	//driver.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']/following::a[@title='Add to cart'][1]"));
	/*Assertion->validation */
	String accountPage=	driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
	Assert.assertEquals(accountPage,"MY ACCOUNT","FAIL-Not displayed");
	driver.findElement(By.xpath("//a[@title='Orders']")).click();
	driver.findElement(By.xpath("//a[@class='color-myaccount']")).click();
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='row']")));
	String accountPage2=driver.findElement(By.xpath("//div[@class='row']/div/h1")).getText();
	Assert.assertEquals(accountPage2, "ORDER HISTORY","TEST FAIL TO IDENTIFY");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='center_column']")));
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("window.scrollBy(0,300)", "");
	driver.findElement(By.xpath("//a[@class='button btn btn-default button-medium pull-right']")).click();
	executor.executeScript("window.scrollBy(0,900)", "");
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='columns']")));
	driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='columns']")));
	executor.executeScript("window.scrollBy(0,900)", "");
	driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
	driver.findElement(By.xpath("//div[@id='uniform-cgv']")).click();
	executor.executeScript("window.scrollBy(0,300)", "");
	driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
	executor.executeScript("window.scrollBy(0,500)", "");
	driver.findElement(By.xpath("//a[@class='bankwire']")).click();
	executor.executeScript("window.scrollBy(0,300)", "");
	driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();
	driver.quit();
	}
	@Test
	public void webDriverCommands3() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir")+File.separator+"geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.get("http://automationpractice.com/index.php");
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//a[@class='login']")).click();
	driver.findElement(By.xpath("//input[@name='email_create']")).sendKeys("abc000@test.com");
	driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
	WebDriverWait wait= new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='noSlide']/h1")));
	Thread.sleep(2000);
	String accountPage=	driver.findElement(By.xpath("//div[@id='noSlide']/h1")).getText();
	Assert.assertEquals(accountPage,"CREATE AN ACCOUNT","FAIL-Not displayed");
	driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
	driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys("Mayank");
	driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Sen");
	driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345");
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("window.scrollBy(0,400)", "");	
	WebElement dateDropDown= driver.findElement(By.xpath("//select[@name='days']"));
	Select dateDD= new Select(dateDropDown);
	dateDD.selectByIndex(5);
	WebElement monthDropDown= driver.findElement(By.xpath("//select[@name='months']"));
	Select monthDD= new Select(monthDropDown);
	monthDD.selectByValue("7");
	WebElement yearDropDown= driver.findElement(By.xpath("//select[@id='years']"));
	Select yearDD= new Select(yearDropDown);
	yearDD.selectByValue("1988");
	executor.executeScript("window.scrollBy(0,600)", "");
	driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("1 First Street");
	driver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York City");
	WebElement stateDropDown= driver.findElement(By.xpath("//select[@id='id_state']"));
	Select stateDD= new Select(stateDropDown);
	stateDD.selectByValue("32");
	executor.executeScript("window.scrollBy(0,400)", "");
	driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("11111");
	WebElement countryDropDown= driver.findElement(By.xpath("//select[@id='id_country']"));
	Select countryDD= new Select(countryDropDown);
	countryDD.selectByValue("21");
	executor.executeScript("window.scrollBy(0,400)", "");
	driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("1234567890");
	driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("1234567890");
	driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
	driver.quit();
	}
	
}


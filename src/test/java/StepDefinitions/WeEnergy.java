package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeEnergy {

    WebDriver driver;

    @Given("The User launches the WeEnergy website")
    public void the_User_launches_the_WeEnergy_website() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver","C:\\Users\\idasc\\Desktop\\Drivers\\V80/chromedriver.exe");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.we-energies.com/myaccount/login/");
        //throw new io.cucumber.java.PendingException();
    }

    @When("Entering  \"([^\"]*)\" and \"(.*)\"")
    public void entering_username_and_password(String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"next\"]")).click();
         // throw new io.cucumber.java.PendingException();
    }

    @Then("User is able to successfully login")
    public void user_is_able_to_successfully_login() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"welcome-user\"]")));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"welcome-user\"]"));
        String user = element.getText();
        Assert.assertEquals("Welcome David Livingston",user);

       // throw new io.cucumber.java.PendingException();
    }

    @Then("Close the browser")
    public void close_the_browser() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
       // throw new io.cucumber.java.PendingException();
    }


}

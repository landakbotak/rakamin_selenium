package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Halaman login sauce demo")
    public void halaman_login_sauce_demo(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.xpath("//*[@id='login_credentials']/h4")).getText();
        Assert.assertEquals(loginPageAssert,"Accepted usernames are:");
    }

    @When("Input username")
    public void input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login button")
    public void click_login_button(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User in on dashboard page")
    public void user_in_on_dashboard_page(){
        String products =  driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(products, "Products");
    }

    @And("Input invalid password")
    public void input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("random123");
    }

    @Then("User get error message")
    public void user_get_error_message(){
        String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }

    @When("I input (.*) as username$")
    public void i_input_standard_user_as_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("I input (.*) as password$")
    public void i_input_secret_sauce_as_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("I verify (.*) login result$")
    public void i_verify_success_login_result(String status) {
        if(status.equals("success")){
            driver.findElement(By.xpath("//*[@id='login_credentials']/h4")).getText();
            String loginPageAssert = driver.findElement(By.xpath("//*[@id='login_credentials']/h4")).getText();
            Assert.assertEquals(loginPageAssert,"Accepted usernames are:");
        } else {
            String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
            Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");

        }
    }

    @And("user click the Add To Cart button")
    public void userClickTheAddToCartButton() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @And("user click checkout logo")
    public void userClickCheckoutLogo() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
    }

    @And("user click continue shopping button")
    public void userClickContinueShoppingButton() {
        driver.findElement(By.xpath("//*[@id='continue-shopping']")).click();
    }

    @And("user click another product")
    public void userClickAnotherProduct() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']")).click();
    }
    @And ("user click product two")
    public void userClickProductTwo() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
    }
    @And ("user click product three")
    public void userClickProductThree() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
    }

    @And ("user click product four")
    public void userClickProductFour() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-onesie']")).click();
    }
    @And ("user click product five")
    public void userClickProductFive() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();
    }

    @Then("user in on checkout page")
    public void userInOnCheckoutPage() {
        String text =  driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(text, "Your Cart");
    }

    @And("user click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    @Then("user in on checkout info page")
    public void userInOnCheckoutInfoPage() {
        String text =  driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(text, "Checkout: Your Information");
    }

    @And("input first name")
    public void inputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Buyer");
    }

    @And("input last name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Rakamin");
    }

    @And("input zip code")
    public void inputZipCode() {
        driver.findElement(By.id("postal-code")).sendKeys("11740");
    }

    @And("user click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    @Then("user in on overview page")
    public void userInOnOverviewPage() {
        String text =  driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(text, "Checkout: Overview");
    }

    @And ("user click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.xpath("//*[@id='finish']")).click();
    }

    @Then ("user in on complete page")
    public void userInOnCompletePage() {
        String text =  driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(text, "Checkout: Complete!");
    }

    @And ("user click tree button")
    public void userClickTreeButton (){
        driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
    }
    @And ("user click logout")
    public void userClickLogout() {
        driver.findElement(By.xpath("//*[@id='logout_sidebar_link']")).click();
    }
    @Then ("user in login page")
    public void userInLoginPage(){
        String text =  driver.findElement(By.xpath("//*[@id='login_credentials']/h4")).getText();
        Assert.assertEquals(text, "Accepted usernames are:");
    }

}

package example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login {

    public static void main(String[] args){

    }

    @Test
    public void success_login_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        // membuka halaman login
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //*[@id="login_credentials"]/h4
        String loginPageAssert = driver.findElement(By.xpath("//*[@id='login_credentials']/h4")).getText();
        Assert.assertEquals(loginPageAssert,"Accepted usernames are:");

        //input username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //quit page
//        driver.close();
    }

    @Test
    public void failed_login_case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        // membuka halaman login
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //input username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("failed_pass");
        //click login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //*[@id="login_button_container"]/div/form/div[3]/h3
        String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
    }
}

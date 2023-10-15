package example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginFirstTry {
    @Test
    public static void main(String[] args){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        //Get Form Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//        WebElement userName = driver.findElement(By.id("user-name"));
//        WebElement password = driver.findElement(By.id("password"));
//        WebElement btn = driver.findElement(By.className("login-button"));
//
//        userName.click();
//        userName.sendKeys("standard_user");
//        userName.getText();
//
//        password.click();
//        password.sendKeys("secret_sauce");
//        password.getText();
//        driver.findElement(By.xpath("/*contains")).isDisplayed();
//        driver.findElement(By.cssSelector("button")).isDisplayed();

//        driver.close();
    }
}

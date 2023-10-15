package example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginDDT {
    @Test
    public void loginDDT(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        String csvDir = System.getProperty("user.dir")+"/src/test/data/test-data.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvDir))){
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null){
                String username = nextLine[0];
                String password = nextLine[1];
                String status = nextLine[2];


                driver = new ChromeDriver(opt);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.get(baseUrl);

                driver.findElement(By.id("user-name")).sendKeys(username);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.xpath("//input[@type='submit']")).click();

                // utk didalam if
//                WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for a maximum of 10 seconds
//                WebElement loginCredentialsElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='login_credentials']/h4")));
//                String loginPageAssert = loginCredentialsElement.getText();
//                Assert.assertEquals(loginPageAssert, "Accepted usernames are:");

                if(status.equals("success")){
                    driver.findElement(By.xpath("//*[@id='login_credentials']/h4")).getText();
                    String loginPageAssert = driver.findElement(By.xpath("//*[@id='login_credentials']/h4")).getText();
                    Assert.assertEquals(loginPageAssert,"Accepted usernames are:");
                } else {
                    String errorLogin = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).getText();
                    Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");

                }

            }
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

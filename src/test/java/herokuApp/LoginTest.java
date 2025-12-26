package herokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    void successfullyWithValidCredentials(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.className("radius")).click();
//
//        driver.findElement(By.name("username")).sendKeys("tomsmith");
//
//        driver.findElement(By.cssSelector("input")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("[type=text]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[id=username]")).sendKeys("tomsmith"); //driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("tomsmith");
//
//        driver.findElement(By.xpath("//ipnut")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));
        driver.quit();
    }

    // không được viết test case kiểm tra 2 trường hợp lỗi trong 1 test case
//    @Test
//    void invalidLogin() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/login");
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
//        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
//        driver.findElement(By.cssSelector("button[type='submit']")).click();
//        if (driver.findElement(By.className("error")).getText().contains("Your username is invalid!")){
//            Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));
//        }else {
//            Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));
//        }
//        Thread.sleep(3000);
//        driver.quit();
//    }

    @Test void failedToLoginWithInvalidUsername() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("InvalidUsername");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));
    }
    @Test void failedToLoginWithInvalidPassword()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("InvalidPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));
    }
}

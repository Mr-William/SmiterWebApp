package testpackage.webapptests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageNavTest {

    public static WebDriver driver = null;
    
    @BeforeTest
    public void startTest() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(2576, 1416));
    }

    @AfterTest
    public void endTest(){
        driver.close();
    }

    @Test
    public void navigatePages(){
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("bookbutton")).click();
        driver.findElement(By.id("moviebutton")).click();
        driver.findElement(By.id("gamesbutton")).click();
        driver.findElement(By.id("musicbutton")).click();
        driver.findElement(By.id("homebutton")).click();
        driver.findElement(By.linkText("MOVIES")).click();
        driver.findElement(By.id("homebutton")).click();
        driver.findElement(By.linkText("MUSIC")).click();
        driver.findElement(By.id("homebutton")).click();
        driver.findElement(By.linkText("BOOKS")).click();
        driver.findElement(By.id("homebutton")).click();
        driver.findElement(By.linkText("GAMES")).click();
        driver.findElement(By.id("homebutton")).click();
        driver.close();
    }
}

package testpackage.webapptests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovieTests {

    public static WebDriver driver = null;
    
    @BeforeTest
    public void startTest() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1198, 890));
    }

    @AfterTest
    public void endTest(){
        driver.close();
    }
    
    @Test(priority = 1)
    public void addMovie() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("moviebutton")).click();
        driver.findElement(By.id("addMovieBtn")).click();
        driver.findElement(By.id("submitNewMovieBtn")).click();
        driver.findElement(By.id("movieTitle")).click();
        driver.findElement(By.id("movieTitle")).sendKeys("Liar Liar");
        driver.findElement(By.id("movieGenre")).click();
        driver.findElement(By.id("movieGenre")).sendKeys("Comedy");
        driver.findElement(By.id("submitNewMovieBtn")).click();
    }
    
    @Test(priority = 2)
    public void editMovie() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("moviebutton")).click();
        driver.findElement(By.id("editMovieBtn")).click();
        driver.findElement(By.id("movieDirector")).click();
        driver.findElement(By.id("movieDirector")).sendKeys(" ");
        driver.findElement(By.id("updateMovieBtn")).click();
    }
    
    @Test(priority = 3)
    public void deleteMovie() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("moviebutton")).click();
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td > #editMovieBtn")).click();
        driver.findElement(By.id("deleteMovieBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this movie?"));
        driver.switchTo().alert().dismiss();
        driver.findElement(By.cssSelector(".overlay")).click();
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td > #editMovieBtn")).click();
        driver.findElement(By.id("deleteMovieBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this movie?"));
        driver.switchTo().alert().accept();
    }
}

package testpackage.webapptests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GameTests {

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
    public void addGame() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("gamesbutton")).click();
        driver.findElement(By.id("addGameBtn")).click();
        driver.findElement(By.id("game_datecompleted")).click();
        driver.findElement(By.id("game_datecompleted")).sendKeys("2023-01-04");
        driver.findElement(By.id("submitGameForm")).click();
        driver.findElement(By.id("gameTitle")).click();
        driver.findElement(By.id("gameTitle")).sendKeys("Elden Ring");
        new Actions(driver).moveToElement(driver.findElement(By.id("submitGameForm"))).pause(Duration.ofSeconds(2)).click().perform();
        //driver.findElement(By.id("submitGameForm")).click();
    }
    
    @Test(priority = 2)
    public void editGame() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("gamesbutton")).click();
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td > #editGameBtn")).click();
        driver.findElement(By.id("gameGenre")).click();
        driver.findElement(By.id("gameGenre")).sendKeys("Action Rpg");
        driver.findElement(By.id("updateBtn")).click();
    }
    
    @Test(priority = 3)
    public void deleteGame() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("gamesbutton")).click();
        driver.findElement(By.id("editGameBtn")).click();
        driver.findElement(By.id("deleteBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this game?"));
        driver.switchTo().alert().dismiss();
        driver.findElement(By.cssSelector(".overlay")).click();
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td > #editGameBtn")).click();
        driver.findElement(By.id("deleteBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this game?"));
        driver.switchTo().alert().accept();
    }
    
}

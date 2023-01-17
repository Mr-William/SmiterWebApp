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

public class MusicTests {

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
    public void addMusic() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("musicbutton")).click();
        driver.findElement(By.id("addMusicBtn")).click();
        driver.findElement(By.id("songArtist")).click();
        driver.findElement(By.id("songArtist")).sendKeys("Five Finger Death Punch");
        driver.findElement(By.id("submitNewMusicBtn")).click();
        driver.findElement(By.id("songTitle")).click();
        driver.findElement(By.id("songTitle")).sendKeys("Brighter Side of Grey");
        driver.findElement(By.id("submitNewMusicBtn")).click();
    }
    
    @Test(priority = 2)
    public void editMusic() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("musicbutton")).click();
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td > #editMusicBtn")).click();
        driver.findElement(By.id("songTitle")).click();
        driver.findElement(By.id("songTitle")).sendKeys("A Little Bit Off");
        driver.findElement(By.id("albumTitle")).click();
        driver.findElement(By.id("albumTitle")).sendKeys("F8");
        driver.findElement(By.id("updateMusicBtn")).click();
    }
    
    @Test(priority = 3)
    public void deleteMusic() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("musicbutton")).click();
        driver.findElement(By.cssSelector(".ng-scope:nth-child(2) > td > #editMusicBtn")).click();
        driver.findElement(By.id("deleteMusicBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this music?"));
        driver.switchTo().alert().dismiss();
        driver.findElement(By.cssSelector(".overlay")).click();
        driver.findElement(By.id("editMusicBtn")).click();
        driver.findElement(By.id("deleteMusicBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this music?"));
        driver.switchTo().alert().accept();
    }
}

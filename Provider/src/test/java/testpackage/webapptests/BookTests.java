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

public class BookTests {

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
    public void addBook() {
      driver.get("http://localhost:8081/");
      driver.findElement(By.id("bookbutton")).click();
      driver.findElement(By.id("addBookBtn")).click();
      driver.findElement(By.id("bookAuthor")).click();
      driver.findElement(By.id("bookAuthor")).sendKeys("Miguel de Cervantes");
      driver.findElement(By.id("book_datecompleted")).click();
      driver.findElement(By.id("book_datecompleted")).sendKeys("2023-01-01");
      driver.findElement(By.id("bookAddBtn")).click();
      driver.findElement(By.id("bookTitle")).click();
      driver.findElement(By.id("bookTitle")).sendKeys("Don Quixote");
      driver.findElement(By.id("bookAddBtn")).click();
    }
    
    @Test(priority = 2)
    public void editBook(){
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("bookbutton")).click();
        driver.findElement(By.id("editBookBtn")).click();
        driver.findElement(By.id("bookTitle")).click();
        driver.findElement(By.id("bookTitle")).sendKeys("Anna Karenina");
        driver.findElement(By.id("submitUpdateBtn")).click();
    }
    
    @Test(priority = 3)
    public void deleteBook() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("bookbutton")).click();
        driver.findElement(By.id("editBookBtn")).click();
        driver.findElement(By.id("deleteBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this book?"));
        driver.switchTo().alert().dismiss();
        driver.findElement(By.cssSelector(".overlay")).click();
        driver.findElement(By.id("editBookBtn")).click();
        driver.findElement(By.id("deleteBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this book?"));
        driver.switchTo().alert().accept();
    }
}

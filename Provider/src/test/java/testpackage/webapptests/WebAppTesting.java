package testpackage.webapptests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.util.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class WebAppTesting {

    public static WebDriver driver = null;
    
    @BeforeClass
    public void startTest() throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(2576, 1416));
    }

    @AfterClass
    public void endTest(){
        driver.close();
    }

    //Page Navigation
    @Test(priority = -1)
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
    }

    
    /************************************************************************************/
    //Book Page Testing

    //Adding book
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
      
      assertTrue(driver.findElement(By.id("bookTitle")).getText() != null);
      assertTrue(driver.findElement(By.id("bookAuthor")).getText() != null);
      
      driver.findElement(By.id("bookAddBtn")).click();
    }

    //Editing book
    @Test(priority = 2)
    public void editBook(){
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("bookbutton")).click();
        driver.findElement(By.id("editBookBtn")).click();
        driver.findElement(By.id("bookTitle")).clear();
        driver.findElement(By.id("bookTitle")).click();
        driver.findElement(By.id("bookTitle")).sendKeys("");
        
        assertTrue(driver.findElement(By.id("bookTitle")).getText() != null);
        assertTrue(driver.findElement(By.id("bookAuthor")).getText() != null);
        
        driver.findElement(By.id("submitUpdateBtn")).click();
    }

    //Deleting book
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
    
    /************************************************************************************/
    //Game Page Testing

    //Adding Game
    @Test(priority = 4)
    public void addGame() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("gamesbutton")).click();
        driver.findElement(By.id("addGameBtn")).click();
        driver.findElement(By.id("game_datecompleted")).click();
        driver.findElement(By.id("game_datecompleted")).sendKeys("2023-01-04");
        
        //Submitting with empty Title
        driver.findElement(By.id("submitGameForm")).click();
        
        driver.findElement(By.id("gameTitle")).click();
        driver.findElement(By.id("gameTitle")).sendKeys("Elden Ring");

        assertFalse(driver.findElement(By.id("gameTitle")).getAttribute("value").isBlank());
        
        driver.findElement(By.id("submitGameForm")).click();
        
    }

    //Editing Game
    @Test(priority = 5)
    public void editGame() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("gamesbutton")).click();
        driver.findElement(By.id("editGameBtn")).click();
        driver.findElement(By.id("gameGenre")).clear();
        driver.findElement(By.id("gameGenre")).click();
        driver.findElement(By.id("gameGenre")).sendKeys("Action Rpg");
        
        driver.findElement(By.id("updateBtn")).click();
    }

    //Deleting Game
    @Test(priority = 6)
    public void deleteGame() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("gamesbutton")).click();
        driver.findElement(By.id("editGameBtn")).click();
        driver.findElement(By.id("deleteBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this game?"));
        driver.switchTo().alert().dismiss();
        driver.findElement(By.cssSelector(".overlay")).click();
        driver.findElement(By.id("editGameBtn")).click();
        driver.findElement(By.id("deleteBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this game?"));
        driver.switchTo().alert().accept();
    }

    /************************************************************************************/
    //Movie Page Testing

    //Adding Movie
    @Test(priority = 7)
    public void addMovie() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("moviebutton")).click();
        driver.findElement(By.id("addMovieBtn")).click();

        //Submitting with empty title
        driver.findElement(By.id("submitNewMovieBtn")).click();
        driver.findElement(By.id("movieTitle")).click();
        driver.findElement(By.id("movieTitle")).sendKeys("Liar Liar");
        driver.findElement(By.id("movieGenre")).click();
        driver.findElement(By.id("movieGenre")).sendKeys("Comedy");
        
        assertFalse(driver.findElement(By.id("movieTitle")).getAttribute("value").isBlank());
        
        driver.findElement(By.id("submitNewMovieBtn")).click();
    }

    //Editing Movie
    @Test(priority = 8)
    public void editMovie() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("moviebutton")).click();
        driver.findElement(By.id("editMovieBtn")).click();
        driver.findElement(By.id("movieDirector")).click();
        driver.findElement(By.id("movieDirector")).clear();
        
        assertFalse(driver.findElement(By.id("movieTitle")).getAttribute("value").isBlank());
        
        driver.findElement(By.id("updateMovieBtn")).click();
    }

    //Deleting Movie
    @Test(priority = 9)
    public void deleteMovie() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("moviebutton")).click();
        driver.findElement(By.id("editMovieBtn")).click();
        driver.findElement(By.id("deleteMovieBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this movie?"));
        driver.switchTo().alert().dismiss();
        driver.findElement(By.cssSelector(".overlay")).click();
        driver.findElement(By.id("editMovieBtn")).click();
        driver.findElement(By.id("deleteMovieBtn")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this movie?"));
        driver.switchTo().alert().accept();
    }

    /************************************************************************************/
    //Music Page Testing

    //Adding Music
    @Test(priority = 10)
    public void addMusic() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("musicbutton")).click();
        driver.findElement(By.id("addMusicBtn")).click();
        driver.findElement(By.id("songArtist")).click();
        driver.findElement(By.id("songArtist")).sendKeys("Five Finger Death Punch");

        //Submitting with empty title
        driver.findElement(By.id("submitNewMusicBtn")).click();
        driver.findElement(By.id("songTitle")).click();
        driver.findElement(By.id("songTitle")).sendKeys("Brighter Side of Grey");
        
        assertFalse(driver.findElement(By.id("songTitle")).getAttribute("value").isBlank());
        assertFalse(driver.findElement(By.id("songArtist")).getAttribute("value").isBlank());
        
        driver.findElement(By.id("submitNewMusicBtn")).click();
    }

    //Editing Music
    @Test(priority = 11)
    public void editMusic() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("musicbutton")).click();
        driver.findElement(By.id("editMusicBtn")).click();
        driver.findElement(By.id("songTitle")).clear();
        driver.findElement(By.id("songTitle")).click();
        driver.findElement(By.id("songTitle")).sendKeys("A Little Bit Off");
        driver.findElement(By.id("albumTitle")).click();
        driver.findElement(By.id("albumTitle")).sendKeys("F8");
                
        driver.findElement(By.id("updateMusicBtn")).click();
    }

    //Deleting Music
    @Test(priority = 12)
    public void deleteMusic() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("musicbutton")).click();
        driver.findElement(By.id("editMusicBtn")).click();
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
package testpackage.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.smiter.Provider.models.Game;
import com.smiter.Provider.repositories.GameRepo;
import com.smiter.Provider.services.impl.GameServiceImpl;

@Test
public class GameServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    GameRepo mockRepo;

    @InjectMocks
    GameServiceImpl gameService;

    private Game game1 = new Game();
    private Game game2 = new Game();
    private Game game3 = new Game();

    @BeforeMethod
    public void init(){

        MockitoAnnotations.openMocks(this);

        game1.setTitle("Elden Ring");
        game1.setGenre("Action RPG");
        game1.setId((long) 1);
        game1.setDatecompleted(LocalDate.of(2022, 10, 14));

        game2.setTitle("Far Cry 6");
        game2.setGenre("FPS");
        game2.setId((long) 2);
        game2.setDatecompleted(LocalDate.of(2021, 8, 22));

        game3.setTitle("Hell Let Loose");
        game3.setGenre("FPS");
        game3.setId((long) 3);
        game3.setDatecompleted(LocalDate.of(2022, 10, 14));
    }

    @Test
    public void whenGamesIsCalled_ShowAllGames(){
        
        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);
        games.add(game3);
        when(mockRepo.findAll()).thenReturn(games);

        List<Game> mockedGames = gameService.getAllGames();

        assertEquals(mockedGames, games);
        
        verify(mockRepo, times(1)).findAll();
    }

    @Test
    public void whenNoGamesExist_NoGamesShown(){

        List<Game> testList = new ArrayList<>();

        when(mockRepo.findAll()).thenReturn(testList);
        
        List<Game> games = gameService.getAllGames();

        assertEquals(games, testList);
        
        verify(mockRepo, atMost(3)).findAll();
    }

    @Test
    public void whenValidIdGiven_returnGame(){
        
        Game tmp = new Game();
        tmp.setDatecompleted(game1.getDatecompleted());
        tmp.setGenre(game1.getGenre());
        tmp.setTitle(game1.getTitle());
        tmp.setId(game1.getId());

        when(mockRepo.getById(1L)).thenReturn(tmp);
        assertEquals(gameService.getById((long) 1), tmp);
        verify(mockRepo).getById(1L);
    }

    @Test
    public void invalidId_returnsNull(){
        
        when(mockRepo.getById((long) 4)).thenThrow(new NullPointerException());
        assertThrows(NullPointerException.class, () -> gameService.getById((long) 4));
    }

    @Test
    public void whenGameAdded_returnGame(){
        when(mockRepo.save(Mockito.any())).thenReturn(game2);
        Game saved = gameService.addGame(game2);
        assertEquals(saved, game2);
        verify(mockRepo).save(game2);
    }

    @Test
    public void whenEmptyTitle_GameNotSaved(){
        Game tmp = new Game();
        tmp.setId((long) 4);
        tmp.setDatecompleted(game1.getDatecompleted());

        when(mockRepo.save(Mockito.any())).thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> gameService.addGame(tmp));
    }

    @Test
    public void whenGameUpdated_returnGame(){
        Game tmp = new Game();
        tmp.setTitle("MW2");
        tmp.setId(game2.getId());
        tmp.setGenre(game2.getGenre());
        tmp.setDatecompleted(game2.getDatecompleted());

        when(mockRepo.save(Mockito.any())).thenReturn(game2, tmp);
        when(mockRepo.getOne(Mockito.anyLong())).thenReturn(game2);

        Game saved = gameService.addGame(tmp);
        Game updated = gameService.updateGame(saved.getId(), tmp);

        assertNotNull(updated);
        assertEquals(updated.getTitle(), tmp.getTitle());
    }

    @Test
    public void updatingEmptyTitle_ReturnsNull(){
        
        Game updated = new Game();
        updated.setId(game1.getId());
        updated.setDatecompleted(game1.getDatecompleted());
        updated.setGenre(game1.getGenre());
        updated.setTitle("");

        when(mockRepo.save(Mockito.any())).thenThrow(new NullPointerException());
        when(mockRepo.getOne(Mockito.anyLong())).thenReturn(game1);

        Game saved = new Game();
        saved.setTitle(updated.getTitle());
        
        assertThrows(NullPointerException.class, () -> gameService.updateGame(game1.getId(), saved));
    }

    @Test
    public void whenGivenValidId_DeleteGame(){

        gameService.addGame(game1);

        List<Game> games = gameService.getAllGames();

        when(mockRepo.getOne(game1.getId())).thenReturn(game1);

        gameService.deleteGame(game1.getId());

        assertTrue(games.isEmpty());

        verify(mockRepo).deleteById(game1.getId());
    }
}

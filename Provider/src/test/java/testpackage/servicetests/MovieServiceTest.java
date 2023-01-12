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

import com.smiter.Provider.models.Movie;
import com.smiter.Provider.repositories.MovieRepo;
import com.smiter.Provider.services.impl.MovieServiceImpl;

@Test
public class MovieServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    MovieRepo mockRepo;

    @InjectMocks
    MovieServiceImpl movieService;

    private Movie movie1 = new Movie();
    private Movie movie2 = new Movie();

    @BeforeMethod
    public void init(){

        MockitoAnnotations.openMocks(this);

        movie1.setId((long) 1);
        movie1.setTitle("Liar Liar");
        movie1.setGenre("Comedy");

        movie2.setId((long)2);
        movie2.setTitle("Shawshank Redemption");
        movie2.setGenre("Drama");
    }

    @Test
    public void whenMoviesIsCalled_ShowAllMovies(){
        
        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        when(mockRepo.findAll()).thenReturn(movies);

        List<Movie> mockedMovies = movieService.getAllMovies();

        assertEquals(mockedMovies, movies);
        
        verify(mockRepo, times(1)).findAll();
    }

    @Test
    public void whenNoMoviesExist_NoMoviesShown(){

        List<Movie> testList = new ArrayList<>();

        when(mockRepo.findAll()).thenReturn(testList);
        
        List<Movie> movies = movieService.getAllMovies();

        assertEquals(movies, testList);
        
        verify(mockRepo, atMost(3)).findAll();
    }

    @Test
    public void whenValidIdGiven_returnMovie(){

        when(mockRepo.getById(1L)).thenReturn(movie1);
        assertEquals(movieService.getById((long) 1), movie1);
        verify(mockRepo).getById(1L);
    }

    @Test
    public void invalidId_returnsNull(){
        
        when(mockRepo.getById((long) 4)).thenThrow(new NullPointerException());
        assertThrows(NullPointerException.class, () -> movieService.getById((long) 4));
    }

    @Test
    public void whenMovieAdded_returnMovie(){

        when(mockRepo.save(Mockito.any())).thenReturn(movie2);
        Movie saved = movieService.addMovie(movie2);
        assertEquals(saved, movie2);
        verify(mockRepo).save(movie2);
    }

    @Test
    public void whenEmptyTitle_MovieNotSaved(){

        movie2.setTitle("");
        when(mockRepo.save(Mockito.any())).thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> movieService.addMovie(movie2));
    }

    @Test
    public void whenMovieUpdated_returnMovie(){
        Movie tmp = movie2;
        tmp.setTitle(movie1.getTitle());
        when(mockRepo.save(Mockito.any())).thenReturn(movie2, tmp);
        when(mockRepo.getOne(Mockito.anyLong())).thenReturn(movie2);

        Movie saved = movieService.addMovie(tmp);
        Movie updated = movieService.updateMovie(saved.getId(), tmp);

        assertNotNull(updated);
        assertEquals(updated.getTitle(), tmp.getTitle());
    }

    @Test
    public void updatingEmptyTitle_ReturnsNull(){
        Movie tmp = movie2;
        tmp.setTitle("");

        when(mockRepo.save(Mockito.any())).thenThrow(new NullPointerException());
        when(mockRepo.getOne(Mockito.anyLong())).thenReturn(movie1);

        Movie saved = new Movie();
        saved.setTitle(tmp.getTitle());
        
        assertThrows(NullPointerException.class, () -> movieService.updateMovie(movie1.getId(), saved));
    }

    @Test
    public void whenGivenValidId_DeleteMovie(){

        movieService.addMovie(movie1);

        List<Movie> movies = movieService.getAllMovies();

        when(mockRepo.getOne(movie1.getId())).thenReturn(movie1);

        movieService.deleteMovie(movie1.getId());

        assertTrue(movies.isEmpty());

        verify(mockRepo).deleteById(movie1.getId());
    }
}

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

import com.smiter.Provider.models.Book;
import com.smiter.Provider.repositories.BookRepo;
import com.smiter.Provider.services.impl.BookServiceImpl;

@Test
public class BookServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    BookRepo mockRepo;

    @InjectMocks
    BookServiceImpl bookService;

    private Book book1 = new Book();
    private Book book2 = new Book();
    private Book book3 = new Book();

    @BeforeMethod
    public void init(){

        MockitoAnnotations.openMocks(this);

        book1.setTitle("Don Quixote");
        book1.setAuthor("Miguel de Cervantes");
        book1.setGenre("Fiction");
        book1.setId((long) 1);
        book1.setDatecompleted(LocalDate.of(2022, 10, 14));

        book2.setTitle("Of Mice and Men");
        book2.setAuthor("John Steinbeck");
        book2.setGenre("Fiction");
        book2.setId((long) 2);
        book2.setDatecompleted(LocalDate.of(2021, 8, 22));

        book3.setTitle("The Cat in the Hat");
        book3.setAuthor("Dr Seuss");
        book3.setGenre("Childrens Stories");
        book3.setId((long) 3);
        book3.setDatecompleted(LocalDate.of(2022, 10, 14));
    }

    @Test
    public void whenBooksIsCalled_ShowAllBooks(){
        
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        when(mockRepo.findAll()).thenReturn(books);

        List<Book> mockedBooks = bookService.getAllBooks();

        assertEquals(mockedBooks, books);
        
        verify(mockRepo, times(1)).findAll();
    }

    @Test
    public void whenNoBooksExist_NoBooksShown(){

        List<Book> testList = new ArrayList<>();

        when(mockRepo.findAll()).thenReturn(testList);
        
        List<Book> books = bookService.getAllBooks();

        assertEquals(books, testList);
        
        verify(mockRepo, atMost(3)).findAll();
    }

    @Test
    public void whenValidIdGiven_returnBook(){
        
        Book tmp = new Book();
        tmp.setAuthor(book1.getAuthor());
        tmp.setDatecompleted(book1.getDatecompleted());
        tmp.setGenre(book1.getGenre());
        tmp.setTitle(book1.getTitle());
        tmp.setId(book1.getId());

        when(mockRepo.getById(1L)).thenReturn(tmp);
        assertEquals(bookService.getById((long) 1), tmp);
        verify(mockRepo).getById(1L);
    }

    @Test
    public void invalidId_returnsNull(){
        
        when(mockRepo.getById((long) 4)).thenThrow(new NullPointerException());
        assertThrows(NullPointerException.class, () -> bookService.getById((long) 4));
    }

    @Test
    public void whenBookAdded_returnBook(){
        Book tmp = new Book();
        tmp.setAuthor(book2.getAuthor());
        tmp.setDatecompleted(book2.getDatecompleted());
        tmp.setGenre(book2.getGenre());
        tmp.setId(book2.getId());
        tmp.setTitle(book2.getTitle());
    }

    @Test
    public void whenEmptyTitle_BookNotSaved(){
        Book tmp = new Book();
        tmp.setId((long) 4);
        tmp.setAuthor(book1.getAuthor());
        tmp.setDatecompleted(book1.getDatecompleted());

        when(mockRepo.save(Mockito.any())).thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> bookService.addBook(tmp));
    }

    @Test
    public void whenBookUpdated_returnBook(){
        Book tmp = new Book();
        tmp.setAuthor(book2.getAuthor());
        tmp.setTitle("Tortilla Flat");
        tmp.setId(book2.getId());
        tmp.setGenre(book2.getGenre());
        tmp.setDatecompleted(book2.getDatecompleted());

        when(mockRepo.save(Mockito.any())).thenReturn(book2, tmp);
        when(mockRepo.getOne(Mockito.anyLong())).thenReturn(book2);

        Book saved = bookService.addBook(tmp);
        Book updated = bookService.updateBook(saved.getId(), tmp);

        assertNotNull(updated);
        assertEquals(updated.getTitle(), tmp.getTitle());
    }

    @Test
    public void updatingEmptyTitle_ReturnsNull(){
        
        Book updated = new Book();
        updated.setAuthor(book1.getAuthor());
        updated.setId(book1.getId());
        updated.setDatecompleted(book1.getDatecompleted());
        updated.setGenre(book1.getGenre());
        updated.setTitle("");

        when(mockRepo.save(Mockito.any())).thenThrow(new NullPointerException());
        when(mockRepo.getOne(Mockito.anyLong())).thenReturn(book1);

        Book saved = new Book();
        saved.setAuthor(updated.getAuthor());
        
        assertThrows(NullPointerException.class, () -> bookService.updateBook(book1.getId(), saved));
    }

    @Test
    public void whenGivenValidId_DeleteBook(){

        bookService.addBook(book1);

        List<Book> books = bookService.getAllBooks();

        when(mockRepo.getOne(book1.getId())).thenReturn(book1);

        bookService.deleteBook(book1.getId());

        assertTrue(books.isEmpty());

        verify(mockRepo).deleteById(book1.getId());
    }
}

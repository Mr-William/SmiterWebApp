package testpackage.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.smiter.Provider.models.Music;
import com.smiter.Provider.repositories.MusicRepo;
import com.smiter.Provider.services.impl.MusicServiceImpl;

@Test
public class MusicServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    MusicRepo mockRepo;

    @InjectMocks
    MusicServiceImpl musicService;

    private Music music1 = new Music();
    private Music music2 = new Music();

    @BeforeMethod
    public void init(){

        MockitoAnnotations.openMocks(this);

        music1.setTitle("Brighter Side of Grey");
        music1.setGenre("Metal");
        music1.setId((long) 1);
        music1.setAlbum("F8");
        music1.setArtist("Five Finger Death Punch");

        music1.setTitle("A Little Bit Off");
        music1.setGenre("Metal");
        music1.setId((long) 2);
        music1.setAlbum("F8");
        music1.setArtist("Five Finger Death Punch");
    }

    @Test
    public void whenMusicsIsCalled_ShowAllMusics(){
        
        List<Music> musics = new ArrayList<>();
        musics.add(music1);
        musics.add(music2);
        when(mockRepo.findAll()).thenReturn(musics);

        List<Music> mockedMusics = musicService.getAllMusic();

        assertEquals(mockedMusics, musics);
        
        verify(mockRepo, times(1)).findAll();
    }

    @Test
    public void whenNoMusicsExist_NoMusicsShown(){

        List<Music> testList = new ArrayList<>();

        when(mockRepo.findAll()).thenReturn(testList);
        
        List<Music> musics = musicService.getAllMusic();

        assertEquals(musics, testList);
        
        verify(mockRepo, atMost(3)).findAll();
    }

    @Test
    public void whenValidIdGiven_returnMusic(){

        when(mockRepo.getById(1L)).thenReturn(music1);
        assertEquals(musicService.getById((long) 1), music1);
        verify(mockRepo).getById(1L);
    }

    @Test
    public void invalidId_returnsNull(){
        
        when(mockRepo.getById((long) 4)).thenThrow(new NullPointerException());
        assertThrows(NullPointerException.class, () -> musicService.getById((long) 4));
    }

    @Test
    public void whenMusicAdded_returnMusic(){

        when(mockRepo.save(Mockito.any())).thenReturn(music2);
        Music saved = musicService.addMusic(music2);
        assertEquals(saved, music2);
        verify(mockRepo).save(music2);
    }

    @Test
    public void whenEmptyTitle_MusicNotSaved(){

        music2.setTitle("");
        when(mockRepo.save(Mockito.any())).thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> musicService.addMusic(music2));
    }

    @Test
    public void whenMusicUpdated_returnMusic(){
        Music tmp = music2;
        tmp.setTitle(music1.getTitle());
        when(mockRepo.save(Mockito.any())).thenReturn(music2, tmp);
        when(mockRepo.getOne(Mockito.anyLong())).thenReturn(music2);

        Music saved = musicService.addMusic(tmp);
        Music updated = musicService.updateMusic(saved.getId(), tmp);

        assertNotNull(updated);
        assertEquals(updated.getTitle(), tmp.getTitle());
    }

    @Test
    public void updatingEmptyTitle_ReturnsNull(){
        Music tmp = music2;
        tmp.setTitle("");

        when(mockRepo.save(Mockito.any())).thenThrow(new NullPointerException());
        when(mockRepo.getOne(Mockito.anyLong())).thenReturn(music1);

        Music saved = new Music();
        saved.setTitle(tmp.getTitle());
        
        assertThrows(NullPointerException.class, () -> musicService.updateMusic(music1.getId(), saved));
    }

    @Test
    public void whenGivenValidId_DeleteMusic(){

        musicService.addMusic(music1);

        List<Music> musics = musicService.getAllMusic();

        when(mockRepo.getOne(music1.getId())).thenReturn(music1);

        musicService.deleteMusic(music1.getId());

        assertTrue(musics.isEmpty());

        verify(mockRepo).deleteById(music1.getId());
    }
}

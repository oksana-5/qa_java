import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void maleLionShouldHaveMane() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void femaleShouldNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void invalidSexShouldThrowException() {
        assertThrows(Exception.class, () -> new Lion("Неизвестно"));
    }

    @Test
    public void getKittens() {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        assertEquals("Неправильное количество котят для львов", 1, actual);
    }

    @Test
    public void maleDoesHaveMane() throws Exception {
        Lion lion = new Lion("Самец");
        boolean actual = lion.doesHaveMane();
        assertTrue("Самец должен иметь гриву", actual);
    }

    @Test
    public void femaleDoesNotHaveMane() throws Exception {
        Lion lion = new Lion("Самка");
        boolean actual = lion.doesHaveMane();
        assertFalse("Самка не должна иметь гриву", actual);
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        assertEquals("Неправильный список еды для льва", List.of("Животные", "Птицы", "Рыба"), actual);
    }
}

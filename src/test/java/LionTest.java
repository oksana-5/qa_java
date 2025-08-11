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
    public void maleLionShouldHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void femaleShouldNotHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void invalidSexShouldThrowExceptionTest() {
        assertThrows(Exception.class, () -> new Lion(feline, "Неизвестно"));
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        assertEquals("Неправильное количество котят для львов", 1, actual);
    }

    @Test
    public void maleDoesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        boolean actual = lion.doesHaveMane();
        assertTrue("Самец должен иметь гриву", actual);
    }

    @Test
    public void femaleDoesNotHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        boolean actual = lion.doesHaveMane();
        assertFalse("Самка не должна иметь гриву", actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        assertEquals("Неправильный список еды для льва", List.of("Животные", "Птицы", "Рыба"), actual);
    }
}

import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    @Mock
    Feline feline;
    Cat cat;

    @Test
    public void getSound() {
        cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Кот издает неверный звук", "Мяу", actual);
    }

    @Test
    public void getFood() throws Exception {
        cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        assertEquals("Неправильный список еды для кота", List.of("Животные", "Птицы", "Рыба"), actual);
    }

}

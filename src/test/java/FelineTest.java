import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private final Feline feline = new Feline();

    @Test
    public void eatMeat() throws Exception {
        List<String> actual = feline.eatMeat();
        assertEquals("Неправильный список еды для кошачьих", List.of("Животные", "Птицы", "Рыба"), actual);
    }

    @Test
    public void getFamily() {
        String actual = feline.getFamily();
        assertEquals("Неверное семейство для кошачьих", "Кошачьи", actual);
    }

    @Test
    public void getKittens() {
        int actual = feline.getKittens();
        assertEquals("Неправильное количество котят для кошачьих", 1, actual);
    }

}

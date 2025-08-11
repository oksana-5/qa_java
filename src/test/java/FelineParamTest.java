import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class FelineParamTest {
    private final int inputKittensCount;
    private final int expectedKittensCount;
    private final Feline feline = new Feline();

    public FelineParamTest(int inputKittensCount, int expectedKittensCount) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {1, 1},
                {3, 3},
                {0, 0}
        };
    }

    @Test
    public void getKittensTest() {
        assertEquals("Неправильное количество котят для кошачьих",
                expectedKittensCount,
                feline.getKittens(inputKittensCount));
    }
}


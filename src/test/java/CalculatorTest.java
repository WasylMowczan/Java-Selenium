import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CalculatorTest {

    public static final int first_number = 2;
    public static final int second_number = 3;

    Calculator calc = new Calculator();

    private int correctResult = 5;
    private int wrongResult = 6;


    @Test
    public void testCase1(){
        int acrualResult = calc.add(first_number, second_number);
        assertTrue(acrualResult==correctResult);
    }

    @Test
    public void testCase2(){
        int actualResult = calc.add(first_number,second_number);
        assertFalse(actualResult==wrongResult);
    }

    @Test
    public void testCase3(){
        int actuakResult = calc.add(first_number,second_number);
        assertEquals(actuakResult,correctResult);
    }
}

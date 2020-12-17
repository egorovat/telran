import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComposeStringTest {

    @Test
    public void testComposeArray(){

        ConcatenationTest test = new ConcatenationTest(new StringBuilderConcatenator());
        String [] strings = test.composeArray(5, "text");
        Assertions.assertEquals(5, strings.length);
        for (String str: strings) {
            Assertions.assertEquals("text", str);
        }
    }
}

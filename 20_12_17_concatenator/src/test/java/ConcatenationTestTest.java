import org.junit.jupiter.api.Test;

public class ConcatenationTestTest {

    ConcatenationTest test;

    @Test
    public void testStringConcatenator1000Times(){

        test.test(1000, "Some random text");
    }

    @Test
    public void testStringBuilderConcatenator5000Times(){

        test.test(5000, "Some random text");
    }

    @Test
    public void testStringConcatenator5000TimesLongText(){

        test.test(5000, "Some random text  Some random text Some random text Some random text v Some random text Some random text Some random text Some random text Some random text v Some random text Some random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random text");
    }

    @Test
    public void testStringBuilderConcatenator1000TimesLongText(){

        test.test(1000, "Some random text Some random text Some random text Some random text v Some random text Some random text Some random text Some random text Some random text v Some random text Some random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random textSome random text");
    }
}

import org.junit.jupiter.api.BeforeEach;

public class StringBuilderConcatenatorConcatenationTest extends ConcatenationTestTest{

    @BeforeEach
    public void init(){
        test = new ConcatenationTest(new StringBuilderConcatenator());
    }
}

import org.junit.jupiter.api.BeforeEach;

public class StringConcatenatorConcatenationTest extends ConcatenationTestTest{

    @BeforeEach
    public void init(){
        test = new ConcatenationTest(new StringConcatenator());
    }
}

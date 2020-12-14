import org.junit.jupiter.api.BeforeEach;

public class OurLinkedListAutoTest extends OurListAutoTest{

    @BeforeEach
    public void init() {

        autos = new OurLinkedList<>();
    }
}

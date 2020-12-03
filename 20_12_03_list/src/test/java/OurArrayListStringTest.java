import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OurArrayListStringTest {

    private OurArrayList<String> list = new OurArrayList<>();

    @Test
    public void testAddLastToEmptyList_ElementIsAdded(){

        list.addLast("first!");

        Assertions.assertEquals("first!", list.get(0));
    }

    @Test
    public void testCombinedAddLastRemoveByIdSetGetClear_isCorrect(){
        //{"first!, "2!", "Lost", "next after Lost" ,"just a string", "The Last"};
        list.addLast("first!");
        list.addLast("2!");
        list.addLast("Lost");
        list.addLast("next after Lost");
        list.addLast("just a string");
        list.addLast("The Last");

        //{"first!, "2!", "next after Lost", "just a string", "The Last"};
        list.removeById(2);
        //{"first!, "2!", "next after Lost", "a super string", "The Last"};
        list.set(3, "a super string");
        //{"first!, "2!", "next after Lost", "a super string", "The Last", "Who's laughing now?"};
        list.addLast("Who's laughing now?");
        //{"2!", "next after Lost", "a super string", "The Last", "Who's laughing now?"};
        list.removeById(0);

        Assertions.assertEquals(5, list.size());

        //{"2!", "next after Lost", "a super string", "The Last", "Who's laughing now?"};
        Assertions.assertEquals("2!", list.get(0));
        Assertions.assertEquals("next after Lost", list.get(1));
        Assertions.assertEquals("a super string", list.get(2));
        Assertions.assertEquals("The Last", list.get(3));
        Assertions.assertEquals("Who's laughing now?", list.get(4));

        list.clear();

        Assertions.assertEquals(0, list.size());

    }
}

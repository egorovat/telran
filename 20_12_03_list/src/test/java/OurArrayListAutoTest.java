import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OurArrayListAutoTest {

    OurArrayList<Auto> autos = new OurArrayList<Auto>();

    @Test
    public void testRemoveWithAutoObject_ElementIsDeleted(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));
        autos.addLast(new Auto("Lada", "olive"));

        Assertions.assertEquals("Opel", autos.get(0).brand);
        Assertions.assertEquals("Mazda", autos.get(1).brand);
        Assertions.assertEquals("Lada", autos.get(2).brand);

        Auto mazda = new Auto("Mazda", "red");

        Assertions.assertTrue(autos.remove(mazda));

        Assertions.assertEquals("Opel", autos.get(0).brand);
        Assertions.assertEquals("Lada", autos.get(1).brand);
        Assertions.assertEquals(2, autos.size());
    }

    @Test
    public void testRemoveNotMatchingElement_ReturnedFalse(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));

        Auto mazda = new Auto("Mazda", "blue");

        Assertions.assertFalse(autos.remove(mazda));

        Assertions.assertEquals("Opel", autos.get(0).brand);
        Assertions.assertEquals("Mazda", autos.get(1).brand);
        Assertions.assertEquals(2, autos.size());
    }

    @Test
    public void testRemoveNullElementInNoNullsCollection_ReturnedFalse(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));

        Assertions.assertFalse(autos.remove(null));

        Assertions.assertEquals("Opel", autos.get(0).brand);
        Assertions.assertEquals("Mazda", autos.get(1).brand);
        Assertions.assertEquals(2, autos.size());
    }

    @Test
    public void testRemoveNullElementInCollectionWithNulls_ReturnedFalse(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(null);
        autos.addLast(new Auto("Mazda", "red"));
        autos.addLast(null);

        Assertions.assertTrue(autos.remove(null));

        Assertions.assertEquals("Opel", autos.get(0).brand);
        Assertions.assertEquals("Mazda", autos.get(1).brand);
        Assertions.assertEquals(null, autos.get(2));
        Assertions.assertEquals(3, autos.size());
    }
}

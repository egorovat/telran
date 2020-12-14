import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class OurLinkedListAutoTest {

    OurLinkedList<Auto> autos = new OurLinkedList<>();

    @Test
    public void testGetFromEmptyList_IndexOutOfBoundsExceptionThrown(){

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { autos.get(0); });
    }

    @Test
    public void testGetIndexMoreThanSize_IndexOutOfBoundsExceptionThrown(){

        autos.addLast(new Auto("BMW", "black"));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { autos.get(1); });
    }

    @Test
    public void get_Index_Out_Of_Bounds_Exception_Thrown_Index_Less_Than_Zero(){

        autos.addLast(new Auto("BMW", "black"));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { autos.get(-13); });
    }

    @Test
    public void testGetByFirstIndex_ReturnsFirstElement(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));
        autos.addLast(new Auto("Lada", "olive"));

        Auto res = autos.get(0);

        Assertions.assertEquals("Opel", res.brand);
    }

    @Test
    public void testGetByLastIndex_ReturnsLastElement(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));
        autos.addLast(new Auto("Lada", "olive"));

        Auto res = autos.get(2);

        Assertions.assertEquals("Lada", res.brand);
    }

    @Test
    public void testGetByIndexBetweenFirstAndLast_returnsCorrectElement(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));
        autos.addLast(new Auto("Lada", "olive"));

        Auto res = autos.get(1);

        Assertions.assertEquals("Mazda", res.brand);
    }

    @Test
    public void testSetEmptyList_IndexOutOfBoundsExceptionThrown(){

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { autos.set(0, new Auto("Volvo", "asphalt")); });
    }

    @Test
    public void testSetIndexMoreThanSize_IndexOutOfBoundsExceptionThrown(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));
        autos.addLast(new Auto("Lada", "olive"));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { autos.set(3, new Auto("Volvo", "asphalt")); });
    }

    @Test
    public void testSetIndexLessThanZero_IndexOutOfBoundsExceptionThrown(){

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { autos.set(-2, new Auto("Volvo", "asphalt")); });
    }

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
    public void testContainsNullElementInNoNullsCollection_ReturnedFalse(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));

        Assertions.assertFalse(autos.contains(null));

        Assertions.assertEquals("Opel", autos.get(0).brand);
        Assertions.assertEquals("Mazda", autos.get(1).brand);
        Assertions.assertEquals(2, autos.size());
    }


    @Test
    public void testRemoveNullElementInCollectionWithNulls_ReturnedTrue(){

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

    @Test
    public void testRemoveFromListWithOneElement_ReturnedTrue(){

        autos.addLast(new Auto("Opel", "grey"));
        Auto opel = new Auto("Opel", "grey");

        Assertions.assertTrue(autos.remove(opel));

        Assertions.assertEquals(0, autos.size());
    }

    @Test
    public void testContainsNullElementInCollectionWithNulls_ReturnedTrue(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(null);
        autos.addLast(new Auto("Mazda", "red"));
        autos.addLast(null);

        Assertions.assertTrue(autos.contains(null));

        Assertions.assertEquals("Opel", autos.get(0).brand);
        Assertions.assertEquals(null, autos.get(1));
        Assertions.assertEquals("Mazda", autos.get(2).brand);
        Assertions.assertEquals(null, autos.get(3));
        Assertions.assertEquals(4, autos.size());
    }

    @Test
    public void testForwardIteratorEmptyList_ReturnsHasNextFalse(){

        Assertions.assertFalse(autos.forwardIterator().hasNext());
    }

    @Test
    public void testReverseIteratorEmptyList_ReturnsHasNextFalse(){

        Assertions.assertFalse(autos.reversedIterator().hasNext());
    }

    @Test
    public void testForwardIteratorNullsList_ReturnsHasNextFalse(){

        autos.addLast(null);
        autos.addLast(null);

        Iterator iterator = autos.forwardIterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(null, iterator.next());

    }

    @Test
    public void testReverseIteratorNullsList_ReturnsHasNextFalse(){

        autos.addLast(null);
        autos.addLast(null);

        Iterator iterator = autos.reversedIterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(null, iterator.next());

    }

    @Test
    public void testForwardIterator_HasNextAndNextWorkCorrectly(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));
        autos.addLast(new Auto("Lada", "olive"));

        Iterator iterator = autos.forwardIterator();

        for (int i = 0; i < autos.size(); i++) {

            Assertions.assertTrue(iterator.hasNext());
            Assertions.assertEquals(autos.get(i), iterator.next());
        }

        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    public void testReverseIterator_HasNextAndNextWorkCorrectly(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));
        autos.addLast(new Auto("Lada", "olive"));

        Iterator iterator = autos.reversedIterator();

        for (int i = autos.size() -1 ; i >= 0; i--) {

            Assertions.assertTrue(iterator.hasNext());
            Assertions.assertEquals(autos.get(i), iterator.next());
        }

        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    public void testForwardIteratorCurrentIndexEqualsSize_IndexOutOfBoundsException(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));
        autos.addLast(new Auto("Lada", "olive"));

        Iterator iterator = autos.forwardIterator();

        for (int i = 0; i < autos.size(); i++) {

            Assertions.assertTrue(iterator.hasNext());
            Assertions.assertEquals(autos.get(i), iterator.next());
        }

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { iterator.next(); });
    }

    @Test
    public void testReverseIteratorCurrentIndexLessThanZero_IndexOutOfBoundsException(){

        autos.addLast(new Auto("Opel", "grey"));
        autos.addLast(new Auto("Mazda", "red"));
        autos.addLast(new Auto("Lada", "olive"));

        Iterator iterator = autos.reversedIterator();

        for (int i = autos.size() - 1 ; i >= 0; i--) {

            Assertions.assertTrue(iterator.hasNext());
            Assertions.assertEquals(autos.get(i), iterator.next());
        }

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> { iterator.next(); });
    }
}

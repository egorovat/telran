import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class IteratorTest {

    int[] array = {10, -8, 0, 15};

    Iterator<Integer> simpleArrayIterator = new SimpleArrayIterator(array);
    Iterator<Integer> reverseArrayIterator = new ReverseArrayIterator(array);
    Iterator<Integer> ascendingArrayIterator = new AscendingArrayIterator(array);

    @Test
    public void testSimpleArrayIteratorNextReturnsCurrentElement() {

        for (int element : array) {

            Assertions.assertTrue(simpleArrayIterator.hasNext());
            Assertions.assertEquals(element, simpleArrayIterator.next().intValue());
        }

        Assertions.assertFalse(simpleArrayIterator.hasNext());
    }

    @Test
    public void testReverseArrayIteratorNextReturnsCurrentElement() {

        for (int i = array.length - 1; i >=0; i--) {

            Assertions.assertTrue(reverseArrayIterator.hasNext());
            Assertions.assertEquals(array[i], reverseArrayIterator.next().intValue());
        }

        Assertions.assertFalse(reverseArrayIterator.hasNext());
    }

    @Test
    public void testAscendingArrayIteratorNextReturnsCurrentElement() {

        Assertions.assertEquals(-8, ascendingArrayIterator.next().intValue());
        Assertions.assertTrue(ascendingArrayIterator.hasNext());
        Assertions.assertEquals(0, ascendingArrayIterator.next().intValue());
        Assertions.assertTrue(ascendingArrayIterator.hasNext());
        Assertions.assertEquals(10, ascendingArrayIterator.next().intValue());
        Assertions.assertTrue(ascendingArrayIterator.hasNext());
        Assertions.assertEquals(15, ascendingArrayIterator.next().intValue());
        Assertions.assertFalse(ascendingArrayIterator.hasNext());

        //{10, -8, 0, 15}
        Assertions.assertEquals(10, array[0]);
        Assertions.assertEquals(-8, array[1]);
        Assertions.assertEquals(0, array[2]);
        Assertions.assertEquals(15, array[3]);
    }

    }

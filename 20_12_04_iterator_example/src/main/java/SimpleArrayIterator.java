import java.util.Iterator;

public class SimpleArrayIterator implements Iterator<Integer> {

    private final int[] arrayToIterate;
    private int currentIndex = 0;

    SimpleArrayIterator(int[] arrayToIterate) {
        this.arrayToIterate = arrayToIterate;
    }

    @Override
    public boolean hasNext() {

        return currentIndex < arrayToIterate.length;
    }

    @Override
    public Integer next() {

        int res = arrayToIterate[currentIndex];
        currentIndex++;
        return res;
    }
}

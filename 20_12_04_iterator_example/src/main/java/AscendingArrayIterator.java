import java.util.Arrays;
import java.util.Iterator;

public class AscendingArrayIterator implements Iterator<Integer> {

    private final int[] initialArray;
    private final int[] arrayToIterate;
    private int currentIndex = 0;

    public AscendingArrayIterator(int[] initialArray) {

        this.initialArray = initialArray;
        this.arrayToIterate = new int[initialArray.length];
        copyAndSortArrayToIterate();
    }

    private void copyAndSortArrayToIterate(){

        System.arraycopy(initialArray, 0, arrayToIterate, 0, initialArray.length);
        Arrays.sort(arrayToIterate);
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

import java.util.Arrays;
import java.util.Iterator;

public class OurArrayList<T>  implements OurList<T> {

    private static final int INITIAL_CAPACITY = 16;
    private int size;
    private Object[] source;

    public OurArrayList() {

        source = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(T element) {
        if(size == source.length)
            increaseCapacity();
        source[size++] = element;
    }

    private void increaseCapacity() {

        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
    }

    @Override
    public T get(int index) {

        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return (T) source[index];
    }

    @Override
    public void set(int index, T value) {

        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        source[index] = value;

    }

    @Override
    public T removeById(int index) {

        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        T value = (T) source[index];

        System.arraycopy(source, index + 1, source, index, size - index - 1);
        source[size - 1] = null;

        size--;
        return value;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public void clear() {

        Arrays.fill(source, null);
        size = 0;
    }

    @Override
    public boolean remove(T obj) {

        if(obj == null){
            for (int i = 0; i < size; i++) {
                if (source[i] == null) {
                    removeById(i);
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (obj.equals(source[i])) {
                removeById(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T obj) {

        if(obj == null){
            for (int i = 0; i < size; i++) {
                if (source[i] == null) {
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (obj.equals(source[i]))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> forwardIterator() {
        Iterator<T> iterator = new ForwardIterator();
        return iterator;
    }

    @Override
    public Iterator<T> reversedIterator() {
        Iterator<T> iterator = new ReversedIterator();
        return iterator;
    }

    private class ForwardIterator implements Iterator<T> {

        int currentIndex = 0;


        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {

            if(currentIndex >= size) throw new IndexOutOfBoundsException();

            return (T) source[currentIndex++];
        }
    }

    private class ReversedIterator implements Iterator<T> {

        int currentIndex = size - 1 ;


        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public T next() {

            if(currentIndex < 0) throw new IndexOutOfBoundsException();

            return (T) source[currentIndex--];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return forwardIterator();
    }

}

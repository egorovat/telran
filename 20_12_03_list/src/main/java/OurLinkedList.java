import java.util.Iterator;

public class OurLinkedList<T> implements OurList<T> {

    Node<T> first;
    Node<T> last;
    int size;


    @Override
    public void addLast(T element) {

        Node<T> node = new Node<>(null, last, element);
        if(size == 0) first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public T get(int index) {
        Node<T> node = getNodeByIndex(index);
        return node.element;
    }

    @Override
    public void set(int index, T value) {

        Node needle = getNodeByIndex(index);
        needle.element = value;
    }

    private Node getNodeByIndex(int index) {

        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }

    @Override
    public T removeById(int index) {

        Node del = getNodeByIndex(index);

        if(del.next == null) {
            if(del.prev == null){
                last = null;
                first = null;
                size--;
                return (T) del.element;
            }

            Node delPrev = del.prev;
            last = del.prev;

            T element = (T) del.element;

            delPrev.next = null;
            del.prev = null;
            del.element = null;
            size--;

            return element;
        }


        if(del.prev == null) {

            Node delNext = del.next;
            first = delNext;

            T element = (T) del.element;

            delNext.prev = null;
            del.next = null;
            del.element = null;
            size--;

            return element;
        }

        Node delPrev = del.prev;
        Node delNext = del.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;

        T element = (T) del.element;

        del.next = null;
        del.prev = null;
        del.element = null;
        size--;

        return element;

    }

    @Override
    public int size() {

        return size;

    }

    @Override
    public void clear() {

        Node node = first;
        Node current;
        for (int i = 0; i < size - 1; i++) {
            node.prev = null;
            current = node;
            node = node.next;
            current.next = null;
            current.element = null;
            size--;
        }
        last = null;
        first = null;
    }

    @Override
    public boolean remove(T element) {
        Node node = first;

        if(element == null){
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    removeById(i);
                    return true;
                }
                node = node.next;
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (element.equals(node.element)){
                removeById(i);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean contains(T element) {

        Node node = first;

        if(element == null){
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (element.equals(node.element)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public Iterator forwardIterator() {
        return null;
    }

    @Override
    public Iterator reversedIterator() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private static class Node<T>{

        Node<T> next;
        Node<T> prev;
        T element;

        public Node(){

        }
        public Node(Node<T> next, Node<T> prev, T element){

            this.next = next;
            this.prev = prev;
            this.element = element;

        }

    }
}

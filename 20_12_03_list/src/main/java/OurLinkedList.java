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

        return (T) getNodeByIndex(index).element;

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

        Node<T> del = getNodeByIndex(index);
        return deleteNode(del);

    }

    private T deleteNode(Node<T> del) {

        Node<T> delPrev = del.prev;
        Node<T> delNext = del.next;


        if(delPrev != null) {
            delPrev.next = delNext;
        } else {
            first = delNext;
        }

        if(delNext != null) {
            delNext.prev = delPrev;
        }else {
            last = delPrev;
        }

        del.prev = del.next = null;
        T element = (T) del.element;
        del.element = null;

        size--;
        return element;
    }

    @Override
    public boolean remove(T element) {

        Node<T> del = findElement(element);

        if(del == null)
            return false;

        deleteNode(del);
        return true;
    }

    private Node<T> findElement(T element) {

        Node<T> node = first;

        if(element != null){
            while (node != null) {
                if(element.equals(node.element))
                    return node;
                node = node.next;
            }

        } else {
            while (node != null){
                if (node.element == null)
                    return node;
                node = node.next;
            }
        }
        return null;
    }

    @Override
    public int size() {

        return size;

    }

    @Override
    public void clear() {

        last = first = null;
        size = 0;
    }

    @Override
    public boolean contains(T element) {
       return findElement(element) != null;
    }

    @Override
    public Iterator forwardIterator() {

        Iterator<T> iterator = new ForwardIterator();
        return iterator;
    }

    @Override
    public Iterator reversedIterator() {

        Iterator<T> iterator = new ReverseIterator();
        return iterator;
    }

    @Override
    public Iterator<T> iterator() {
        return forwardIterator();
    }

    private class ForwardIterator implements Iterator<T> {

        Node<T> currentNode = first;


        @Override
        public boolean hasNext() {

            return currentNode == null ? false : true;
        }

        @Override
        public T next() {

            if(currentNode == null) {
                throw new IndexOutOfBoundsException();
            }else {
                T currentElement = currentNode.element;
                currentNode = currentNode.next;
                return currentElement;
            }
        }
    }

    private class ReverseIterator implements Iterator<T> {

        Node<T> currentNode = last;

        @Override
        public boolean hasNext() {

            return currentNode == null ? false : true;
        }

        @Override
        public T next() {

            if (currentNode == null) {
                throw new IndexOutOfBoundsException();
            } else {
                T currentElement = currentNode.element;
                currentNode = currentNode.prev;
                return currentElement;
            }
        }
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

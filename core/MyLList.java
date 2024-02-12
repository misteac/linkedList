package linkedList.core;

public class MyLList<T> implements MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;


    @Override
    public void addElement(T element) {
        if (size == 0) {
            Node<T> node = new Node<>(null, element, null);
            first = node;
            last = node;
        } else {
            Node<T> secondLast = last;
            last = new Node<>(secondLast, element, null);
            secondLast.next = last;
        }
        size++;

    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            addElement(element);
            return;
        }
        Node<T> nodeNext = getNode(index);
        Node<T> nodePrev = nodeNext.prev;
        Node<T> newNode = new Node<>(nodePrev, element, nodeNext);
        nodeNext.prev = newNode;
        if (nodePrev != null) {
            nodePrev.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    public boolean removeAt(int index) {
        Node<T> node = getNode(index);
        Node<T> nodeNext = node.next;
        Node<T> nodePrev = node.prev;
        if (nodeNext != null) {
            nodeNext.prev = nodePrev;
        } else {
            last = nodePrev;
        }
        if (nodePrev != null) {
            nodePrev.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public T getIndex(int index) {
        return getNode(index).element;

    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean remove(T element) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (node.element.equals(element)) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }


    private static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private final T element;

        public Node(Node<T> prev, T element, Node<T> next) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }
    }

    public String print(MyLList<T> t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(t.getIndex(i));
            result.append("\n");
        }
        return result.toString();
    }
}
package p190924_Trees;

public class TwoThreeTree<T extends Comparable<T>> {
    TwoNode<T> head;

    public Node<T> find(T key) {
        if (head.key.equals(key)) {
            return head;
        } else {
            if (key < head.key)
        }

    }

    public void insert(T elem) {
        if (head == null) {
//            head = new TwoNode<>(elem, left, right);

        } else {

        }
    }

    private interface Node<T>{}

    private static class TwoNode<T> implements Node<T> {
        private final T key;
        private final Node<T> left;
        private final Node<T> right;

        public TwoNode(T elem, Node<T> left, Node<T> right) {
            key = elem;
            this.left = left;
            this.right = right;
        }
    }

    //TODO: check whether we need to write 'implements' for child
    private static class ThreeNode<T> extends TwoNode<T> {
        private final Node<T> middle;

        public ThreeNode(T elem, Node<T> left, Node<T> middle, Node<T> right) {
            super(elem, left, right);
            this.middle = middle;
        }
    }
}


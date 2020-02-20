package p190924_Trees;

public class Tree<KEY extends Comparable<KEY>, VALUE> {
    private Node root;

    public VALUE get(KEY key) {
        return get(root, key);
    }

    private VALUE get(Node localRoot, KEY key) {
        if (key == null) {
            return null;
        }
        if (localRoot.key.compareTo(key) < 0) {
            return get(localRoot.left, key);
        } else if (localRoot.key.compareTo(key) > 0) {
            return get(localRoot.right, key);
        } else {
            return localRoot.value;
        }
    }

    private class Node {
        private final KEY key;
        private final VALUE value;
        private final Node left;
        private final Node right;

        private Node(KEY key, VALUE value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}

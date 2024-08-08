class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    // Helper function to calculate the sum of all nodes in a subtree
    private int sum(Node node) {
        if (node == null)
            return 0;

        return sum(node.left) + sum(node.right) + node.data;
    }

    // Helper function to check if a tree is a Sum Tree
    private boolean isSumTreeHelper(Node node) {
        // An empty tree is considered a Sum Tree
        if (node == null)
            return true;

        // A leaf node is also considered a Sum Tree
        if (node.left == null && node.right == null)
            return true;

        // Recursively check if the left and right subtrees are Sum Trees
        if (isSumTreeHelper(node.left) && isSumTreeHelper(node.right)) {
            int leftSum = sum(node.left);
            int rightSum = sum(node.right);

            // Check if the current node's data is equal to the sum of its left and right subtrees
            if (node.data == leftSum + rightSum)
                return true;
        }

        return false;
    }

    // Public function to check if the entire tree is a Sum Tree
    public boolean isSumTree(Node root) {
        return isSumTreeHelper(root);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        if (tree.isSumTree(root))
            System.out.println("The given tree is a Sum Tree");
        else
            System.out.println("The given tree is not a Sum Tree");
    }
}

// Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.

// Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level traversal is considered. For example, in the below diagram, 3 and 4 are both the bottommost nodes at a horizontal distance of 0, here 4 will be considered.

//                       20
//                     /    \
//                   8       22
//                 /   \     /   \
//               5      3 4     25
//                      /    \      
//                  10       14

// For the above tree, the output should be 5 10 4 14 25.

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Class for storing a node along with its horizontal distance
    static class NodeInfo {
        Node node;
        int hd;

        NodeInfo(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> bottomView(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        // TreeMap to store the horizontal distance and corresponding node data
        Map<Integer, Integer> hdNodeMap = new TreeMap<>();
        
        // Queue to perform level order traversal
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(root, 0));

        while (!queue.isEmpty()) {
            NodeInfo current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            // Update the map with the current node for this horizontal distance
            hdNodeMap.put(hd, node.data);

            // If there is a left child, add it to the queue with a horizontal distance decreased by 1
            if (node.left != null) {
                queue.add(new NodeInfo(node.left, hd - 1));
            }

            // If there is a right child, add it to the queue with a horizontal distance increased by 1
            if (node.right != null) {
                queue.add(new NodeInfo(node.right, hd + 1));
            }
        }

        // Extracting the values from the map
        List<Integer> bottomViewNodes = new ArrayList<>(hdNodeMap.values());
        return bottomViewNodes;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        // Construct the binary tree shown in the example
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(25);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        List<Integer> result = tree.bottomView(tree.root);
        System.out.println(result); // Output should be [5, 10, 4, 14, 25]
    }
}

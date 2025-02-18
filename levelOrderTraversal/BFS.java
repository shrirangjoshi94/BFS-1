package levelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//In this BFS traversal approach, we first take the root node and place it in a queue.
//Now, while this queue is not empty, we keep adding the values of the nodes to a new arraylist and adding the children of the nodes into the queue.
//We also keep a size variable as we need to have a distinction at each level, to have nodes at each level in a separate list.
//After each level, we add the new arraylist to the result.
//Time complexity: O(n)
//Space Complexity: O(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class BFS {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> re = new ArrayList<>();
        if (root == null) {
            return re;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> li = new ArrayList();
            // processing the level
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                li.add(curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            re.add(li);
        }

        return re;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

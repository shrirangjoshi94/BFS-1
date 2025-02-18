package levelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

//In this approach, we use dfs for level order traversing
//At each node, we keep the track of the level of the node and add the node value to a new list if the depth of the node is equal to the size of the result and add the list to the result
//If at a node there is already a list exists, then we simply add the node value to that list in the result.
//Time Complexity:O(n)
//Space Complexity: O(h) for recursive stack space, where h is the maximum depth of the tree from root to a leaf node.

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach:
 * This problem is about determining if it's possible to complete all courses given the prerequisite dependencies.
 * I have used an array indegree to track how many prerequisites each course has, and a HashMap `map` to store the courses dependent on others.
 * Using a queue, I perform a topological sort to process courses with no prerequisites, decrementing the indegree of their
 * dependent courses and adding them to the queue, and if we can process all courses, we return true, otherwise false.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class DFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> re = new ArrayList<>();

        if(root == null) {
            return re;
        }

        dfs(root, 0, re);

        return re;
    }

    private void dfs(TreeNode root, int size, List<List<Integer>> re)
    {
        if(root == null) {
            return;
        }

        if(re.size() - size < 1) {
            re.add(new ArrayList());
        }

        re.get(size).add(root.val);

        dfs(root.left, size + 1, re);
        dfs(root.right, size + 1, re);
    }
}

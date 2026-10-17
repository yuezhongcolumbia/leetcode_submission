/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       lca = null;
        dfs(root, p, q);
        return lca;
       
    }
    public int dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return 0;
        int leftCount = dfs(root.left, p, q);
        int rightCount = dfs(root.right, p, q);
        int cur = (root.val == p.val || root.val == q.val) ? 1 : 0;
        
        int totalCount = leftCount+rightCount+cur;
        if (totalCount == 2 && lca == null){
            lca = root;
        }
        return totalCount;
    }
}
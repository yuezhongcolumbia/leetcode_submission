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
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }
    public List<TreeNode> build(int lower, int upper){
        List<TreeNode> res = new ArrayList<>();

        if (lower > upper) {
            res.add(null);
            return res;
        }

        for(int rootVal = lower; rootVal <= upper; rootVal++){
            List<TreeNode> leftList = build(lower, rootVal - 1);
            List<TreeNode> rightList = build(rootVal + 1, upper);
            for(TreeNode left: leftList){
                for(TreeNode right: rightList){
                    TreeNode node = new TreeNode(rootVal);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
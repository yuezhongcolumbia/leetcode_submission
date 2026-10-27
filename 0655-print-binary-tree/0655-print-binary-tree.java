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
    int height;
    List<List<String>> res;
    int width;
    public List<List<String>> printTree(TreeNode root) {
        // the difficullty is we need to place the nodes in the right place
        // we need the "width", width = 2^h -1
        // given the idx of root, we actually know the idx of left and right, make sense to do pre order.
        // pass down: node, idx

        // but we need find the height first;
       
        

        height = 0;
        dfsHeight(root, 0);
        width = (1 << (height + 1)) - 1;
        res = new ArrayList<>();
        for(int i = 0; i < height + 1; i++){
            List<String> layer = new ArrayList<>();
            for(int j = 0; j < width; j++){
                layer.add("");
            }
            res.add(layer);
        }
        int rootIdx = (width - 1) >> 1;
        dfs(root, rootIdx, 0);
        return res;
  
    }
    public void dfsHeight(TreeNode root, int lvl){
        if (root == null) return;
        height = Math.max(height, lvl);
        dfsHeight(root.left, lvl + 1);
        dfsHeight(root.right, lvl + 1);
    }
    public void dfs(TreeNode root, int idx, int lvl){
        if (root == null) return;
        res.get(lvl).set(idx, String.valueOf(root.val));
        int leftIdx = idx - (1 << (height - lvl - 1));
        int rightIdx = idx + (1 << (height - lvl - 1)); 
        dfs(root.left, leftIdx, lvl + 1);
        dfs(root.right, rightIdx, lvl + 1);
    }
    
}
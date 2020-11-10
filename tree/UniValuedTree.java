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
class UniValuedTree {
    public boolean isUnivalTree(TreeNode root) {        
        if(root == null){
            return true;
        }
        return isValueEqual(root.left, root.val) && isValueEqual(root.right,root.val) && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
    private boolean isValueEqual(TreeNode node, int rootVal){
        if(node == null){
            return true;
        }
        return node.val == rootVal;        
    }   
    
}

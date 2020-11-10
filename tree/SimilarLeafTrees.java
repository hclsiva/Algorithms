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
class SimilarLeafTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        int root1Data = getLeafSum(root1,0);
        System.out.println(root1Data);
        int root2Data = getLeafSum(root2,0);
        System.out.println(root2Data);
        return root1Data == root2Data;
    }
    private int getLeafSum(TreeNode root,int data){
        if(root == null){
            return data;
        }
        if(root.left == null && root.right == null){
            data = 10*data+root.val;
        }
        data = getLeafSum(root.left, data);
        data = getLeafSum(root.right,data);
        return data;        
    }
}

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
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> computedPaths = new ArrayList<String>();
        binaryTreePaths(root,computedPaths,"");
        System.out.println(computedPaths);
        return computedPaths;
    }
    private void binaryTreePaths(TreeNode root, List<String> pathList,String tempPath){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            tempPath +=root.val;
            pathList.add(tempPath);
        }else{
            tempPath +=root.val+"->";
        }
        binaryTreePaths(root.left,pathList,tempPath);
        binaryTreePaths(root.right,pathList,tempPath);
    }
}

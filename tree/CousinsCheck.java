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
public class CousinsCheck {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xparentNode = getParent(root,null,x);
        TreeNode yparentNode = getParent(root,null,y);
        List<TreeNode> xnodePath =new ArrayList<TreeNode>();
        List<TreeNode> ynodePath = new ArrayList<TreeNode>();        
        pathToNode(root,xnodePath,xparentNode);
        pathToNode(root,ynodePath,yparentNode);        
        return xnodePath.size() == ynodePath.size() && xparentNode.val != yparentNode.val;
    }
    private TreeNode getParent(TreeNode currnode,TreeNode parentnode,int val){
        if(currnode == null){
            return currnode;
        }
        if(currnode.val == val){
            return parentnode;
        }
        parentnode = getParent(currnode.left,currnode,val);
        if(parentnode == null){
            parentnode = getParent(currnode.right,currnode,val);
        }
        return parentnode;
    }
    private void pathToNode(TreeNode root, List<TreeNode> nodeList, TreeNode node){
        if(root == null){
            return ;
        }
        
        if(node != null && root.val == node.val){
            nodeList.add(root);
            return;
        }
        if(nodeList.size()==0)
        pathToNode(root.left,nodeList,node);
        if(nodeList.size()==0)
        pathToNode(root.right,nodeList,node);                
        if(nodeList.size() > 0){
            nodeList.add(root);
        }
                
    }
}

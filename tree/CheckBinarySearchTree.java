public class CheckBinarySearchTree{
	
	boolean checkBST(Node root) {
	   boolean isBST = isBST(root);
       System.out.println(isBST?"Yes":"No");
	   return isBST;
    }
    boolean isBST(Node root) {
        boolean isBST = true;
        if(root == null){
            return isBST;
        }
        if(root.left != null){
            if(root.data > root.left.data){
                isBST&= isBST(root.left);
            }else{
                return false;
            }    
        } 
        if(root.right != null){
            if(root.data < root.right.data){
                isBST&= isBST(root.right);
            }else{
                return false;
            }
        }        
        return isBST;
    }
	Node returnLastRightNode(Node root){
		if(root == null || root.right == null){
			return root;
		}
		return returnLastRightNode(root.right);
	}
	void inorderTraversal(Node root){
		if(root == null){
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.data+" ");
		inorderTraversal(root.right);
	}
	public static void main(String[] args){
		String elements = "4,2,1,3,6,5,7";
		Node node = IntegerTreeBuilder.buildBST(elements);
		CheckBinarySearchTree bstChk = new CheckBinarySearchTree();
		System.out.println(bstChk.isBST(node)?"Yes":"No");
		Node lastRight = bstChk.returnLastRightNode(node);
		lastRight.right = new Node(1);
		bstChk.inorderTraversal(node);
		System.out.println();
		System.out.println(bstChk.isBST(node)?"Yes":"No");			
	}

}
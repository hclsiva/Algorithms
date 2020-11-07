import java.util.*;
import java.io.*;

public class PostOrderTraversal {
	public static void postOrder(Node root) {
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " " );
    }

    public static void main(String[] args) {
        String elements = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O";
		Node root = TreeBuilder.constructBinaryTree(elements);
		String[] elementsArray = elements.split(",");
		TreePrinter.Node printableTree = TreeBuilder.constructBinaryTreeToPrint(elements);
		TreePrinter.print(printableTree);
		for(int i =1;i <=10;i++){
			System.out.println();
		}
        postOrder(root);
    }
	
		
	public static TreePrinter.Node insert(TreePrinter.Node root, String data) {
		if(root == null) {
			return new TreePrinter.Node(data);
		} else {
			TreePrinter.Node cur;
			if(data.compareTo(root.val)<=0) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right,data);
				root.right = cur;
			}
			return root;
		}
	}
	
}
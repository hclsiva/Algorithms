import java.util.LinkedList;
import java.util.Queue;

class Node{
	public int data;
	public Node left = null;
	public Node right = null;
	public Node(int data){
		this.data = data;
	}
	public String toString() {
		return ""+this.data;
	}
}
public class IntegerTreeBuilder {
	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data < root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
	public static TreePrinter.Node insertPrintNode(TreePrinter.Node root, String data) {
        if(root == null) {
            return new TreePrinter.Node(data);
        } else {
            TreePrinter.Node cur;
            if(data.compareTo(root.val)<=0) {
                cur = insertPrintNode(root.left, data);
                root.left = cur;
            } else {
                cur = insertPrintNode(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
	public static Node buildBST(String elementCSV){
		String[] elementArray = elementCSV.split(",");
		Node node = null;
		TreePrinter.Node printableTree = null;
		for(int i =0;i<elementArray.length;i++){
			node = insert(node,Integer.parseInt(elementArray[i]));
			printableTree = insertPrintNode(printableTree,elementArray[i]);
		}
		TreePrinter.print(printableTree);
		return node;
	}
	public static void main(String[] args) {
		String elements = "1,2,3,4";
		Node node = buildBST(elements);
	}

}

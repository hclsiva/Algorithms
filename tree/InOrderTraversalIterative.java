import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
public class InOrderTraversalIterative{

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
	public void inOrderTraversalIterative(Node root){
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		Set<Integer> visitedNodes = new HashSet<Integer>();
		if(root != null){
			stack.push(current);
			while(!stack.isEmpty()){
				if(current.left != null && (!visitedNodes.contains(current.left.data))){
					stack.push(current.left);
					current = current.left;					
				}else{
					current = stack.pop();					
					visitedNodes.add(current.data);
					System.out.print(current.data + " ");
					if(current.right != null && (!visitedNodes.contains(current.right.data))){
						stack.push(current.right);
						current = current.right;
					}
				}
			}
		}
	}
	public void inOrderTraversalRecursive(Node root){
		if(root == null){
			return;
		}
		inOrderTraversalRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderTraversalRecursive(root.right);
	}
	public static void main(String[] args) {
		String elements = "4,2,6,1,3,5,7"; 
		Node node = buildBST(elements);
		InOrderTraversalIterative inOrderTraversalUtility = new InOrderTraversalIterative();
		System.out.println();
		System.out.println("In order traversal Iterative Procedure for the above tree");
		System.out.println();
		inOrderTraversalUtility.inOrderTraversalIterative(node);
		System.out.println();
		System.out.println();
		System.out.println("In order traversal Recursive Procedure for the above tree");
		System.out.println();
		inOrderTraversalUtility.inOrderTraversalRecursive(node);
	}	
}
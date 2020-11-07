import java.util.LinkedList;
import java.util.Queue;
class StringNode{
	public String val = null;
	public StringNode left = null;
	public StringNode right = null;

	public StringNode(String val) {
		this.val = val;
	}

	public String toString() {
		return this.val;
	}
}
public class StringTreeBuilder {
	public StringTreeBuilder() {
	}

	public static StringNode constructBinaryTree(String elements) {
		String s = "," + elements;
		String[] nodes = s.split(",");
		int k = 1;
		StringNode node = new StringNode(nodes[k]);
		StringNode root = node;
		int length = nodes.length;
		while (k < length) {
			node = searchNode(root, nodes[k]);
			if (node != null) {
				int l = 2 * k;
				int m = 2 * k + 1;
				if (l < length && !nodes[l].equals("#")) {
					node.left = new StringNode(nodes[l]);
				}
				if (m < length && !nodes[m].equals("#")) {
					node.right = new StringNode(nodes[m]);
				}
			}
			k++;
		}
		return root;
	}

	private static StringNode searchNode(StringNode node, String key) {
		if (node == null) {
			return null;
		}
		if (node.val.equals(key)) {
			return node;
		}
		StringNode searchNode = searchNode(node.left, key);
		if (searchNode == null) {
			searchNode = searchNode(node.right, key);
		}
		return searchNode;
	}

	public static TreePrinter.Node constructBinaryTreeToPrint(String elements) {
		String s = "," + elements;
		String[] nodes = s.split(",");
		int k = 1;
		TreePrinter.Node node = new TreePrinter.Node(nodes[k]);
		TreePrinter.Node root = node;
		int length = nodes.length;
		while (k < length) {
			node = searchNode(root, nodes[k]);
			if (node != null) {
				int l = 2 * k;
				int m = 2 * k + 1;
				if (l < length && !nodes[l].equals("#")) {
					node.left = new TreePrinter.Node(nodes[l]);
				}
				if (m < length && !nodes[m].equals("#")) {
					node.right = new TreePrinter.Node(nodes[m]);
				}
			}
			k++;
		}
		return root;
	}

	private static TreePrinter.Node searchNode(TreePrinter.Node node, String key) {
		if (node == null) {
			return null;
		}
		if (node.val.equals(key)) {
			return node;
		}
		TreePrinter.Node searchNode = searchNode(node.left, key);
		if (searchNode == null) {
			searchNode = searchNode(node.right, key);
		}
		return searchNode;
	}
	private static void printPreOrderTraversal(StringNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + ",");
		printPreOrderTraversal(node.left);
		printPreOrderTraversal(node.right);
	}
	
	private static String lvlOrderTraversal(StringNode node){
		if(node == null){
			return null;
		}
		Queue<StringNode> q = new LinkedList<StringNode>();
		StringBuffer buffer = new StringBuffer();
		q.add(node);
		while(!q.isEmpty()){
			node = q.remove();
			if(node.left != null){
				q.add(node.left);
			}
			if(node.right != null){
				q.add(node.right);
			}
			buffer.append(node.val+",");
		}
		return buffer.toString();
	}
	public static StringNode insert(StringNode root, String data) {
        if(root == null) {
            return new StringNode(data);
        } else {
            StringNode cur;
            if(data.compareTo(root.val)<=0) {
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
	public static StringNode buildBST(String elementCSV){
		String[] elementArray = elementCSV.split(",");
		StringNode node = null;
		TreePrinter.Node printableTree = null;
		for(int i =0;i<elementArray.length;i++){
			node = insert(node,elementArray[i]);
			printableTree = insertPrintNode(printableTree,elementArray[i]);
		}
		TreePrinter.print(printableTree);
		return node;
	}
	public static void main(String[] args) {
		String elements = "A,B,C,D,E,F,G,H,I,J,L";
		StringNode node = constructBinaryTree(elements);
		printPreOrderTraversal(node);
		System.out.println();
		System.out.println(lvlOrderTraversal(node));
	}

}

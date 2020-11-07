public class TreeHeight {

	public TreeHeight() {
		// TODO Auto-generated constructor stub
	}

	public int height(Node node){
		if(node == null){
			return -1;
		}
		return 1+Math.max(height(node.left) , height(node.right));
	}
	
	public static void main(String[] args) {
		String elements="4,2,3,1,7,6";
		Node node =TreeBuilder.buildBST(elements);
		System.out.println(" Height of Tree is = " + new TreeHeight().height(node));
	}

}

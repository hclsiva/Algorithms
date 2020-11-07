import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Binary tree printer
 * Taken from http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram - @author MightyPork
 * 
 */
public class TreePrinter {

  /**
   * Node that can be printed
   */
  public interface PrintableNode {
    /**
     * Get left child
     */
    PrintableNode getLeft();

    /**
     * Get right child
     */
    PrintableNode getRight();

    /**
     * Get text to be printed
     */
    String getText();
  }

  /**
   * Given an array of Objects
   * @param elems array of integer elems
   */
  public static <T> void print(T[] elems) {
    Node root = getNode(elems, 0);
    print(root);
  }

  private static <T> Node getNode(T[] elems, int index) {
    final Node n;
    if (index < elems.length) {
      n = new Node(elems[index].toString());
      n.left = getNode(elems, 2*index+1);
      n.right = getNode(elems, 2*index+2);
    } else {
      n = null;
    }
    return n;
  }

  static class Node implements PrintableNode {

    final String val;
    public Node left;
    public Node right;

    Node(String pVal) {
      this.val = pVal;
    }

    void setNodes(Node pLeft, Node pRight) {
      left = pLeft;
      right = pRight;
    }

    @Override
    public PrintableNode getLeft() {
      return left;
    }

    @Override
    public PrintableNode getRight() {
      return right;
    }

    @Override
    public String getText() {
      return val;
    }
  }

  /**
   * Print a tree
   *
   * @param root tree root node
   */
  public static void print(PrintableNode root) {
    List<List<String>> lines = new ArrayList<List<String>>();
    List<PrintableNode> level = new ArrayList<PrintableNode>();
    List<PrintableNode> next = new ArrayList<PrintableNode>();

    level.add(root);
    int nn = 1;
    int widest = 0;
    while (nn != 0) {
      List<String> line = new ArrayList<String>();
      nn = 0;
      for (PrintableNode n : level) {
        if (n == null) {
          line.add(null);
          next.add(null);
          next.add(null);
        } else {
          String aa = n.getText();
          line.add(aa);
          if (aa.length() > widest) {
            widest = aa.length();
          }
          next.add(n.getLeft());
          next.add(n.getRight());
          if (n.getLeft() != null) nn++;
          if (n.getRight() != null) nn++;
        }
      }

      if (widest % 2 == 1) widest++;
      lines.add(line);
      List<PrintableNode> tmp = level;
      level = next;
      next = tmp;
      next.clear();
    }

    int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
    for (int i = 0; i < lines.size(); i++) {
      List<String> line = lines.get(i);
      int hpw = (int) Math.floor(perpiece / 2f) - 1;

      if (i > 0) {
        for (int j = 0; j < line.size(); j++) {
          // split node
          String c = " ";
          if (j % 2 == 1) {
            if (line.get(j - 1) != null) {
              c = (line.get(j) != null) ? new String(("┴")) :  new String("┘".getBytes()).intern();
            } else {
              if (j < line.size() && line.get(j) != null)
				c = new String("└".getBytes()).intern();
            }
          }
          System.out.print(c);

          // lines and spaces
          if (line.get(j) == null) {
            for (int k = 0; k < perpiece - 1; k++) {
              System.out.print(" ");
            }
          } else {
            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? " " : "─");
            }
            System.out.print(j % 2 == 0 ? "┌" : "┐");
            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? "─" : " ");
            }
          }
        }
        System.out.println();
      }

      // print line of numbers
      for (int j = 0; j < line.size(); j++) {
        String f = line.get(j);
        if (f == null) f = "";
        int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
        int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

        // a number
        for (int k = 0; k < gap1; k++) {
          System.out.print(" ");
        }
        System.out.print(f);
        for (int k = 0; k < gap2; k++) {
          System.out.print(" ");
        }
      }
      System.out.println();

      perpiece /= 2;
    }
  }
}
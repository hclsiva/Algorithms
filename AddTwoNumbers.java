package algorithms;

/**
 * See Description here - https://leetcode.com/problems/add-two-numbers/
 * 
 * @author sravisa1
 *
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultNode = new ListNode();
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		resultNode = addTwoNumbers((l1 != null) ? l1 : null, (l2 != null) ? l2 : null, 0);
		return resultNode;
	}

	private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
		ListNode resultNode = new ListNode();
		if (l1 == null && l2 == null) {
			if(carry >0) {
				resultNode.val = carry;
				return resultNode;
			}
			return null;
		}
		int a = 0, b = 0;
		if (l1 != null)
			a = l1.val;
		if (l2 != null)
			b = l2.val;
		int result = (carry + a + b) % 10;
		carry = (carry+a + b) / 10;
		resultNode.next = addTwoNumbers((l1 != null) ? l1.next : null, (l2 != null) ? l2.next : null, carry);
		resultNode.val = result;
		return resultNode;
	}

	private ListNode convertNumToList(int n) {
		int i =1;
		int base = 10;
		int q = n;
		ListNode next = null;
		ListNode current= null;
		while(q >0) {
			current= new ListNode();
			int result = q%base;
			q = q/base;
			current.val = result;
			current.next = next;
			next = current;			
		}
		return next;
			
	}
	private void printList(ListNode node) {
		if(node != null) {
			for(;node != null;node=node.next) {
				System.out.print(node.val+" -> ");
			}
		}else {
			System.out.println("null");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		AddTwoNumbers operations = new AddTwoNumbers();
		ListNode number1 = operations.convertNumToList(9999999);
		ListNode number2 = operations.convertNumToList(9999);
		operations.printList(number1);
		operations.printList(number2);
		ListNode result = operations.addTwoNumbers(number1, number2);
		operations.printList(result);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

import java.util.Stack;

public class ListPalindrome {

    //example 0 -> 1 -> 2 -> 1 -> 0 is a palindrome
    //Approach one: reverse and compare

    public static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    public static LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data); //clone
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    //approach two: fast and slow runner
    //reverse the first half of the list and compare with second half

    public static boolean isPalindrome2(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<>();
        //push elems from first half of the list on the stack, because the fast runner has 2x the speed of 
        //the slow one, we know if fast is at the end, slow is in the middle

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        //odd number of elems skip the middle
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();

            //if values are different -> not a palindorome
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    
}

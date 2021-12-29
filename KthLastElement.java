public class KthLastElement {
    //return the kth last element of a list

    //if the length is known, iterate through the list and return the kth last

    //recursive approach: the algo recurses through the list, when it hits the end it
    //passes back a counter set to 0. each parent call adds 1 to this counter

    //O(N) Space 
    public static int printKthLast(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th last node is "+ head.data);
        }
        return index;
    }

    //iterative solution
    //O(N) Time and O(1) Space

    public static LinkedListNode nThLast(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        //move p1 k nodes into the list
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        //move both at the same pace . When p1 hits the end p2 is k nodes from the end away
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

}
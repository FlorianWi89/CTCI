public class ListIntersection {

    //idea: if two singly linked lists intersect, they need to have the same tail or end node
    //if not, they do not intersect

    /*
    Approach: traverse through each list and get the length and the tail
    compare the tails, if they are not the same return false, compare by reference !
    set two pointers at the start of each list, on the longer list advance its pointer 
    by the length difference. Now traverse until both pointers have same reference

    */

    //Runtime O(A  + B) where A and B are the sizes of the lists, O(1) Space

    public static LinkedListNode findIntersect(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null || l2 == null) return null;

        //get tail and sizes
        Result result1 = getTailAndSize(l1);
        Result result2 = getTailAndSize(l2);

        //if different tail nodes -> no intersection
        if (result1.tail != result2.tail) {
            return null;
        }

        //set two pointers at the start of each list
        LinkedListNode shorter = result1.size < result2.size ? l1 : l2;
        LinkedListNode longer = result1.size < result2.size ? l1 : l2;

        //advance the pointer of the longer list by the difference in the lengths
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        //move both pointers until you have a collusion
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }

    public static class Result{
        public LinkedListNode tail;
        public int size;
        public Result(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    public static Result getTailAndSize(LinkedListNode list) {
        if (list == null) return null;

        int size = 1;
        LinkedListNode current = list;
        while (current != null) {
            size++;
            current = current.next;
        }
        return new Result(current,size);
    }
    
    public static LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }
}

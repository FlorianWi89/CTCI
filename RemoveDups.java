import java.util.HashSet;

//LinkedList problem
//task is to remove duplicates from a linked list


public class RemoveDups {
    
    //this solution takes O(N) time where N is the number of nodes

    public void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode prev = null;

        while (n != null) {
            if (set.contains(n.data)) {
                prev.next = n.next;
            } else {
                set.add(n.data);
                prev = n;
            }
            n = n.next;
        }

    }
}

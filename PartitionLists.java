public class PartitionLists {
    
    //task: given a linked list and a node as a partition element. Divide the list around the
    //partition element such that smaller nodes are in the before and bigger in the after list

    //3 5 8 5 10 2 1 -> 3 1 2     10 5 5 8

    //approach one
    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        //partition lists
        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data < x) {
                //insert node into end of before list
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                //insert node into end of after list
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node =next;
        }

        if (beforeStart == null)
            return afterStart;

            //merge before and after list

        beforeEnd.next = afterStart;
        return beforeStart;
    }



    //a bit shorter solution by using only two pointer nodes
    public static LinkedListNode partition2(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }
}

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        ListNode reversedHead = prev;
        int index = 0;
        ListNode currentHead = reversedHead;
        ListNode previous = null;
        while (currentHead != null) {
            index++;
            if (index == n) {
                if (previous == null) {
                    reversedHead = currentHead.next;
                } 
                else {
                    previous.next = currentHead.next;
                }
                break;
            }
            previous = currentHead;
            currentHead = currentHead.next;
        }
        prev = null;
        current = reversedHead;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
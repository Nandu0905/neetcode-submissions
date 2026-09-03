/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int count=0;
        while(current!=null){
            count++;
            current = current.next;
        }
        int nodeToRemove = count-n+1;
        ListNode prev = null;
        ListNode curr = head;
        int index=0;
        while(curr!=null){
            index++;
            if(index==nodeToRemove){
                if(prev==null){
                    head=curr.next;
                    curr = curr.next;
                }else{
                    prev.next=curr.next;
                }
                break;
            }else{
                prev=curr;
                curr=curr.next;
            }
        }
        return head;
    }
}

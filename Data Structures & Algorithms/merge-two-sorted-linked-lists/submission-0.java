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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
     {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode current1 =list1;
        ListNode current2=list2;
        ListNode next;
        while(current1!=null && current2!=null){
            if(current1.val<current2.val){
                next=current1.next;
                prev.next=current1;
                prev=current1;
                current1=next;
            }else if(current2.val<=current1.val){
                next=current2.next;
                prev.next=current2;
                prev=current2;
                current2=next;
            }
        }
        if(current1!=null){
            prev.next=current1;
        }
        if(current2!=null){
            prev.next=current2;
        }
        return dummy.next;
    }
}
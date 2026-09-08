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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1= l1;
        ListNode curr2 = l2;
        int carry=0;
        ListNode node=new ListNode(carry);
        ListNode curr = node;
        while(curr1!=null && curr2!=null){
            int sum = carry+curr1.val+curr2.val;
            node.next = new ListNode(sum%10);
            node = node.next;
            carry = sum/10;
            curr1=curr1.next;
            curr2=curr2.next;
        }
        while(curr1!=null){
            int sum = carry+curr1.val;
            node.next= new ListNode(sum%10);
            carry = sum/10;
            node = node.next;
            curr1=curr1.next;
        }
        while(curr2!=null){
            int sum = carry+curr2.val;
            node.next= new ListNode(sum%10);
            carry=sum/10;
            node = node.next;
            curr2=curr2.next;
        }
        if(carry>0){
            node.next=new ListNode(carry);
        }
        return curr.next;
    }
}

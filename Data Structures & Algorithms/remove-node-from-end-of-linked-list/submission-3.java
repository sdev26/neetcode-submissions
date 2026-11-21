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
        if(head==null)
            return null;
        ListNode temp=new ListNode();
        ListNode curr=head;
        temp.next=curr;
        ListNode slow=temp,fast=temp;
        while(n>0&&fast!=null&&fast.next!=null){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
           slow=slow.next;
           fast=fast.next;
        }
        slow.next=slow.next.next;
        return temp.next;
    }
}

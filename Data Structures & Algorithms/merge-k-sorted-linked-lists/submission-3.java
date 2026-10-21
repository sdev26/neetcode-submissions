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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode t:lists){
            if(t!=null)pq.offer(t);
        }
        ListNode dummy=new ListNode();
        ListNode head=dummy;
        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            dummy.next=curr;
            if(curr.next!=null)pq.add(curr.next);
            dummy=dummy.next;
        }
        return head.next;
    }
}

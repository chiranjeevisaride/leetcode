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
        if(lists == null || lists.length == 0) return null;
        ListNode result = new ListNode(-1);
        ListNode head = result;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list : lists) {
            if(list != null)
                minHeap.add(list);
        }
        
        while(!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.remove();
            result.next = smallestNode;
            result = smallestNode;
            if(smallestNode.next != null)
                minHeap.add(smallestNode.next);
        }
       return head.next;
    }    
}
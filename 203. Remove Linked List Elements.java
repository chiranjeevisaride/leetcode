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
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) {
            head = head.next;
        }
        ListNode node = head, prev = head;
        while(node != null) {
            if(node.val == val) {
                prev.next = node.next;
                node = node.next;
                continue;
            } 
            prev = node;
            node = node.next;   
        }
        return head;
    }
}
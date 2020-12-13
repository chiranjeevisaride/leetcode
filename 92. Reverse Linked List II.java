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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode current = head, previous = null;
        for(int index = 0; index < m - 1; index++) {
            previous = current;
            current = current.next;
        }
        if(previous != null)
            previous.next = reverseList(current, m, n);
        else
           head = reverseList(current, m, n); 
        return head;
    }
    
    private ListNode reverseList(ListNode current, int m, int n) {
        ListNode previous = null, next = null, lastNode = current;
        int counter = 0;
        while(current != null && counter != (n - m + 1)) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            counter +=1;
        }
        lastNode.next = current;
        return previous;
    }
}
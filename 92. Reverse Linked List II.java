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
        if(head == null || m >= n) return head;
        ListNode previous = null, current = head;
        for(int index = 0; index < m - 1; index++) {
            previous = current;
            current = current.next;
        }
         if(previous != null) {
              previous.next = reverseList(current, n - m + 1);
              return head; 
         }  
         else
             return reverseList(head, n - m + 1);  
    }
    
    private ListNode reverseList(ListNode head, int n) {
        ListNode prev = null, current = head;
        while(current != null && n > 0) {   
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp; 
            --n;
        }
        head.next = current;
       return prev;
    }
}
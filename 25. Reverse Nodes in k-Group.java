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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) return head;
        
        ListNode ptr = head, ktail = null, newHead = null;
       
        
        while(ptr != null) {
             
            int counter = 0;
            
            while(ptr != null && counter != k) {
                ptr = ptr.next;
                counter += 1;
            }
            
            
            if(counter == k) {
                ListNode revHead = reverseList(head, k);
               
                if(newHead == null)
                    newHead = revHead;
                
                if(ktail != null)
                    ktail.next = revHead;
                
                ktail = head;
                head = ptr;
            }
               
        }
          if(ktail != null)
              ktail.next = head;
        
        return newHead == null ? head : newHead;
    }
    
    
    private ListNode reverseList(ListNode head, int k) {
        ListNode nextNode = null, previous = null;
        while(head != null && k > 0) {
            nextNode = head.next;
            head.next = previous;
            previous = head;
            head = nextNode;
            --k;
        }
        return previous;
    }
}
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
        int counter1 = 0, counter2 = 0;
        ListNode temp = null;
        temp = l1; 
        while(temp != null) {
            counter1++;
            temp = temp.next;
        }
        
        temp = l2;
         while(temp != null) {
            counter2++;
            temp = temp.next;
        }
        
        ListNode head = null;
        while(counter1 > 0 || counter2 > 0) {
            int val = 0;
            if(counter1 > counter2) {
                val = l1.val;
                counter1 -=1;
                l1 = l1.next;
            } else if(counter2 > counter1) {
                 val = l2.val;
                 l2 = l2.next;
                 counter2 -=1;
            } else {
                 val = l1.val + l2.val;
                 l1 = l1.next;
                 l2 = l2.next;
                 counter1 -=1;
                 counter2 -=1;
            }
             ListNode node = new ListNode(val);
             node.next = head;
             head = node;
        }
        
        ListNode prev = null;
        int carry = 0;
        while(head != null) {
            int sum = carry + head.val;
            head.val = sum%10;
            carry = sum/10;
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        if(carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }
}
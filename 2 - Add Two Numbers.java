/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode = new ListNode(0);
        ListNode dummyHead = currentNode;
        int carry = 0;
        while(l1!= null || l2!= null){
             int a = l1!= null ? l1.val : 0;
             int b = l2!= null ? l2.val : 0;
             int sum = carry  + a + b;
             currentNode.next = new ListNode(sum%10);
             carry = sum/10;
             currentNode = currentNode.next;
             if(l1!= null) l1 = l1.next;
             if(l2!= null) l2 = l2.next;
        }
        if(carry>0){
            currentNode.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
          if(headA == null || headB == null) return null;
          ListNode a = headA, b = headB;
          while(a!= b){
              a = a == null ? a = headB : a.next;
              b = b == null ? b = headA : b.next;
          }
          return a;
    }
}

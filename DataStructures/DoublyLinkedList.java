import java.io.*;
import java.util.*;

 
class ListNode<T> {
  T val;
  ListNode<T> prev, next;
  ListNode(T val) {
    this.val = val;
    this.prev = this.next = null;
  }  
}  


class DoublyLikedList<T> {
  
  ListNode<T> head, tail;
  int size;
  
  DoublyLikedList() {
    head = tail = null;
    size = 0;
  }
  
   // Time O(1)
  public boolean addFirst(T val) {
    ListNode<T> newNode = new ListNode<T>(val);
    if(size == 0) {
      head = tail = newNode;
    } else {
       newNode.next = head;
       newNode.prev = head;
       head = newNode;
    }  
    ++size;
    return true;
  }  
  
   // Time O(1)
  public boolean addLast(T val) {
    if(size == 0)
      addFirst(val);
    else {
      ListNode<T> newNode = new ListNode<T>(val);
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
      ++size; 
    }
    return true;
  }  
  
   // Time O(n)
  public boolean add(T val, int index) {
    if(index < 0 || index > size) {
       System.out.println("Invalid index"); 
       return false;
    } else if(index == 0)
      addFirst(val);
      else if(index == size)
       addLast(val);
      else {
         ListNode<T> newNode = new ListNode<T>(val);
         ListNode<T> current = head;
         for(int pos = 0; pos < index - 1; pos++) {
            current = current.next;
         }
         newNode.next = current.next;
         current.next.prev = newNode;
         current.next = newNode;
         newNode.prev = current;
         ++size;
      } 
    return true;
  }  
  
  // Time O(1)
  public ListNode<T> removeFirst() {
      ListNode<T> deletedNode = null;
      if(size == 0) 
        return deletedNode;
      else if(size == 1) {
       deletedNode = head; 
       head = tail = null;
       size = 0; 
      } else {
        deletedNode = head; 
        head = head.next;
        deletedNode.next.prev = null;
        deletedNode.next = null;
       --size;
      }      
      return deletedNode; 
  }  
  
  
  // Time O(1)
  public ListNode<T> removeLast() {
     ListNode<T> deletedNode = null;
     if(size == 0)
       return deletedNode;
     else if(size == 1)
       return removeFirst();
     else {
          deletedNode = tail;
          tail = tail.prev;
          deletedNode.prev = null;
          tail.next = null;
          --size;
     }
     return deletedNode;
  }  
  
  public void display() {
    if(size == 0) {
      System.out.println("List is Empty"); 
      return;
    }  
    ListNode<T> current = head;
    for(int index = 0; index < size; index++) {
      System.out.print(current.val + "->");
      current = current.next;
    }
     System.out.println();
  }  
  
}  

class Solution {
  public static void main(String[] args) {
    DoublyLikedList<Integer> dll = new DoublyLikedList<Integer>();
    dll.addFirst(20);
    dll.addFirst(10);
    dll.addLast(40);
    dll.addLast(50);
    dll.add(30, 2);
    dll.add(35, 3);
    dll.display();
    System.out.println("Deleted First: " + dll.removeFirst().val);
    dll.display();
    System.out.println("Deleted Last: " + dll.removeLast().val);
    dll.display();
  }
}

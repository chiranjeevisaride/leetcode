import java.io.*;
import java.util.*;


class ListNode<T> {
  T value;
  ListNode<T> prev, next;
  ListNode(T value) {
    this.value = value;
    this.prev = this.next = null;
  }  
} 

class DoublyLinkedList<T> {

  int size;
  ListNode<T> head, tail;

  DoublyLinkedList() {
    this.size = 0;
    this.head = tail = null;
  }  

  public int size() {
    return this.size;
  }  

  public boolean isEmpty() {
    return this.size == 0 ? true : false;
  }  

  // Time - O(1)
  public void addFirst(T value) {
    ListNode<T> newNode = new ListNode<T>(value);
    if(isEmpty()) {
      head = tail = newNode;
    } else {
       newNode.next = head;
       head = newNode;
       newNode.prev = head;
    }  
    ++size;  
  }  

  // Time - O(1)
  public void addLast(T value) {
     ListNode<T> newNode = new ListNode<T>(value);
     if(isEmpty()) {
        addFirst(value);   
     } else {
       tail.next = newNode;
       newNode.prev = tail;
       tail = newNode;
       ++size; 
     }  
  }  

   // Time - O(1)
  public void add(T value) {
      addLast(value);
  }  


 // Time - O(n)
  public void add(T value, int pos) {
    if(pos == 0) addFirst(value);
    else if(pos == size() - 1) addLast(value);
    else {
      ListNode<T> currentNode = head;
      ListNode<T> newNode = new ListNode<T>(value);
      for(int index = 0; index < pos - 1; index++) {
          currentNode = currentNode.next;
      } 
      newNode.prev = currentNode;
      newNode.next = currentNode.next;
      currentNode.next.prev = newNode;
      currentNode.next = newNode;
      ++size;
    }     
  }  

  // Time - O(1)
  public ListNode<T> remove() {
    return removeLast();
  }  

  // Time - O(1)
  public ListNode<T> removeFirst() {
     ListNode<T> deletedNode = head;
     if(!isEmpty()) {
        head = head.next;
        head.prev = null;
        deletedNode.next = null;
     }  
     --size;
     return deletedNode;
  }  

  // Time - O(1)
  public ListNode<T> removeLast() {
     ListNode<T> deletedNode = tail;
     if(!isEmpty()) {
        tail = tail.prev;
        tail.next = null;
        deletedNode.prev = null;
     } 
     --size;
     return deletedNode;
  }

 // Time - O(n)
  public ListNode<T> remove(int pos) {
    ListNode<T> deletedNode = null;
    if(pos == 0)
     return removeFirst();
    else if(pos == size() - 1)
     return removeLast();
    else {
      ListNode<T> currentNode = head;
      for(int index = 0; index < pos - 1; index++) {
          currentNode = currentNode.next;
      } 
      deletedNode = currentNode.next;
      deletedNode.next.prev = currentNode;
      currentNode.next = deletedNode.next;
      deletedNode.prev = null;
      deletedNode.next = null;
      --size;
    } 
    return deletedNode; 
  }  
  
  public ListNode<T> remove(T value, int pos) {
    ListNode<T> deletedNode = null;
    return deletedNode;
  }

  public void display() {
    if(isEmpty())
      System.out.println("List is Empty");
    else {
      ListNode<T> temp = head;
      for(int index = 0; index < size(); index++) {
          System.out.print(temp.value + " <-> ");
          temp = temp.next;
      }
    } 
     System.out.println(); 
  }  
 
}  

class Solution {

  public static void main(String[] args) {
      DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
      dll.addFirst(10);
      dll.addFirst(20);
      dll.addLast(30);
      dll.add(40, 1);
      dll.display();
      dll.removeFirst();
      dll.display();
      dll.removeLast();
      dll.display();
      dll.addLast(50);
      dll.addLast(60);
      dll.display();
      dll.remove(1);
      dll.display();
  }

}

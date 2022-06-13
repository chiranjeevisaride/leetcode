import java.io.*;
import java.util.*;

/*

Time Complexity 

insert at start or end - O(1)
delete at start - O(1)
delete last - O(n)
delete or insert at postion n - O(n)
searh - O(n)
display - O(n)

Space Complexity
Insertion - O(n)
Deletion - O(n)
Search - O(n)
Display - O(n)

*/


class Node<T> {
    T data;
    Node<T> next;
    Node(T data) {
      this.data = data;
      this.next = null;
    }  
}  


class SinglyLinkedList<T> {

  int size;
  Node<T> head, tail;

  SinglyLinkedList() {
    this.size = 0;
    head = tail = null;
  }  

  public void add(T data) {
    addFirst(data);
  } 

  public void addFirst(T data) {
    Node<T> newNode = new Node<T>(data);
    if(isEmpty()) {
        head = tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }  
    ++size;  
  } 

  public void addLast(T data) {
    if(isEmpty())
      addFirst(data);
    else {
      Node<T> newNode = new Node<T>(data);
      tail.next = newNode;
      tail = newNode;
      ++size;
    }    
  }

  public void add(T data, int pos) {
    if(pos == 0)
      addFirst(data);
    else if(pos == size() - 1)
     addLast(data); 
    else {
      Node<T> newNode = new Node<T>(data);
      Node<T> temp = head;
      for(int index = 0; index < pos - 1; index++) {
          temp = temp.next;
      }  
      newNode.next = temp.next;
      temp.next = newNode;
      ++size;
    }    
  }

  public Node<T> remove() {
    Node<T> deletedNode = null;
    if(isEmpty()) {
      System.out.println("List is empty");
      return deletedNode;
    } else {
       return removeLast();
    }   
  }

  public Node<T> removeFirst() {
    Node<T> deletedNode = null;
    if(isEmpty()) 
      return deletedNode;
    else {
      --size;
      if(size() == 1) {
        deletedNode = head;
        head = tail = null;
        return deletedNode;
      } else {
        deletedNode = head;
        head = head.next;
        deletedNode.next = null;
        return deletedNode;
      } 
    }     
  }

  public Node<T> removeLast() {
    Node<T> deletedNode = null;
    // 1 - > 2 -> 3
    if(isEmpty()) return deletedNode;
    else if(size() == 1) return removeFirst();
    else {
      --size;
      int len = size();
      Node<T> temp = head;
      for(int index = 0; index < len - 1; index++) {
        temp = temp.next;
      } 
      deletedNode = temp.next;
      tail = temp;
      deletedNode.next = null;
      return deletedNode;
    }
  }

  public Node<T> remove(int pos) {
    if(pos == 0)
     return removeFirst();
    else if(pos == size() - 1)
     return removeLast();
    else {
      --size;
      Node<T> temp = head;
      for(int index = 0; index < pos - 1; index++) {
        temp = temp.next;
      }  
      Node<T> deletedNode = temp.next;
      temp.next = deletedNode.next;
      deletedNode.next = null;
      return deletedNode;
    }    
  }

  public boolean isEmpty() {
    return this.size > 0 ? false : true;
  }   

  public int size() {
    return this.size;
  }  

  public void display() {
    if(isEmpty()) {
      System.out.println("List is Empty");
  }  else {
     int len = size();
     Node<T> temp = head;
     for(int index = 0; index < len; index++) {
        System.out.print(temp.data + " -> ");
        temp = temp.next;
     }  
  } 
    System.out.println(); 
  }  
}  

class Solution {
  public static void main(String[] args) {
    SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
    sll.addFirst(10);
    sll.addFirst(20);
    sll.display();
    sll.addLast(30);
    sll.display();
    sll.add(50, 1);
    sll.display();
    sll.removeFirst();
    sll.display();
    sll.removeLast();
    sll.display();
    sll.addLast(11);
    sll.display();
    sll.remove(1);
    sll.display();
  }
}

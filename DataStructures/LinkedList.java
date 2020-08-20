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
  T value;
  Node<T> next;
  Node(T value) {
   this.value = value;
   this.next = null; 
  }  
}  


class Solution<T> {
     
   private Node<T> head;
   private Node<T> tail;
   private int size;
  
   Solution() {
      head = null;
      tail = null;
      size = 0;
   }
  
  public void display() {
    Node<T> current = head;
    for(int i = 1; i <= size; i++) { 
      System.out.println(current.value);
      current = current.next;
    }  
  }  
  
  public int size() {
   return size; 
  }  
  
  public boolean isEmpty() {
   return size == 0 ? true : false; 
  } 
  
  // Time - O(1)
  public boolean add(T value) {
    Node<T> new_node = new Node<T>(value);
    if(size == 0) { 
      head = tail = new_node;
    } else {
      tail.next = new_node;
      tail = new_node;
    }   
      ++size; 
     return true;
  } 
  
  
  public boolean addLast(T value) {
    return add(value); 
  }  
  
  public boolean addFirst(T value) {
    Node<T> new_node = new Node<T>(value);
    new_node.next = head;
    if(size == 0) { 
      head = tail = new_node;
    } else {
      head = new_node;
    }   
      ++size; 
     return true;
  } 
  
  
  
  public boolean addAtIndex(int index, T value) {
    if(index < 0 || index > size()) return false;
    if(index == 0)
       return addFirst(value);
    else if(index == size())
      return add(value);
    else {
       Node<T> new_node = new Node<T>(value);
       Node<T> node = head;
       for(int currentIndex = 0; currentIndex < index - 1; currentIndex++){
          node = node.next;
       }
         new_node.next = node.next;
         node.next = new_node;
         ++size;
    }  
    return true;
  }  
  
  
  // Time - O(n)
  public Node<T> get(int index) {
    Node<T> node = head;
    if(isEmpty() || index > size() || index < 0) return tail.next;
     int currentIndex = 0;
      while(currentIndex++ != index) {
      node = node.next;
    } 
    return node;
  }  
  
  // Time - O(1) at beginning 
  public Node<T> removeFirst() {
     Node<T> deletedNode = null;
     if(isEmpty()) return deletedNode;
     else if(size() == 1) {
        head = tail = null;
        size = 0;
     } else {
       deletedNode = head;
       head = head.next;
       deletedNode.next = null;
       --size;
     }   
    return deletedNode;
  }  

  public Node<T> removeLast() {
     Node<T> deletedNode = null;
     if(isEmpty()) return null;
     else if(size() == 1) {
       return removeFirst();
     } else {
       Node<T> node = head;
       for(int currentIndex = 0; currentIndex < size() - 2; currentIndex++) {
           node = node.next;
       } 
        deletedNode = tail;
        tail = node;
        node.next = null;
        --size;
     }  
     return deletedNode;
  }  
  
  public static void main(String[] args) {
    Solution<Integer> s = new Solution<Integer>();
    s.add(6);
    s.add(10);
    s.addFirst(13);
    s.addFirst(58);
    s.addAtIndex(2, 24);
    System.out.println("Display");
    s.display();
    System.out.println("Size: " + s.size());
    System.out.println("Value at index 4: " + s.get(4).value);
    System.out.println("Delete at first node, deleted: " +     s.removeFirst().value);
    System.out.println("Delete at last node, deleted: " +     s.remove().value);
    System.out.println("Display");
    s.display();
  }
  
}

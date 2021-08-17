import java.io.*;
import java.util.*;

  
class Node {
  int data;
  Node prevNode, nextNode;
  Node(int data) {
    this.data = data;
    this.prevNode = null;
    this.nextNode = null;
  }  
}  
 

class DoublyLinkedList {
  
  Node headNode, tailNode;
  int size;
  
  DoublyLinkedList() {
    this.headNode = null;
    this.tailNode = null;
  }
  
  
  public void insertAtHead(int data) {
    Node newNode = new Node(data);
    newNode.prevNode = null;
    if(headNode != null) {
       newNode.nextNode = headNode;
       headNode.prevNode = newNode;
    } else {
       tailNode = newNode;
    } 
    headNode = newNode;
    size++;
  }
  

  public void insertAtTail(int data) {
    if(isEmpty()) {
      insertAtHead(data);
      return;
    }  
    Node newNode = new Node(data);
    newNode.nextNode = null;
    tailNode.nextNode = newNode;
    newNode.prevNode = tailNode;
    tailNode = newNode;
    size++;
  }
  
  
  public void printList() {
      if(isEmpty()) {
        System.out.println("List is empty"); 
      } else {
        Node tempNode = headNode;
        while(tempNode != null) {
          System.out.print(tempNode.data + " -> ");
          tempNode = tempNode.nextNode; 
        }  
      }
     System.out.println("null");
  }  
  
  public boolean isEmpty() {
   if(size == 0)
     return true;
    return false;
  }  
  
  public Node getHeadNode() {
    return headNode; 
  }  
  
  
  public Node deleteAtHead() {
   if (isEmpty()) return null;
   Node deleted = headNode; 
   headNode = headNode.nextNode;
   if (headNode == null)
        tailNode = null;
   else
        headNode.prevNode = null;
   size--;  
   return  deleted;
  }  
  
  public Node deleteAtTail() {
   if (isEmpty()) return null;
   Node deleted = tailNode; 
   tailNode = tailNode.prevNode;
   if (tailNode == null)
        headNode = null;
   else
       tailNode.nextNode = null;
   size--;
   return deleted; 
  }  
  
}  


class Graph {

  int vertices;
  DoublyLinkedList[] adjList;
  
  
  Graph(int vertices) {
    this.vertices = vertices;
    this.adjList = new DoublyLinkedList[vertices];
    for(int index = 0; index < vertices; index++) {
      this.adjList[index] = new DoublyLinkedList();
    }  
  }  
  
  public void addEdge(int source, int destination) {
    if(source < vertices && destination < vertices) {
       this.adjList[source].insertAtTail(destination);
    }  
  }  
  
  public void printGraph() {
    for(int index = 0; index < vertices; index++) {
      System.out.print(index + " => ");
      Node headNode = this.adjList[index].getHeadNode();
      if(headNode != null) {
        Node tempNode = headNode;
        while(tempNode != null) {
          System.out.print(tempNode.data + " -> ");
          tempNode = tempNode.nextNode; 
        }  
      }
      System.out.println("");
    } 
  }  
}  


class Solution {
  public static void main(String[] args) {
    /*DoublyLinkedList dList = new DoublyLinkedList();
    dList.insertAtTail(3);
    dList.insertAtHead(2);
    dList.insertAtTail(4);
    dList.insertAtHead(1);
    dList.printList();
    dList.deleteAtHead();
    dList.printList();
    dList.deleteAtTail();
    dList.printList();*/
    
    Graph g = new Graph(3);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,2);
    g.printGraph();
    
  }
}

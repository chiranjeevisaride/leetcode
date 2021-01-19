import java.io.*;
import java.util.*;


class QueueDS {
  
  int capacity, front, rear, currrentSize = 0;
  int[] queueArr;
  
  QueueDS(int capacity) {
    this.capacity = capacity;
    this.rear = this.front = 0;
    this.queueArr = new int[capacity];
  }  
  
  public boolean isEmpty() {
    if(size() == 0) return true;
    return false;
  }  
  
  public boolean isFull() {
    return capacity == currrentSize ? true : false;
  }  
  
  public int size() {
    return currrentSize; 
  }
  
  public void add(int element) {
      if(isFull()) {
        System.out.println("Queue is full");
        return;
      }  
     currrentSize++;
     rear = (rear + 1) % capacity;
     queueArr[rear] = element;
  }  
  
  public int remove() {
    if(isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
    } 
    currrentSize--;
    int removed = queueArr[front];
    front = (front + 1) % capacity;
    return removed;
  }  
  
}  

class Solution {
  public static void main(String[] args) {
    QueueDS queue = new QueueDS(5);
     queue.add(0);
     queue.add(1);
     queue.add(2);
     queue.add(3);
     queue.add(4);
     queue.add(5);
     System.out.println("Removed: " + queue.remove());
    
  }
}

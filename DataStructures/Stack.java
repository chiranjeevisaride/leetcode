
import java.io.*;
import java.util.*;


class Stack<V> {
  int maxSize, top;
  V[] arr;
  
  @SuppressWarnings("unchecked")
  Stack(int maxSize) {
    this.maxSize = maxSize;
    this.top = -1;
    arr = (V[]) new Object[maxSize];
  }  
  
  public int size() {
    return top == -1 ? 0 : top + 1; 
  }  
  
  public boolean isEmpty() {
    return top == -1 ? true : false; 
  }  
  
  public void push(V element) {
    if(size() == maxSize) {
      System.out.println("Stack is full");
      return;
    }  
    arr[++top] = element;
  }
  
  public V pop() {
    if(isEmpty()) return null;
    return arr[top--];
  }  
  
  public V peek() {
   return arr[top]; 
  } 
  
}  

class Solution {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>(10);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.pop();
    stack.push(4);
    
    while(!stack.isEmpty()) {
      System.out.println(stack.pop()); 
    }   
  } 
}

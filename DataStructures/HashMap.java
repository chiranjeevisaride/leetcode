

import java.io.*;
import java.util.*;



class HashNode<K,V> {
  K key;
  V value;
  HashNode<K,V> next;
  HashNode(K key, V value) {
    this.key = key;
    this.value = value;
  }   
}  


class HashMap<K,V> {
  
  ArrayList<HashNode<K,V>> bucketList;
  int size, numBuckets;
  
  HashMap() {
     
     this.size = 0;
     this.numBuckets = 10;
     this.bucketList = new ArrayList<>();
     for(int index = 0; index < numBuckets; index++)
       bucketList.add(null);
  }  
  
  private Integer getBucketIndex(K key) {
    int hashCode = key.hashCode();
    int index = hashCode % numBuckets;
    return index;
  }  
  
  public boolean put(K key, V value) {
    HashNode<K,V> newNode = new HashNode<K,V>(key, value);
    int index = getBucketIndex(key);
    HashNode<K, V> head = bucketList.get(index);
    while(head != null) {
        if(head.key.equals(key)) {
          head.value = value; 
          return true;
        }  
        head = head.next;
    }
    head = bucketList.get(index);
    newNode.next = head;
    bucketList.set(index, newNode);
    ++size; 
    
    if((1.0 * size)/numBuckets > 0.7) 
      resize();
    
    return true; 
  }  
  
  public V get(K key) {
    int index = getBucketIndex(key);
    HashNode<K, V> head = bucketList.get(index);
    while(head != null) {
      if(head.key.equals(key))
        return head.value;
      head = head.next;
    }
    return null; 
  }  
  
  public V remove(K key) {
     int index = getBucketIndex(key);
     HashNode<K, V> head = null, prev = null;
     head = bucketList.get(index);
     while(head != null) {
        if(head.key.equals(key)) 
          break;
        prev = head;
        head = head.next;
     } 
     --size;
     if(head == null) return null;
     if(prev == null)
       bucketList.set(index, head.next);
     else
     prev.next = head.next;
     return head.value;
  }  
  
  public int size() {
     return size;
  }  
   
 public boolean isEmpty() {
    return size == 0; 
 }  
  
  
 private void resize() {
   numBuckets = 2 * numBuckets;
   ArrayList<HashNode<K,V>> tempList = bucketList; 
   bucketList = new ArrayList<>();
   for(int index = 0; index < numBuckets; index++)
     bucketList.add(null);
   for(HashNode<K,V> headNode : tempList) {
     while(headNode != null) {
       put(headNode.key, headNode.value); 
       headNode = headNode.next;
     }  
   }  
 }  
  
}  


class Solution {
  public static void main(String[] args) {
    HashMap<Integer, Integer> hMap = new HashMap<>();
    hMap.put(1, 7);
    System.out.println("Size:" + hMap.size());
    System.out.println(hMap.get(1));
    System.out.println(hMap.remove(1));
    System.out.println("Size:" + hMap.size());
    System.out.println(hMap.get(1));
  }
}

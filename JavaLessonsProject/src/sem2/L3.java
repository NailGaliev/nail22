/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2;

import java.util.*;

/**
 *
 * @author Администратор
 */
public class L3 {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(3);
        node.next.next = new Node(4);
        node.next.next.next = new Node(5);
        
        ListNode list2 = new ListNode(node);
        list2.print();
        
        Set<String> words = new TreeSet<>();
        Set<String> words2 = new HashSet<>();
        
        for (String current : words) {
            
        }
        
        
        // array[number] => assoc_array[string]
        
        Map<String, Integer> words_frequency = new TreeMap<>();
        Map<String, Integer> words_frequency2 = new HashMap<>();
        
        words_frequency.put("word1", 1);
        words_frequency.put("word2", 3);
        words_frequency.put("word3", 1);
        words_frequency.put("adsf", 10);
        
        words_frequency.get("word1");
        
        System.out.println(words_frequency);
        
        for (String word : words_frequency.keySet()) {
            int freq = words_frequency.get(word);
            System.out.print(word + " freq is " + freq + "; ");
        }
        System.out.println("\n");
        
        
        
    }
    
    
}


class Node {
    int data;
    Node next;
    
    public Node() {
        this(0, null);
    }
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    
}


class ListNode {
    Node front;

    public ListNode() {
        front = null;
    }
    public ListNode(Node front) {
        this.front = front;
    }
    
    public void add(int elem) {
        if (front == null) {
            front = new Node(elem);
        } else {
            Node current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(elem);
        }
    }
    
    public void print() {
        System.out.print("[");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + "; ");
            current = current.next;
        }
        System.out.println("]");
    }
    
}

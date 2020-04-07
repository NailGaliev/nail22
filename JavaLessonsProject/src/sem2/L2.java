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
public class L2 {

    public static void main(String[] args) {
        Vector<String> test = new Vector<>();
        System.out.println(test.size());
        System.out.println(test.capacity());
        test.add(1+"");
        System.out.println(test.size());
        System.out.println(test.capacity());
        test.add("test2");
        test.add("test2");
        System.out.println(test.size());
        test.add("test3");
        System.out.println(test.size());
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.elementAt(i));
        }
        for (String str : test) {
            
        }
        test.indexOf("test2");
        
        Object [] strs = test.toArray();
        test.trimToSize();
        
        test.add(2, "testMiddle");
        test.removeElementAt(3);
        test.removeElement("test2");
        System.out.println("removed: " + test.remove(1));
//        test.remove(1);
        System.out.println(test.toString());
        
        List<String> al = new ArrayList<>();
        al.add("el1");
        al.add("el2");
        al.add("el3");
        al.add("el4");
        
//        while (al.size() > 0) {
//            
//            if (al.indexOf("el2") >= 0) {
//                
//            } 
//        }
//        
//        while (al.isEmpty()) {
//            al.contains("el3");
//            
//        }
        
        
        Set<String> set = new TreeSet<>(); // O(log n)
        Set<String> set2 = new HashSet<>(); // O(1)
        
        set.add("set2");
        set.add("set2");
        set.add("set1");
        set.add("set3");
        System.out.println(set);
        set.remove("set2");
        set.size();
        set.isEmpty();
        set.clear();
        
        
        Node<String> nodes = new Node<>("first");
        nodes.next = new Node<>("second");
        
        Queue<String> q = new ArrayDeque<>();
        
        q.offer("first");
        q.peek();
        q.remove();
        
        
        Queue<Integer>  ll = new LinkedList<>(); // FIFO
        ll.add(1);
        ll.add(2);
        ll.add(3);
        
        System.out.println(ll);
        Stack<Integer> st = new Stack<>(); //LIFO
        
        while (!ll.isEmpty()) {
            st.push(ll.remove());
        }
        
        while (!st.isEmpty()) {
            ll.add(st.pop());
        }
        System.out.println(ll);
        
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= 10; i++) {
            list.add(i * 10);
        }
        System.out.println(list);
        
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.add(i, 4200);
        }
        System.out.println(list);
        
        
        
        
        
    }
    
    
    static class Node<E> {
        E type;
        Node next;

        Node(E type) {
            this.type = type;
            next = null;
        }
    }
    
}


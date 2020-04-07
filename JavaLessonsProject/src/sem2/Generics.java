/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2;

/**
 *
 * @author Администратор
 */

/*
E - element
K - key
N - number
T - type
V - value
S, U, V, W 
*/
public class Generics<T, U> {
    T type;  // Integer type;
    U type2;

    public Generics(T type, U type2) {
        this.type = type;
        this.type2 = type2;
    }
    
    

    public void setType(T type) {
        this.type = type;
    }
    
    static <W> T get(Generics <W> gen){
        
        
    }
    
    
}

interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

class OrderPair<K, V> implements Pair {

    K key; V value;

    public OrderPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
    
    
    
}

class Util {
    
    
    
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K,V>  p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
    public static <W extends Comparable<W>> void inspect(W w) {
        System.out.println(w);
    }
    
    public static void boxTest(Box<Number> n) {
        
        
    }
    
    
    public static void main(String[] args) {
        Util.boxTest(Box<Integer>);
    }
}



//
//class A {
//    Object id;
//    
//}

class TestGenerics {
    
    public static void main(String[] args) {
        Pair<Object, Number> p1 = new OrderPair<>(123, 123);
        Util.compare(p1, p2);
        
        OrderPair<Integer, String> pair = new OrderPair<>(100, "Hello");
        OrderPair<String, String> pair2 = new OrderPair<>("id100", "Hello");
        
        Generics<Integer, String> gen = new Generics<Integer, String>();
        List<String> list = new ArrayList<>();
        list.add("Hello");
        String s = list.get(0);
        
//        
//        Figure [] figs;
//        figs[0] = new Rectangle();
//        figs[1] = new Circle();
//        
//        for (Figure f : figs) {
//            
//        }
        
    }
}

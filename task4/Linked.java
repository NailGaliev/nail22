import java.util.Iterator;
import java.util.stream.IntStream;

public class Linked {

    private Elem head;
    private int length;

    public Linked(int[] ar) {
        int[] arr = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            arr[i] = ar[ar.length - i - 1];
            if (arr[i] != 0) {
                Elem p = new Elem();
                p.setValue(arr[i]);
                p.setPos(ar.length - 1 - i);
                p.setNext(head);
                this.head = p;
            }
            this.length++;
        }
    }

    public void print() {
        Elem p1 = new Elem();
        p1 = this.head;
        while (p1 != null) {
            System.out.println(p1.getValue());
            p1 = p1.getNext();
        }
    }

    public int[] decode() {
        int[] arr = new int[this.length];
        Elem p = new Elem();
        p = this.head;
        for (int i = 0; i < arr.length; i++) {
            if (p.getPos() == i && p.getNext() != null) {
                arr[i] = p.getValue();
                p = p.getNext();
            } else arr[i] = 0;
        }
        arr[p.getPos()] = p.getValue();
        return arr;
    }

    public void deleteHead() {
        head = head.getNext();
    }
    public void deleteK(int k){
       Elem p5 = head;
        if(p5.getValue() == k){
            p5.setNext(p5.getNext().getNext());
        }

    }

    //сделал универсальный к
    //Удалить последний элемент списка
    //Удалить предпоследний элемент списка(надо самому вводить какой удалить)
    public void delete(int pos) {
        Elem p = new Elem();
        p = this.head;
        while (p != null) {
            if (p.getPos() == pos) {
                if (p == head) {
                    head = p.getNext();
                    p = null;
                }
            }
            if (p.getNext() != null) {
                if (p.getNext().getPos() == pos) {
                    p.setNext(p.getNext().getNext());
                }
            }
            if (p.getPos() == pos && p.getNext() == null) {
                p = null;
            }
            p = p.getNext();
        }
    }

    public int getMax() {
        if (head == null) {
            System.out.println("Пустой");
            return 0;
        }
        int max = head.getValue();
        Elem cur = head;
        while (cur != null) {
            if (max < cur.getValue()) max = cur.getValue();
            cur = cur.getNext();
        }
        return max;
    }
    public long getSum() {
        int sum = 0;
        Elem cur = head;
        while (cur != null) {
            sum += cur.getValue();
            cur = cur.getNext();
        }
        return sum;
    }
    public void insert(int k, int pos) {
        Elem p = new Elem();
        p = this.head;
        while (p != null) {
            if (p.getPos() == pos) {
                p.setValue(k);
                break;
            }
            if (p.getNext() != null) {
                if (pos < p.getNext().getPos()) {
                    Elem p1 = new Elem();
                    p1.setNext(p.getNext());
                    p.setNext(p1);
                    p1.setPos(pos);
                    p1.setValue(k);
                    break;
                }
            }
            if (p.getNext() == null) {
                if (pos > p.getPos()) {
                    Elem p2 = new Elem();
                    p.setNext(p2);
                    p2.setValue(k);
                    p2.setPos(pos);
                    break;
                }
            }
            p = p.getNext();
        }
    }

    }








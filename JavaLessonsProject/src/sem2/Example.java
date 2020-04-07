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
public class Example {
    
}

class Cake {}

class Pie {}

class ApplePie extends Pie {}

class CakeBox {
    private Cake cake;
    
    public void put(Cake cake) {
        this.cake = cake;
    } 
    
    public Cake get() {
        return this.cake;
        
    }
    
}

class PieBox {
    private Pie pie;
    
    public void put(Pie pie) {
        this.pie = pie;
    } 
    
    public Pie get() {
        return this.pie;
    }
    
}

class Box<T> {
    private T pie;
    
    public void put(T pie) {
        
        this.pie = pie;
    } 
    
    public T get() {
        return this.pie;
    }
    
    public static void main(String[] args) {
    }
}




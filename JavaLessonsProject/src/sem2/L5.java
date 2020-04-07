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
public class L5 {
    static void test(List<? extends Animal> list) {
        for(Animal an : list){
            System.out.println(an);
        }
    }
    
    
    static void test2(List<? super Dog> list) {
        for(Object an : list){
            System.out.println(an);
        }
    }
    
    // wildcards
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("an1"));
        animals.add(new Animal("an2"));
        animals.add(new Animal("an3"));
        test(animals);
        
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("an2"));
        dogs.add(new Dog("an3"));
        dogs.add(new Dog("an1"));
        test(dogs);
        
        
    }
}



class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }
    
}
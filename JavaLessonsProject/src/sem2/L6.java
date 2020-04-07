/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Администратор
 */
public class L6 {
    interface CheckPerson {
        boolean test(Person p);
    }
    static void printPersonOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age){
                p.print();
            }
        }
    }
    static void printPersonOlderThan(List<Person> roster, int age, int ageHigh) {
        for (Person p : roster) {
            if (p.getAge() >= age && p.getAge() <= ageHigh){
                p.print();
            }
        }
    }

    static void printPerson(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)){
                p.print();
            }
        }
    }

    static void printPersonWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)){
                p.print();
            }
        }
    }

    static void processPersonWithFunction(
            List<Person> roster, 
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)){
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    static <X, Y> void processPersonWithGenerics(
            List<X> roster, 
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : roster) {
            if (tester.test(p)){
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
    
    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        printPersonOlderThan(roster, 25);
        System.out.println();
        printPersonOlderThan(roster, 25, 40);
        System.out.println();
        
        class CheckPersonProvider implements CheckPerson {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 25
                        && p.getAge() <=40;
            }
            
        }
        System.out.println("\nCheckPersonProvider:");
        CheckPersonProvider check = new CheckPersonProvider();
        printPerson(roster, check);
        
        System.out.println("\nCheckPersonProvider Anonimous class:");
        printPerson(roster, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 25
                        && p.getAge() <=40;
            }
        });
        
        System.out.println("\nCheckPerson Lambda:");
        printPerson(roster, (p) -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 25
                        && p.getAge() <=40);
        
        
        
        System.out.println("\nCheckPerson Lambda Predicate:");
        printPersonWithPredicate(roster, p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 25
                        && p.getAge() <=40);
        
        
        
        System.out.println("\nCheckPerson Lambda Functions:");
        processPersonWithFunction(
                roster, 
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 25
                        && p.getAge() <=40,
                p -> p.getEmail(),
//                email -> {
//                    sendEmail(p);
//                }
                System.out::println // email -> System.out.println(email)
            );
        
        
        
        System.out.println("\nCheckPerson Lambda Function Generics:");
        processPersonWithGenerics(
                roster, 
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 25
                        && p.getAge() <=40,
                p -> p.getGender(),
                System.out::println // email -> System.out.println(email)
            );
        
        System.out.println("\nStream API:");
        roster
            .stream()
            .filter(p -> p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 25
                    && p.getAge() <=40)
            .map(p -> p.getEmail())
            .forEach(Person::print);
        
    }
    
}

class Person {
    enum Sex {
        MALE, FEMALE
    }
    
    String name;
    String email;
    LocalDate birthday;
    Sex gender;

    public Person(String name, String email, LocalDate birthday, Sex gender) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Sex getGender() {
        return gender;
    }

    public int getAge() {
        return birthday.until(LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Person [" + name + ", age = " + getAge() + "]";
    }
    
    void print() {
        System.out.println(toString());
    }
    
    static void print(String text) {
        System.out.println(text);
    }
    
    static List<Person> createRoster() {
        List<Person> roster = new ArrayList<>();
        roster.add(new Person("Ivan", "ivan@bk.ru", LocalDate.of(1992,12,02), Person.Sex.MALE));
        roster.add(new Person("Petr", "petro@bk.ru", LocalDate.of(1989,12,02), Person.Sex.MALE));
        roster.add(new Person("Jonh", "johndoe@bk.ru", LocalDate.of(1976,12,02), Person.Sex.MALE));
        roster.add(new Person("Yulya", "yulya@bk.ru", LocalDate.of(2001,12,02), Person.Sex.FEMALE));
        return roster;
    }
}
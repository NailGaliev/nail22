/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sem2;
import java.util.*;
import java.util.function.*;

/**
 *
 * @author Администратор
 */
public class L5b {
    
    // varargs
    static void test(int a, String... vars){
        for (String var : vars) {
            
        }
        
    }
    
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello, ", "World!");
        System.out.println(list);
        test(5, "asdf", "da");
        
        Operation operation = new Operation() {
            @Override
            public double getResult(double d1, double d2) {
                return d1 + d2;
            }
        };
        
        System.out.println(operation.getResult(2, 1));
        
        Operation operation2 = (d1, d2) -> {
            d1 = 100 * d1;
            d2 = 200 * d2;
            return d1 + d2;
        };
        System.out.println(operation2.getResult(12, 3));
        
        Printer printer = str -> System.out.println(str);
        printer.println("test");
        
        Factorial factorial = value -> {
            int result = 1;
            for (int i = 0; i < value; i++) {
                result *= value;
            }
            return result;
        };
        
        System.out.println(factorial.getResult(5));
        
        
        Predicate<Integer> isZero = value -> value == 0;
        System.out.println(isZero.test(5));
        System.out.println(isZero.test(0));
        
        Consumer<String> print = string -> System.out.println(string);
        print.accept("hi");
        
        Function<Integer, Double> func = a -> Double.valueOf(a);
        func.apply(123);
        
        UnaryOperator<Double> sqrt = d1 -> Math.sqrt(d1);
        System.out.println(sqrt.apply(1.0));
        
        BinaryOperator<Double> pow = (d1, d2) -> Math.pow(d1, d2);
        System.out.println(pow.apply(12.0, 12.0));
        
        
        
        Consumer<String> cons = System.out::println;
        
        CreateHtmlTag<HtmlTag> tags =  HtmlTag::new;
        tags.add("tag");
        System.out.println(tags);
        
    }
    
}

interface CreateHtmlTag<HtmlTag>{
    HtmlTag add(String tag);
}

interface Operation {
    double getResult(double d1, double d2);
}

interface Printer<T> {
    void println(T t);
}

interface Factorial {
    int getResult(int value);
}
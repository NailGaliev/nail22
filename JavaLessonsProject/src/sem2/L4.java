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
public class L4 {
    public static void main(String[] args) {
        String a = "Alice";
        String b = "alice";
        
        System.out.println(a.compareTo(b));
        
        Set<String> list = new TreeSet<>();
        
        list.add("World");
        list.add("Hello");
        
        
        System.out.println(list);
        Set<HtmlTag> tags = new TreeSet<>();
        
        tags.add(new HtmlTag("body"));
        tags.add(new HtmlTag("html"));
        System.out.println(tags);
        
        
        List<HtmlTag> tagList = new ArrayList<>();
        tagList.add(new HtmlTag("br"));
        tagList.add(new HtmlTag("hr"));
        tagList.add(new HtmlTag("a"));
        
        System.out.println(tagList);
        tagList.sort(new Comparator<HtmlTag>() {
            @Override
            public int compare(HtmlTag o1, HtmlTag o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(tagList);
        
        tagList.sort(new HtmlTagCompartor());
        System.out.println(tagList);
        
    }
}

class HtmlTagCompartor implements Comparator<HtmlTag> {

    @Override
    public int compare(HtmlTag o1, HtmlTag o2) {
        return o2.getTag().compareTo(o1.getTag());
    }
}

class HtmlTag implements Comparable<HtmlTag>{
    private String tag;

    public String getTag() {
        return tag;
    }
    
    

    public HtmlTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "<" + tag + ">"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(HtmlTag o) {
        return this.tag.compareTo(o.tag);
    }
}



class Point implements Comparable<Point> {
    
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    @Override
//    public int compareTo(Point o) {
//        if (x < o.x) {
//            return -1;
//        } else if (x > o.x){
//            return 1;
//        } else if (y < o.y) {
//            return -1;
//        } else if (y > o.y) {
//            return 1;
//        } else {
//            return 0;
//        }
//    }

    @Override
    public int compareTo(Point o) {
        if (x != o.x) {
            return x - o.x;
        } else {
            return y - o.y;
        }
    }
    
    
    
    
    
    
    
}
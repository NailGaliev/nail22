import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("fore");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("five");
        list2.add("two");
        list2.add("seven");
        list2.add("fore");
        List l = new List();
        //System.out.println(l.addStars(list));

        //System.out.println(l.removeStars(list));
        System.out.println(l.intersect(list,list2));
    }
}

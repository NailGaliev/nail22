import java.util.ArrayList;

public class List {

    public ArrayList addStars(ArrayList<String> list) {
        for (int i = 1; i < list.size(); i = i + 2) {
            list.set(i, "*");
        }

        return list;
    }

    public ArrayList removeStars(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.remove(i + 1);
        }
        return list;
    }

    public ArrayList intersect(ArrayList<String> list, ArrayList<String> list2) {
        ArrayList l = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list2.contains(list.get(i))) {
                l.add(list.get(i));
            }
        }
        return l;
    }
}











import java.util.Scanner;

public class Main {

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        int [] arr = new int [sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Linked nail = new Linked(arr);
       // nail.print();
        int [] nail1 = nail.decode();
        for (int i = 0; i < nail1.length; i++) {
        //    System.out.print(nail1[i] + " ");
        }
        //System.out.println();
        //nail.deleteHead();

        //nail.print();
       // nail.delete(6);
       // nail.print();

    }
}


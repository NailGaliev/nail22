package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Main {
    public static ArrayList<String> fileReader(File file) throws Exception {
        ArrayList<String> list1 = new ArrayList<>();
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            list1.add(sc.next());

        }
        sc.close();

        return list1;
    }
    public static ArrayList<String> removePlurals(ArrayList<String> list1) {
        Pattern symbol = Pattern.compile("(s[:,. ]|s$)", Pattern.CASE_INSENSITIVE);
        for (int i = 0; i < list1.size(); i++) {
            String text = list1.get(i);
            Matcher finder = symbol.matcher(text);
            if (finder.find()) {
                list1.remove(i);
            }

        }

        return list1;
    }

    public static ArrayList<String> capitalizePlurals(ArrayList<String> list1) {
        Pattern symbol = Pattern.compile("(s[:,. ]|s$)");
        for (int i = 0; i < list1.size(); i++) {
            String text = list1.get(i);
            Matcher finder = symbol.matcher(text);
            if (finder.find()) {
                String first = text.substring(0,1);
                first = first.toUpperCase();
                first += text.substring(1,text.length()-1);
                list1.set(i, first);
            }

        }

        return list1;
    }


    public static void printText(ArrayList<String> list1) {
        Pattern symbol = Pattern.compile("([.])");
        for (String str : list1) {
            Matcher finder = symbol.matcher(str);
            if (finder.find()) {
                System.out.println(str);
            } else System.out.print(str + " ");
        }
    }

    public static void wordCountArrayList(ArrayList<String> list1) {

    }


    public static void main(String[] args) throws Exception {
        File file2 = new File("Text.txt");



    }
}


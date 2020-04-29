package com.company;

import java.util.*;


public class Foods {

    public static Map<String, String> favoriteFoods(Map<String, Map<String, Double>> map, double rating) {

        Map<String, String> out = new TreeMap<>();

        for (Map.Entry<String, Map<String, Double>> entry : map.entrySet()) {
            for (Map.Entry<String, Double> entryFood : entry.getValue().entrySet()) {
                if (entryFood.getValue() >= rating) {
                    if (out.get(entry.getKey()) == null) {
                        out.put(entry.getKey(), entryFood.getKey());
                    } else out.put(entry.getKey(), out.get(entry.getKey()) + " " + entryFood.getKey());
                }
            }
        }
        return out;
    }

        public static void main (String[] args){
            Map<String, Map<String, Double>> ratings = new TreeMap<>();
            Map<String, Double> food1 = new TreeMap<>();
            food1.put("pie", 2.0);
            food1.put("coke", 5.0);
            food1.put("apple", 4.0);
            Map<String, Double> food2 = new TreeMap<>();
            food2.put("aaaa", 2.6);
            food2.put("bbb", 5.0);
            food2.put("cccc", 4.3);
            Map<String, Double> food3 = new TreeMap<>();
            food3.put("dddd", 2.0);
            food3.put("ffff", 5.0);
            food3.put("ggggg", 4.0);
            ratings.put("Alex", food1);
            ratings.put("Boris", food2);
            ratings.put("Clara", food3);
            System.out.println(ratings.values());
            System.out.println(favoriteFoods(ratings, 3.0).entrySet());

        }
    }


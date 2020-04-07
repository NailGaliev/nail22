import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class L8 {

    public static void main(String[] args) {
        Chains chains = new Chains();
        String in = "стук";
        String out = "слон";
        System.out.println((chains.game(in, out)));
        System.out.println((chains.gameBFS(in, out)));
//        System.out.println((chains.game("муха", "слон")));
//        System.out.println((chains.game("пуск", "джип")));
    }
}

class Chains {

    final static Set<String> dictionary = loadDictionary();
    final static String abc = "абвгдеёжзиёклмнопрстуфхцчшщъыьэюя";
    static int counter = 0;


    public static String game(String in, String out) {
        LinkedList<String> result = new LinkedList<>();
        LinkedList<String> history = new LinkedList<>();
        history.add(in);
        if (game(in, out, result, history)) {
            System.out.println("Длина цепочки: " + result.size());
            return result.toString();
        } else return "Не найдено цепочек.";
    }


    private static boolean game(String in, String out, LinkedList<String> result, LinkedList<String> history) {
        if (in.equals(out)) {
            return true;
        } else {
            LinkedList<String> words = getWordList(in, new TreeSet<>(history));
            history.addAll(words);
//            words.sort(Comparator.comparingInt((String s)->{
//                int count = 0;
//                for (int i = 0; i < s.length(); i++) {
//                    if (s.charAt(i) == out.charAt(i)) count++;
//                }
//                return count;
//            }).reversed());
            System.out.println(String.format("%s => %s%n", in, words.toString()));
            for (String word : words) {
                if (game(word, out, result, history)) {
                    result.addFirst(word);
                    return true;
                }

            }
        }
        return false;
    }

    public static String gameBFS(String in, String out) {
        Map<String, String> history = new LinkedHashMap<>(); //TreeMap HashMap
        history.put(in, null);
        LinkedList<String> queue = new LinkedList<>();
        queue.add(in);
        List<String> result = gameBFS(in, out, queue, history);
        if (result.isEmpty()) return "Пустое множество.";
        else return result.toString();
    }

    private static List<String> gameBFS(String in,
                                        String out,
                                        Queue<String> queue,
                                        Map<String, String> history) {
//        Map<String, LinkedList<String>>
        while (!queue.isEmpty()) {
            String current = queue.poll();
            LinkedList<String> words = getWordList(current, history.keySet());
            System.out.println(String.format("%s => %s%n", current, words.toString()));
            for (String word : words) {
                history.put(word, current);
                if (word.equals(out)) {
                    LinkedList<String> result = new LinkedList<>();


                }
            }
            queue.addAll(words);
        }
        return null;
    }

    public static Set<String> loadDictionary() {
        Set<String> dict = new TreeSet<>();
        try {
            FileReader file = new FileReader("dict_len4.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                dict.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dict;
    }

    // стук => стул, сток
    private static LinkedList<String> getWordList(String in, Set<String> history) {
        LinkedList<String> wordVars = new LinkedList<>();
        for (int i = in.length() - 1; i >= 0; i--) {
            for (int j = 0; j < abc.length(); j++) {
                if (in.charAt(i) == abc.charAt(j)) {
                    continue;
                }
                char[] temp = in.toCharArray();
                temp[i] = abc.charAt(j);
                if (dictionary.contains(String.valueOf(temp)) &&
                        !history.contains(String.valueOf(temp))
                ) {
                    wordVars.add(String.valueOf(temp));
                }
            }
        }
        return wordVars;
    }


}

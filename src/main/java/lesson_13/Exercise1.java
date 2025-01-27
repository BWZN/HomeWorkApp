package lesson_13;

import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {
        String[] words = {"test1", "test1", "test2", "test2", "test3", "test4", "test4", "test5", "test6", "test5", "test8", "test11"};
        Set<String> uniqueEle = new HashSet<>(Arrays.asList(words));
        System.out.println(uniqueEle);

        Map<String, Integer> wordCnt = new HashMap<>();
        for (String word : words) {
            int cnt = wordCnt.getOrDefault(word, 0);
            wordCnt.put(word, cnt + 1);
        }
        System.out.println(wordCnt);
    }
}

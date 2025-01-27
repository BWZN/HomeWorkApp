package lesson_13;

import java.util.*;

public class Exercise2 {
    static class PhoneDirectory {
        private final Map<String, List<String>> directory = new HashMap<>();

        public void add(String lastName, String phoneNumber) {
            if (!directory.containsKey(lastName)) {
                directory.put(lastName, new ArrayList<>());
            }
            directory.get(lastName).add(phoneNumber);
        }

        public List<String> get(String lastName) {
            return directory.getOrDefault(lastName, Collections.emptyList());
        }
    }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Test1", "1234567890");
        phoneDirectory.add("Test2", "12345678901");
        phoneDirectory.add("Test1", "123456789012");
        phoneDirectory.add("Test3", "1234567890123");
        phoneDirectory.add("Test4", "12345678901234");
        phoneDirectory.add("Test5", "");

        System.out.println(phoneDirectory.get("Test1"));
        System.out.println(phoneDirectory.get("Test2"));
        System.out.println(phoneDirectory.get("Test3"));
        System.out.println(phoneDirectory.get("Test4"));
        System.out.println(phoneDirectory.get("Test5"));
        System.out.println(phoneDirectory.get("Test6"));
    }
}

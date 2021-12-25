package ru.geekbrains.homework;

import java.util.HashMap;
import java.util.Map;

public class MyMain {
    public static void main(String[] args) {
        //Exercise1
        String[] arr = {"апельсин", "манго", "лимон", "лайм", "грейпфрут", "памело", "манго", "манго", "личи", "дуриан", "яблоко", "апельсин", "апельсин", "яблоко", "манго", "манго"};
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            Integer i = map.getOrDefault(s, 0);
            map.put(s, i + 1);
        }
        System.out.println(map.keySet());
        System.out.println(map);


        //Exercise2
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "89299923233");
        phoneBook.add("Иванов", "89292923232");
        phoneBook.add("Иванов", "89293434344");
        phoneBook.add("Петров", "89299923678");
        phoneBook.add("Петров", "89299923678");
        phoneBook.add("Петров", "89291923233");
        phoneBook.add("Федоров", "8999999999");

        System.out.println(phoneBook.get("Петров"));
        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Иванов1"));
    }
}

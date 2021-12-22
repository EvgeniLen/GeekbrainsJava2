package ru.geekbrains.homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneBook {
    private Map<String, HashSet<String>> book = new HashMap<>();

    public void add(String name, String phoneNumber) {
        HashSet<String> phoneNumbers = book.getOrDefault(name, new HashSet<>());
        phoneNumbers.add(phoneNumber);
        book.put(name, phoneNumbers);
    }

    public HashSet<String> get(String name) {
        return book.getOrDefault(name, new HashSet<>());
    }
}

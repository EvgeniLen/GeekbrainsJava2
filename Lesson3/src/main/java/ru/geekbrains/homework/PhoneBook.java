package ru.geekbrains.homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> book = new HashMap<>();

    public void add(String name, String phoneNumber) {
        Set<String> phoneNumbers = book.getOrDefault(name, new HashSet<>());
        phoneNumbers.add(phoneNumber);
        book.put(name, phoneNumbers);
    }

    public Set<String> get(String name) {
        return book.getOrDefault(name, new HashSet<>());
    }
}

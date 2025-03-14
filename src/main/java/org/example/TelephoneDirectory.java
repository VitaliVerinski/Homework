package org.example;
import java.util.*;

public class TelephoneDirectory {
    private final Map<String, List<Integer>> telephoneDirectory;

    public TelephoneDirectory() {
        telephoneDirectory = new HashMap<>();
    }

    public void add(String surname, int phoneNumber) {
        List<Integer> phoneNumbers = telephoneDirectory.getOrDefault(surname, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        telephoneDirectory.put(surname, phoneNumbers);
    }

    public List<Integer> get(String surname) {
        return telephoneDirectory.getOrDefault(surname, Collections.emptyList());
    }
}

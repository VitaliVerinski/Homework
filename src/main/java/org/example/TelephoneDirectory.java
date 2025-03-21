package org.example;
import java.util.*;


public class TelephoneDirectory {
    private Map<String, List<Integer>> telephoneDirectory;
    private Map<Integer, String> phoneToSurname;

    public TelephoneDirectory() {
        telephoneDirectory = new HashMap<>();
        phoneToSurname = new HashMap<>();
    }

    public boolean add(String surname, Integer phoneNumber) {
        if (phoneToSurname.containsKey(phoneNumber)) {
            System.out.println("Ошибка: номер " + phoneNumber + " уже принадлежит " + phoneToSurname.get(phoneNumber));
            return false;
        }
        telephoneDirectory.putIfAbsent(surname, new ArrayList<>());
        List<Integer> numbers = telephoneDirectory.get(surname);
        if (!numbers.contains(phoneNumber)) {
            numbers.add(phoneNumber);
            phoneToSurname.put(phoneNumber, surname);
            return true;// Запоминаем, к какой фамилии принадлежит номер
        } else {
            System.out.println("Ошибка: номер " + phoneNumber + " уже добавлен для " + surname);
            return false;
        }
    }

    public List<Integer> get(String surname) {
        return telephoneDirectory.getOrDefault(surname, Collections.emptyList());
    }
}

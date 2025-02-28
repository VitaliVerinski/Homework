package org.example;
import java.util.Arrays;

public class Task2 {
    private String name;
    private String date;
    private String manufacturer;
    private String country;
    private double price;
    private boolean reservation;

    public Task2(String _name, String _date, String _manufacturer,
                 String _country, double _price, boolean _reservation) {
        this.name = _name;
        this.date = _date;
        this.manufacturer = _manufacturer;
        this.country = _country;
        this.price = _price;
        this.reservation = _reservation;
    }

    public void info() {
        System.out.println("Название: " + name +" Дата производства: " + date + " Производитель: " + manufacturer
        + " Страна происхождения: " + country + " Цена: " + price + " руб." + " Состояние бронирования: " + reservation);
    }

    public static void main(String[] args) {
        Task2[] products = new Task2[5];
        products[0] = new Task2 ("Телевизор.", "27.02.2025", "Горизонт.",
                "Беларусь.", 600.35, false);
        products[1] = new Task2 ("Ноутбук.", "22.01.2025", "Huawei.",
                "Китай.", 800.17, false);
        products[2] = new Task2 ("Телефон.", "22.02.2025", "Samsung.",
                "Корея.", 345.35, true);
        products[3] = new Task2 ("Пылесос.", "10.01.2025", "Huawei.",
                "Корея.", 354.35, true);
        products[4] = new Task2 ("Часы.", "16.01.2025", "Huawei.",
                "Китай.", 100.68, false);
        for (Task2 Task2 : products) {
           Task2.info();

        }
    }
}

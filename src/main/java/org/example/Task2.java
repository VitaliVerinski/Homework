package org.example;

public class Task2 {

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product ("Телевизор.", "27.02.2025", "Горизонт.",
                "Беларусь.", 600.35, false);
        products[1] = new Product ("Ноутбук.", "22.01.2025", "Huawei.",
                "Китай.", 800.17, false);
        products[2] = new Product ("Телефон.", "22.02.2025", "Samsung.",
                "Корея.", 345.35, true);
        products[3] = new Product ("Пылесос.", "10.01.2025", "Huawei.",
                "Корея.", 354.35, true);
        products[4] = new Product ("Часы.", "16.01.2025", "Huawei.",
                "Китай.", 100.68, false);
        for (Product Product : products) {
           Product.info();
        }

        Park.Attraction attraction1 = new Park.Attraction("Супер 8", " 12.00 - 19.00", 13.62);
            attraction1.infoAttraction();
            Park.Attraction attraction2 = new Park.Attraction("Колесо обозрения", " 11.00 - 19.00", 10.55);
            attraction2.infoAttraction();
        }
    }

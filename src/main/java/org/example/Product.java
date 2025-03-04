package org.example;

    public class Product {
        public String name;
        public String date;
        public String manufacturer;
        public String country;
        public double price;
        public boolean reservation;

        public Product(String name, String date, String manufacturer,
                       String country, double price, boolean reservation) {
            this.name = name;
            this.date = date;
            this.manufacturer = manufacturer;
            this.country = country;
            this.price = price;
            this.reservation = reservation;
        }

        public void info() {
            System.out.println("Название: " + name + "Дата производства: " + date + "Производитель: " + manufacturer
            +"Страна происхождения: " + country + "Цена: " + price + " руб." + "Состояние бронирования: " + reservation);

        }
    }


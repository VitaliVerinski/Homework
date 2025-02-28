package org.example;

    public class Product {
        public String name;
        public String date;
        public String manufacturer;
        public String country;
        public double price;
        public boolean reservation;

        public Product(String _name, String _date, String _manufacturer,
                       String _country, double _price, boolean _reservation) {
            this.name = _name;
            this.date = _date;
            this.manufacturer = _manufacturer;
            this.country = _country;
            this.price = _price;
            this.reservation = _reservation;
        }

        public void info() {
            System.out.println("Название: " + name);
            System.out.println("Дата производства: " + date);
            System.out.println("Производитель: " + manufacturer);
            System.out.println("Страна происхождения: " + country);
            System.out.println("Цена: " + price + " руб.");
            System.out.println("Состояние бронирования: " + reservation);
        }

        public static void main(String[] args) {
            Product product1 = new Product("Телевизор", "27.02.2025", "Горизонт",
                    "Беларусь", 600.35, false);
            product1.info();
        }
    }


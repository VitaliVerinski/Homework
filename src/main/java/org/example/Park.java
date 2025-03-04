package org.example;

public class Park {
    public String name;
    public String time;
    public double count;

    public Park (String name, String time, double count) {
        this.name = name;
        this.time = time;
        this.count = count;

    }

    public static class Attraction {
        public String nameAttraction;
        public String timeAttraction;
        public double countAttraction;

        public Attraction(String _nameAttraction, String _timeAttraction, double _countAttraction) {
            this.nameAttraction = _nameAttraction;
            this.timeAttraction = _timeAttraction;
            this.countAttraction = _countAttraction;
        }

        public void infoAttraction() {
            System.out.println("название аттракциона " + nameAttraction + " время работы "
                    + timeAttraction + " Стоимость " + countAttraction);

        }
    }
    public static void main (String[] args) {
        Attraction attraction1 = new Attraction("Супер 8", " 12.00 - 19.00", 13.62);
        attraction1.infoAttraction();
        Attraction attraction2 = new Attraction("Колесо обозрения", " 11.00 - 19.00", 10.55);
        attraction2.infoAttraction();
    }

}

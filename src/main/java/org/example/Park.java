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

}

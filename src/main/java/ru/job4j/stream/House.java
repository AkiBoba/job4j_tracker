package ru.job4j.stream;

public class House {
    private String type;
    private boolean brick;
    private boolean wooden;
    private int sections;
    private int floor;
    private int nomber;
    private int age;

    static class Builder {
        private String type;
        private boolean brick;
        private boolean wooden;
        private int sections;
        private int floor;
        private int nomber;
        private int age;

        Builder buildType (String type) {
            this.type = type;
            return this;
        }

        Builder buildBrick (boolean brick) {
            this.brick = brick;
            return this;
        }

        Builder buildWooden (boolean wooden) {
            this.wooden = wooden;
            return this;
        }

        Builder buildSections (int sections) {
            this.sections = sections;
            return this;
        }
        Builder buildFloor (int floor) {
            this.floor = floor;
            return this;
        }
        Builder buildNomber (int nomber) {
            this.nomber = nomber;
            return this;
        }
        Builder buildAge (int age) {
            this.age = age;
            return this;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "type='" + type + '\'' +
                    ", brick=" + brick +
                    ", wooden=" + wooden +
                    ", sections=" + sections +
                    ", floor=" + floor +
                    ", nomber=" + nomber +
                    ", age=" + age +
                    '}';
        }
    }

    House build() {
        House house = new House();
        house.type = type;
        house.brick = brick;
        house.wooden = wooden;
        house.sections = sections;
        house.floor = floor;
        house.nomber = nomber;
        house.age = age;
        return house;
    }

    public static void main(String[] args) {
        Builder house = new Builder().buildType("Live")
                .buildBrick(true)
                .buildWooden(false)
                .buildSections(1)
                .buildFloor(3)
                .buildNomber(1)
                .buildAge(100);
        System.out.println(house);
    }

}

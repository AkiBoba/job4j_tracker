package ru.job4j.ooa;

/**
 * @author Vladimir Likhachev
 */
public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        if (!name.equals("A380")) {
            System.out.println("Количество двигателей равно: " + COUNT_ENGINE);
        } else {
            System.out.println("Количество двигателей равно: " + 4);
        }
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}

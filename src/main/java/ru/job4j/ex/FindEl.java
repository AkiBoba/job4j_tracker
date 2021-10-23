package ru.job4j.ex;

/**
 * @author Vladimir Likhachev
 */
public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl < 0) {
            throw new ElementNotFoundException("Element Not Found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"t1", "t2", "t3"};
        try {
            indexOf(arr, "t0");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
package ru.job4j.pojo;

/**
 * @author Vladimir Likhachev
 */
public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int ind = 0; ind < products.length; ind++) {
            if (ind == index) {
                products[ind] = null;
                if (ind != products.length - 1) {
                    products[ind] = products[ind + 1];
                }
                if (ind != products.length - 1) {
                    products[ind] = products[ind + 1];
                }
            }
        }
        products[products.length - 1] = null;
        return products;
    }
}

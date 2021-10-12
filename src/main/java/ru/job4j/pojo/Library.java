package ru.job4j.pojo;

/**
 * @author Vladimir Likhachev
 */
public class Library {
    public static void main(String[] args) {
        Book book00 = new Book("book00", 100);
        Book book01 = new Book("book01", 105);
        Book book02 = new Book("Clean code", 200);
        Book book03 = new Book("book03", 150);
        Book[] books = new Book[4];
        books[0] = book00;
        books[1] = book01;
        books[2] = book02;
        books[3] = book03;

        for (int index = 0; index < 4; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPages());
        }

        System.out.println("Replace 0 and 3");
        Book tmpBook = new Book(books[0].getName(), books[0].getPages());
        books[0].setName(books[3].getName());
        books[0].setPages(books[3].getPages());
        books[3].setName(tmpBook.getName());
        books[3].setPages(tmpBook.getPages());

        for (int index = 0; index < 4; index++) {
            Book book = books[index];
            System.out.println(book.getName() + " - " + book.getPages());
        }
        System.out.println("Books name is Clean code");
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPages());
            }
        }
    }
}

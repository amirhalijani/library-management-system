package model;

public class Book {
    private static int idCounter = 1;
    private int id;
    String title;
    String author;
    int quantity;

    public Book(String title, String author, int quantity) {
        this.id = idCounter++;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }
}
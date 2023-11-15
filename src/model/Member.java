package model;

public class Member {
    private static int idCounter = 1;
    private int id;
    String name;

    public Member(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
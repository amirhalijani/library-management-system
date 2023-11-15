package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private Map<Integer, Book> borrowedBooks;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.borrowedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.getId() == bookId);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void removeMember(int memberId) {
        members.removeIf(member -> member.getId() == memberId);
    }

    public void borrowBook(int bookId, int memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book != null && member != null && book.quantity > 0) {
            borrowedBooks.put(book.getId(), book);
            book.quantity--;
            System.out.println(member.name + " borrowed " + book.title);
        } else {
            System.out.println("Borrowing failed. Please check book and member information.");
        }
    }

    public void returnBook(int bookId) {
        Book book = borrowedBooks.get(bookId);

        if (book != null) {
            borrowedBooks.remove(bookId);
            book.quantity++;
            System.out.println("Book returned: " + book.title);
        } else {
            System.out.println("Book not borrowed or not found.");
        }
    }

    public void displayAllBooks() {
        for (Book book : books) {
            System.out.println("ID: " + book.getId() + ", Title: " + book.title + ", Author: " + book.author
                    + ", Quantity: " + book.quantity);
        }
    }

    public void displayAllMembers() {
        for (Member member : members) {
            System.out.println("ID: " + member.getId() + ", Name: " + member.name);
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (Book book : borrowedBooks.values()) {
            System.out.println(
                    "ID: " + book.getId() + ", Title: " + book.title + ", Borrower: " + findBorrowerName(book.getId()));
        }
    }

    private Book findBookById(int bookId) {
        return books.stream().filter(book -> book.getId() == bookId).findFirst().orElse(null);
    }

    private Member findMemberById(int memberId) {
        return members.stream().filter(member -> member.getId() == memberId).findFirst().orElse(null);
    }

    private String findBorrowerName(int bookId) {
        return borrowedBooks.containsKey(bookId) ? findMemberById(borrowedBooks.get(bookId).getId()).name : "Unknown";
    }
}

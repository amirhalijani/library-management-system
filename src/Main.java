import java.util.Scanner;

import model.Book;
import model.Library;
import model.Member;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBooks");
            System.out.println("---------------------------");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("\nMembers");
            System.out.println("---------------------------");
            System.out.println("4. Add Member");
            System.out.println("5. Remove Member");
            System.out.println("6. Display All Members");
            System.out.println("\nBorrowed");
            System.out.println("---------------------------");
            System.out.println("7. Borrow Book");
            System.out.println("8. Return Book");
            System.out.println("9. Display Borrowed Books");
            System.out.println("\n0. Exit");
            System.out.println("---------------------------");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter initial quantity: ");
                    int quantity = scanner.nextInt();
                    library.addBook(new Book(title, author, quantity));
                    break;

                case 2:
                    System.out.print("Enter book ID to remove: ");
                    int bookIdToRemove = scanner.nextInt();
                    library.removeBook(bookIdToRemove);
                    break;

                case 3:
                    System.out.println("List of All Books:");
                    library.displayAllBooks();
                    break;

                case 4:
                    System.out.print("Enter member name: ");
                    String memberName = scanner.nextLine();
                    library.addMember(new Member(memberName));
                    break;

                case 5:
                    System.out.print("Enter member ID to remove: ");
                    int memberIdToRemove = scanner.nextInt();
                    library.removeMember(memberIdToRemove);
                    break;

                case 6:
                    System.out.println("List of All Members:");
                    library.displayAllMembers();
                    break;

                case 7:
                    System.out.print("Enter book ID to borrow: ");
                    int bookIdToBorrow = scanner.nextInt();
                    System.out.print("Enter member ID: ");
                    int memberIdToBorrow = scanner.nextInt();
                    library.borrowBook(bookIdToBorrow, memberIdToBorrow);
                    break;

                case 8:
                    System.out.print("Enter book ID to return: ");
                    int bookIdToReturn = scanner.nextInt();
                    library.returnBook(bookIdToReturn);
                    break;

                case 9:
                    System.out.println("List of Borrowed Books:");
                    library.displayBorrowedBooks();
                    break;

                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
import services.LibraryService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Books");
            System.out.println("6. List Members");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    LibraryService.addBook(bookId, title, author);
                    break;
                case 2:
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    LibraryService.addMember(memberId, name);
                    break;
                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    LibraryService.issueBook(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter Book ID to return: ");
                    LibraryService.returnBook(scanner.nextLine());
                    break;
                case 5:
                    LibraryService.listBooks();
                    break;
                case 6:
                    LibraryService.listMembers();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        }
    }
}

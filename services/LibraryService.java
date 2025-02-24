package services;

import database.Database;
import models.Book;
import models.Member;

public class LibraryService {

    public static void addBook(String bookId, String title, String author) {
        Database.books.add(new Book(bookId, title, author));
        System.out.println("Book added successfully!");
    }

    public static void addMember(String memberId, String name) {
        Database.members.add(new Member(memberId, name));
        System.out.println("Member added successfully!");
    }

    public static void issueBook(String bookId) {
        for (Book book : Database.books) {
            if (book.getBookId().equals(bookId) && !book.isIssued()) {
                book.issueBook();
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not found or already issued!");
    }

    public static void returnBook(String bookId) {
        for (Book book : Database.books) {
            if (book.getBookId().equals(bookId) && book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Invalid book ID or book was not issued!");
    }

    public static void listBooks() {
        if (Database.books.isEmpty()) {
            System.out.println("No books available!");
        } else {
            for (Book book : Database.books) {
                System.out.println(book);
            }
        }
    }

    public static void listMembers() {
        if (Database.members.isEmpty()) {
            System.out.println("No members found!");
        } else {
            for (Member member : Database.members) {
                System.out.println(member);
            }
        }
    }
}

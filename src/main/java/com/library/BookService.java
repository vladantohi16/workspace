package com.library;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(Book book) {
        books.remove(book);
    }
    public Book getBookById(int bookId) {
        for (Book book : books) {
            if(book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
    public void printBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getISBN() + "\n");
        }
    }

    public void printFictionBooks() {
        for (Book book : books) {
            if (book instanceof FictionBook) {
                FictionBook fictionBook = (FictionBook) book;
                System.out.println("Title: " + fictionBook.getTitle());
                System.out.println("Author: " + fictionBook.getAuthor());
                System.out.println("ISBN: " + fictionBook.getISBN());
                System.out.println("Fictional Characters: " + fictionBook.getFictionalCharacters());
                System.out.println("Imaginative Frame: " + fictionBook.getImaginativeFrame() + "\n");
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }

}

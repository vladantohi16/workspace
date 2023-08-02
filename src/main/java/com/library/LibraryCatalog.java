package com.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog<T extends Book> {
    private List<T> books = new ArrayList<>();

    public void addBook(T book) {
        books.add(book);
    }
    public void removeBook(T book) {
        books.remove(book);
    }
    public T getBookById(int bookId) {
        for (T book : books) {
            if(book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
    /*public void printBooks() {
        for (T book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getISBN() + "\n");
        }
    }*/

    public void printFictionBooks() {
        for (T book : books) {
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

    public void printHorrorBooks() {
        for (T book: books) {
            if(book instanceof HorrorBook) {
                HorrorBook horrorBook = (HorrorBook) book;
                System.out.println("Title: " + horrorBook.getTitle());
                System.out.println("Author: " + horrorBook.getAuthor());
                System.out.println("ISBN: " + horrorBook.getISBN());
                System.out.println("Genre: " + horrorBook.getGenre() + "\n");
            }
        }
    }
}

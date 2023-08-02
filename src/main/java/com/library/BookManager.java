package com.library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static final String FILE_PATH = "books.txt";
    //private List<T> books = new ArrayList<>();
    public static void writeBooksToFile(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Book book : books) {
                writer.write(book.getBookId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getISBN());
                // Write other properties if needed
                writer.newLine();
            }
            System.out.println("Books have been written to the file.\n");
        } catch (IOException e) {
            System.err.println("Error writing books to the file: " + e.getMessage());
        }
    }
    public static List<Book> readBooksFromFile() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                int bookId = Integer.parseInt(bookData[0]);
                String title = bookData[1];
                String author = bookData[2];
                long ISBN = Long.parseLong(bookData[3]);
                // Read other properties if needed
                Book book = new Book(bookId, title, author, ISBN);
                books.add(book);
            }
        } catch (IOException e) {
            System.err.println("Error reading books from the file: " + e.getMessage());
        }
        return books;
    }
}

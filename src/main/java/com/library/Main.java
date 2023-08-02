package com.library;

import com.library.LibraryException.BookExceptions;

import java.util.ArrayList;
import java.util.List;

import static com.library.BookManager.*;


public class Main {
    public static void main(String[] args) {

        Book book1 = new Book(10,"Maitrey", "Mircea Eliade", 3712618);
        Book book2 = new Book(11,"Lolita", "Vladimir Nabokov", 4892911);
        Book book3 = new Book(12,"Don Quijote de la Manch", "Miguel de Cervantes", 98543953);
        Book book4 = new Book(13,"Idiotul", "F.M. Dostoievski", 123193821);

        System.out.println("----------------------Show books from Library------------------------");
        BookService bookService = new BookService();
        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
        bookService.addBook(book4);

        System.out.println("\nAll books from library:");
        bookService.printBooks();

        System.out.println("----------------------Book removed function------------------------");
        bookService.removeBook(book2);
        System.out.println("Books after removed:");
        bookService.printBooks();

        System.out.println("---------------------Show book by ID-------------------------");

        Book findBookById = bookService.getBookById(9);
        System.out.println("Show all details for book with Id 9.");
        if(findBookById != null) {
            System.out.println("BookId: " + findBookById.getBookId());
            bookService.printBooks();
        } else {
            try {
                throw new BookExceptions("Book not found");
            } catch (BookExceptions e) {
                System.out.println("Book not found, check if the book exists in the library.\n");
            }
        }
        System.out.println("----------------------Finction Books------------------------");

        FictionBook book5 = new FictionBook(14, "Book5", "Book5", 23214142, "Batman","The world of the good");
        FictionBook book6 = new FictionBook(15, "Book6", "Book6", 53218731, "Penguin","The world of the wicked");

        bookService.addBook(book5);
        bookService.addBook(book6);


        bookService.printFictionBooks();
        System.out.println("----------------------Generic------------------------");

        LibraryCatalog<FictionBook> fictionBookLibraryCatalog = new LibraryCatalog<>();
        FictionBook fictionBook1 = new FictionBook(16, "fictionBook1", "fictionBook1", 74328422,"Spiderman", "The world of the good");
        FictionBook fictionBook2 = new FictionBook(17, "fictionBook2", "fictionBook2", 53242432,"Harley Quinn", "The world of the wicked");

        LibraryCatalog<HorrorBook> horrorBookLibraryCatalog = new LibraryCatalog<>();
        HorrorBook horrorBook1 = new HorrorBook(18,"horrorBook1", "horrorBook1", 4736244,"Horror");
        HorrorBook horrorBook2 = new HorrorBook(18,"horrorBook2", "horrorBook2", 4736244,"Horror");

        fictionBookLibraryCatalog.addBook(fictionBook1);
        fictionBookLibraryCatalog.addBook(fictionBook2);
        fictionBookLibraryCatalog.printFictionBooks();

        horrorBookLibraryCatalog.addBook(horrorBook1);
        horrorBookLibraryCatalog.addBook(horrorBook2);
        horrorBookLibraryCatalog.printHorrorBooks();

        System.out.println("------------------------Remove Function----------------------");
        fictionBookLibraryCatalog.removeBook(fictionBook1);
        fictionBookLibraryCatalog.printFictionBooks();

        System.out.println("------------------------Read and write from books.txt----------------------");

        List<Book> booksToWrite = new ArrayList<>();
        booksToWrite.add(new Book(1, "Maitrey", "Mircea Eliade", 1234567890L));
        booksToWrite.add(new Book(2, "Lolita", "Vladimir Nabokov", 9876543210L));

        /*List<FictionBook> booksFictionToWrite = new ArrayList<>();
        booksFictionToWrite.add(new FictionBook(21,"adlss","asdasda",763274234,"askldajskd","askdnasdksa"));*/

        writeBooksToFile(booksToWrite);
        //writeFictionBookToFile(booksFictionToWrite);

        List<Book> booksRead = readBooksFromFile();
        for (Book book : booksRead) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getISBN() + ")");
        }

    }
}
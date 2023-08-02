package com.library;

public class HorrorBook extends Book{

    private String genre;
    public HorrorBook(int bookId, String title, String author, long ISBN, String genre) {
        super(bookId, title, author, ISBN);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

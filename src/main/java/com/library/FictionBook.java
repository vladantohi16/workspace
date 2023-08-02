package com.library;

public class FictionBook extends Book{

    private String fictionalCharacters;
    private String imaginativeFrame;
    public FictionBook(int bookId, String title, String author, long ISBN, String fictionalCharacters, String imaginativeFrame) {
        super(bookId, title, author, ISBN);
        this.fictionalCharacters = fictionalCharacters;
        this.imaginativeFrame = imaginativeFrame;
    }

    public String getFictionalCharacters() {
        return fictionalCharacters;
    }

    public void setFictionalCharacters(String fictionalCharacters) {
        this.fictionalCharacters = fictionalCharacters;
    }

    public String getImaginativeFrame() {
        return imaginativeFrame;
    }

    public void setImaginativeFrame(String imaginativeFrame) {
        this.imaginativeFrame = imaginativeFrame;
    }
}

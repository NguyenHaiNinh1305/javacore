package com.company.entity;

public class BorrowedBook {
    private int numOfBorrowedBook;
    private Book book;

    public BorrowedBook() {
    }

    public int getNumOfBorrowedBook() {
        return numOfBorrowedBook;
    }

    public void setNumOfBorrowedBook(int numOfBorrowedBook) {
        this.numOfBorrowedBook = numOfBorrowedBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

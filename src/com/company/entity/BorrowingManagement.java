package com.company.entity;

import java.util.Arrays;

public class BorrowingManagement {

    private Reader readers;
    private BorrowedBook[] borrowedBooks;

    public BorrowingManagement(Reader readers, BorrowedBook[] borrowedBook) {
        this.borrowedBooks = borrowedBook;
        this.readers = readers;

    }

    public Reader getReaders() {
        return readers;
    }

    public void setReaders(Reader readers) {
        this.readers = readers;
    }

    public BorrowedBook[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(BorrowedBook[] borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "BorrowingManagement{" +
                "readers=" + readers +
                ", borrowedBooks=" + Arrays.toString(borrowedBooks) +
                '}';
    }

    public int getTotalBorredBooks() {
        int total = 0;

        for (int i = 0; i < borrowedBooks.length; i++) {
            total += borrowedBooks[i].getNumOfBorrowedBook();
        }
        return total;
    }
}

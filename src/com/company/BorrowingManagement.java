package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BorrowingManagement {


    private Reader readers;
    public static int numOfBooks;
    private int[] totalOfBooks;
    private Book[] books = new Book[numOfBooks];

    public BorrowingManagement() {
    }



    public BorrowingManagement(Reader readers, int[] totalOfBooks, Book[] books) {
        this.readers = readers;
        this.totalOfBooks = totalOfBooks;
        this.books = books;
    }

    @Override
    public String toString() {
        return "BorrowingManagement{" +
                "readers=" + readers +
                ", totalOfBooks=" + Arrays.toString(totalOfBooks) +
                ", books=" + Arrays.toString(books) +
                '}';
    }

    public Reader getReaders() {
        return readers;
    }

    public void setReaders(Reader readers) {
        this.readers = readers;
    }

    public int[] getTotalOfBooks() {
        return totalOfBooks;
    }

    public void setTotalOfBooks(int[] totalOfBooks) {
        this.totalOfBooks = totalOfBooks;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getTotalBorredBooks(){
        int total = 0;
        for(int i = 0; i< totalOfBooks.length; i++){
            total+= totalOfBooks[i];
        }
        return total;
    }
}

package com.company;

import java.util.Scanner;

public class Util {
    public static int numOfReaders;
    public static int numOfBooks;
    private Book[] books;
    private Reader[] readers;
    private BorrowingManagement borrowingManagement;
    private BorrowingManagement[] borrowingManagements;


    Scanner sc = new Scanner(System.in);

    public Book[] returnBookLibs() {
        System.out.println("Type book quantities you want");
        int n = sc.nextInt();
        books = new Book[n];
        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.setBookId(10000+i);
            book.inputBookInfo();
            books[i] = book;
        }
        return books;
    }

    public void showInfoBook(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }
    }

    public Reader[] returnReaders() {
        System.out.println("nhập thong tin reader");
        int n = sc.nextInt();
        readers = new Reader[n];
        for (int i = 0; i < n; i++) {
            Reader reader = new Reader();
            reader.setReaderID(43675+i);
            reader.inputReaderInfo();
            readers[i] = reader;
        }

        return readers;
    }

    public void showInfoReader(Reader[] readers) {
        for (int i = 0; i < readers.length; i++) {
            System.out.println(readers[i].toString());
        }
    }



    public void borrowBook() {
        borrowingManagements = new BorrowingManagement[readers.length];
        for (int i = 0; i < readers.length; i++) {
            System.out.println("Reader " + i);
            System.out.println("Type number of books you want(<=5)");

            int numOfBook = sc.nextInt();
            BorrowingManagement.numOfBooks = numOfBook;

            Book[] listborrowingbooks = new Book[numOfBook];
            int[] listNumborrowingBook = new int[numOfBook];

            for (int j = 0; j < numOfBook; j++) {
                System.out.println("type book id");
                int id = sc.nextInt();
                Book book = getBookfromId(id);
                listborrowingbooks[j] = book;
                System.out.println("Type quantites book(<=3)");
                int quans = sc.nextInt();
                listNumborrowingBook[j] = quans;

            }
            borrowingManagement = new BorrowingManagement(readers[i], listNumborrowingBook, listborrowingbooks);
            borrowingManagements[i] = borrowingManagement;
        }
    }

    public void showInfoBorrowingBook(){

        for (int i = 0; i < borrowingManagements.length; i++) {
            System.out.println(borrowingManagements[i].toString());

        }
    }

    public Book getBookfromId(int id) {
        for (int i = 0; i < books.length; i++) {

            if (books[i].getBookId() == id) {

                return books[i];
            }

        }
        return null;
    }

    public void sortDesBbmsFromTotalBrdBooks(){

        for(int i = 0; i< borrowingManagements.length-1; i++){
            int minPos = i;
            for(int j = i+1; i<= borrowingManagements.length; j++){
                if(borrowingManagements[j].getTotalBorredBooks() > borrowingManagements[minPos].getTotalBorredBooks()){
                    minPos = j;
                }
            }
            BorrowingManagement temp = borrowingManagements[minPos];
            borrowingManagements[minPos] = borrowingManagements[i];
            borrowingManagements[i] = temp;
        }

    }

    public Reader findReaderFromReadeId(){
        System.out.println("please type Reader Id you want to find");
        int readerID = sc.nextInt();
        for(int i = 0; i< readers.length; i++){
            if(readerID == readers[i].getReaderID()){
                return readers[i];
            }
        }
        return null;
    }

}

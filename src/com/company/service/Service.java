package com.company.service;

import com.company.entity.Book;
import com.company.entity.BorrowedBook;
import com.company.entity.BorrowingManagement;
import com.company.entity.Reader;

import java.util.Scanner;

public class Service {
    private Book[] books;
    private Reader[] readers;
    private BorrowingManagement borrowingManagement;
    private BorrowingManagement[] borrowingManagements;
    Scanner sc;


    public Book[] getBooks() {
        return books;
    }

    public Reader[] getReaders() {
        return readers;
    }

    // return book
    public Book[] returnBookLibs() {
        sc = new Scanner(System.in);
        System.out.println("Type book quantities you want");
        int n = sc.nextInt();
        books = new Book[n];
        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.setBookId(book.getBookId() + i);
            book.inputBookInfo();
            books[i] = book;
        }
        return books;
    }

    public void showInfoBook(Book[] books) {
        if (books == null) {
            System.out.println("Please add book first");
            books = returnBookLibs();
        }
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }
    }

    public Reader[] returnReaders() {
        System.out.println("Enter reader's information");
        System.out.println("Please type number of readers");
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        readers = new Reader[n];
        for (int i = 0; i < n; i++) {
            Reader reader = new Reader();
            reader.setReaderID(reader.getReaderID() + i);
            reader.input();
            readers[i] = reader;
        }
        return readers;
    }

    public void showInfoReader(Reader[] readers) {
        if (readers == null) {
            System.out.println("Please add readers first");
            readers = returnReaders();
        }

        for (int i = 0; i < readers.length; i++) {
            System.out.println(readers[i].toString());
        }
    }

    public void borrowBook() {
        if (readers == null) {
            System.out.println("Please add readers first");
            readers = returnReaders();
        }

        if (books == null) {
            System.out.println("Please add books");
            books = returnBookLibs();
        }
        borrowingManagements = new BorrowingManagement[readers.length];
        for (int i = 0; i < readers.length; i++) {
            System.out.println("Reader " + i);
            System.out.println("Type number of books you want(<=5)");
            int numOfBook = typeNumOfBookWantToBorrow();
            BorrowedBook[] borrowedBooks = new BorrowedBook[numOfBook];
            for (int j = 0; j < numOfBook; j++) {
                Book book = getBookfromId();
                borrowedBooks[j].setBook(book);
                System.out.println("Type quantites per book(<=3)");
                int quans = typeQuantities();
                borrowedBooks[j].setNumOfBorrowedBook(quans);
            }
            borrowingManagement = new BorrowingManagement(readers[i], borrowedBooks);
            borrowingManagements[i] = borrowingManagement;
        }
    }

    public void showInfoBorrowingBook() {
        if (borrowingManagements == null) {
            System.out.println("Have no borrowing books infomation");
            borrowBook();
        }
        for (int i = 0; i < borrowingManagements.length; i++) {
            System.out.println(borrowingManagements[i].toString());
        }
    }

    public int typeNumOfBookWantToBorrow() {
        boolean check = false;
        sc = new Scanner(System.in);
        do {
            int quantites = sc.nextInt();
            if (quantites <= 5) {
                check = true;
                return quantites;
            }
        } while (check == false);
        return 0;
    }

    public int typeQuantities() {
        boolean check = false;
        sc = new Scanner(System.in);
        do {
            int quantites = sc.nextInt();
            if (quantites <= 3) {
                check = true;
                return quantites;
            }
        } while (check == false);
        return 0;
    }

    public void sortDesBbmsFromTotalBrdBooks() {
        for (int i = 0; i < borrowingManagements.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; i <= borrowingManagements.length; j++) {
                if (borrowingManagements[j].getTotalBorredBooks() > borrowingManagements[minPos].getTotalBorredBooks()) {
                    minPos = j;
                }
            }
            BorrowingManagement temp = borrowingManagements[minPos];
            borrowingManagements[minPos] = borrowingManagements[i];
            borrowingManagements[i] = temp;
        }
    }

    public Reader findReaderFromReadeId() {
        if (readers == null) {
            System.out.println("Please add readers first");
            readers = returnReaders();
        }
        System.out.println("please type Reader Id you want to find");
        boolean check = false;
        do {
            sc = new Scanner(System.in);
            int readerID = sc.nextInt();
            for (int i = 0; i < readers.length; i++) {
                if (readerID == readers[i].getReaderID()) {
                    check = true;
                    return readers[i];
                }
            }
            System.out.println("Not found reader id. Please re-type");
        } while (check == false);
        return null;
    }

    public Book getBookfromId() {
        if (books == null) {
            System.out.println("Please add book first");
            books = returnBookLibs();
        }
        boolean check = false;
        do {
            sc = new Scanner(System.in);
            int bookId = sc.nextInt();
            for (int i = 0; i < books.length; i++) {
                if (books[i].getBookId() == bookId) {
                    check = true;
                    return books[i];
                }
            }
            System.out.println("Not found book id. Please re-type");
        } while (check == false);
        return null;
    }

    public BorrowingManagement findBorroredBookByReaderName() {
        if (borrowingManagements == null) {
            borrowBook();
        }
        boolean check = false;
        do {
            sc = new Scanner(System.in);
            String readername = sc.nextLine();
            for (int i = 0; i < borrowingManagements.length; i++) {
                if (borrowingManagements[i].getReaders().getFullName().equalsIgnoreCase(readername)) {
                    check = true;
                    return borrowingManagements[i];
                }
                System.out.println("Can not find this name. Please re-type!");
            }
        } while (check == false);
        return null;
    }

}

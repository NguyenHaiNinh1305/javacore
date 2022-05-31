//package com.company.service;
//
//import com.company.entity.Book;
//import com.company.entity.BorrowedBook;
//import com.company.entity.BorrowingManagement;
//import com.company.entity.Student;
//
//import java.util.Scanner;
//
//public class Service {
//    private Book[] books;
//    private Student[] students;
//    private BorrowingManagement borrowingManagement;
//    private BorrowingManagement[] borrowingManagements;
//    Scanner sc;
//
//
//    public Book[] getBooks() {
//        return books;
//    }
//
//    public Student[] getReaders() {
//        return students;
//    }
//
//    // return book
//    public Book[] returnBookLibs() {
//        sc = new Scanner(System.in);
//        System.out.println("Type book quantities you want");
//        int n = sc.nextInt();
//        books = new Book[n];
//        for (int i = 0; i < n; i++) {
//            Book book = new Book();
//            book.setBookId(book.getBookId() + i);
//            book.inputBookInfo();
//            books[i] = book;
//        }
//        return books;
//    }
//
//    public void showInfoBook(Book[] books) {
//        if (books == null) {
//            System.out.println("Please add book first");
//            books = returnBookLibs();
//        }
//        for (int i = 0; i < books.length; i++) {
//            System.out.println(books[i].toString());
//        }
//    }
//
//    public Student[] returnReaders() {
//        System.out.println("Enter reader's information");
//        System.out.println("Please type number of readers");
//        sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        students = new Student[n];
//        for (int i = 0; i < n; i++) {
//            Student student = new Student();
//            student.setReaderID(student.getReaderID() + i);
//            student.input();
//            students[i] = student;
//        }
//        return students;
//    }
//
//    public void showInfoReader(Student[] students) {
//        if (students == null) {
//            System.out.println("Please add readers first");
//            students = returnReaders();
//        }
//
//        for (int i = 0; i < students.length; i++) {
//            System.out.println(students[i].toString());
//        }
//    }
//
//    public void borrowBook() {
//        if (students == null) {
//            System.out.println("Please add readers first");
//            students = returnReaders();
//        }
//
//        if (books == null) {
//            System.out.println("Please add books");
//            books = returnBookLibs();
//        }
//        borrowingManagements = new BorrowingManagement[students.length];
//        for (int i = 0; i < students.length; i++) {
//            System.out.println("Reader " + i);
//            System.out.println("Type number of books you want(<=5)");
//            int numOfBook = typeNumOfBookWantToBorrow();
//            BorrowedBook[] borrowedBooks = new BorrowedBook[numOfBook];
//            for (int j = 0; j < numOfBook; j++) {
//                Book book = getBookfromId();
//                borrowedBooks[j].setBook(book);
//                System.out.println("Type quantites per book(<=3)");
//                int quans = typeQuantities();
//                borrowedBooks[j].setNumOfBorrowedBook(quans);
//            }
//            borrowingManagement = new BorrowingManagement(students[i], borrowedBooks);
//            borrowingManagements[i] = borrowingManagement;
//        }
//    }
//
//    public void showInfoBorrowingBook() {
//        if (borrowingManagements == null) {
//            System.out.println("Have no borrowing books infomation");
//            borrowBook();
//        }
//        for (int i = 0; i < borrowingManagements.length; i++) {
//            System.out.println(borrowingManagements[i].toString());
//        }
//    }
//
//    public int typeNumOfBookWantToBorrow() {
//        boolean check = false;
//        sc = new Scanner(System.in);
//        do {
//            int quantites = sc.nextInt();
//            if (quantites <= 5) {
//                check = true;
//                return quantites;
//            }
//        } while (check == false);
//        return 0;
//    }
//
//    public int typeQuantities() {
//        boolean check = false;
//        sc = new Scanner(System.in);
//        do {
//            int quantites = sc.nextInt();
//            if (quantites <= 3) {
//                check = true;
//                return quantites;
//            }
//        } while (check == false);
//        return 0;
//    }
//
//    public void sortDesBbmsFromTotalBrdBooks() {
//        for (int i = 0; i < borrowingManagements.length - 1; i++) {
//            int minPos = i;
//            for (int j = i + 1; i <= borrowingManagements.length; j++) {
//                if (borrowingManagements[j].getTotalBorredBooks() > borrowingManagements[minPos].getTotalBorredBooks()) {
//                    minPos = j;
//                }
//            }
//            BorrowingManagement temp = borrowingManagements[minPos];
//            borrowingManagements[minPos] = borrowingManagements[i];
//            borrowingManagements[i] = temp;
//        }
//    }
//
//    public Student findReaderFromReadeId() {
//        if (students == null) {
//            System.out.println("Please add readers first");
//            students = returnReaders();
//        }
//        System.out.println("please type Reader Id you want to find");
//        boolean check = false;
//        do {
//            sc = new Scanner(System.in);
//            int readerID = sc.nextInt();
//            for (int i = 0; i < students.length; i++) {
//                if (readerID == students[i].getReaderID()) {
//                    check = true;
//                    return students[i];
//                }
//            }
//            System.out.println("Not found reader id. Please re-type");
//        } while (check == false);
//        return null;
//    }
//
//    public Book getBookfromId() {
//        if (books == null) {
//            System.out.println("Please add book first");
//            books = returnBookLibs();
//        }
//        boolean check = false;
//        do {
//            sc = new Scanner(System.in);
//            int bookId = sc.nextInt();
//            for (int i = 0; i < books.length; i++) {
//                if (books[i].getBookId() == bookId) {
//                    check = true;
//                    return books[i];
//                }
//            }
//            System.out.println("Not found book id. Please re-type");
//        } while (check == false);
//        return null;
//    }
//
//    public BorrowingManagement findBorroredBookByReaderName() {
//        if (borrowingManagements == null) {
//            borrowBook();
//        }
//        boolean check = false;
//        do {
//            sc = new Scanner(System.in);
//            String readername = sc.nextLine();
//            for (int i = 0; i < borrowingManagements.length; i++) {
//                if (borrowingManagements[i].getReaders().getFullName().equalsIgnoreCase(readername)) {
//                    check = true;
//                    return borrowingManagements[i];
//                }
//                System.out.println("Can not find this name. Please re-type!");
//            }
//        } while (check == false);
//        return null;
//    }
//
//}

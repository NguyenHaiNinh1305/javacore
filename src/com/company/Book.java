package com.company;

import java.util.Scanner;

public class Book {

    private int bookId = 10000;
    private String author;
    private String publishYear;
    private TypeMajor major;
    private String bookName;
    Scanner sc = new Scanner(System.in);

    public void inputBookInfo() {

        System.out.println("Input author: ");
        author = sc.nextLine();
        System.out.println("Input address: ");
        publishYear = sc.nextLine();
        System.out.println("Input publishYear: ");
        bookName = sc.nextLine();
        System.out.println("Pleas choose type reader 1-natureSience 2-artAndLiterature 3-telecommunication 4-informationTech ");
        int choose = sc.nextInt();
        switch (choose) {
            case 1:
                major = TypeMajor.natureSience;
                break;
            case 2:
                major = TypeMajor.artAndLiterature;
                break;
            case 3:
                major = TypeMajor.telecommunication;
                break;
            case 4:
                major = TypeMajor.informationTech;
                break;
            default:
                System.out.println("Have no selection for this number");
                break;
        }


    }

    public Book() {

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public TypeMajor getMajor() {
        return major;
    }

    public void setMajor(TypeMajor major) {
        this.major = major;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author='" + author + '\'' +
                ", publishYear='" + publishYear + '\'' +
                ", major=" + major +
                ", bookName='" + bookName + '\'' +
                '}';
    }


}

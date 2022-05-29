package com.company;

public class Main {

    public static void main(String[] args) {

        Util util = new Util();
        Book [] books = util.returnBookLibs();
        Reader [] readers = util.returnReaders();
        util.borrowBook();
        util.showInfoBorrowingBook();
        System.out.println(util.findReaderFromReadeId().toString());



    }

}

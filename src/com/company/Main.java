package com.company;

import com.company.entity.BorrowingManagement;
import com.company.service.Service;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        processTask();
    }

    public static void processTask() {
        Service service = new Service();
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            showMenu();
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    service.returnBookLibs();
                    break;
                case 2:
                    service.returnReaders();
                    break;
                case 3:
                    service.borrowBook();
                    break;
                case 4:
                    service.sortDesBbmsFromTotalBrdBooks();
                    break;
                case 5:
                    BorrowingManagement borrowingManagement = service.findBorroredBookByReaderName();
                    System.out.println(borrowingManagement.toString());
                    break;
                case 6:
                    service.showInfoReader(service.getReaders());
                    break;
                case 7:
                    service.showInfoBook(service.getBooks());
                    break;
                case 8:
                    service.showInfoBorrowingBook();
                    break;
                case 0:
                    System.out.println("finish");
                    return;
                default:
                    break;
            }
        } while (choose != 0);
    }

    public static void showMenu() {
        System.out.println("/****************************************/");
        System.out.println("1. Add Book.\n" + "2. Add reader.\n" + "3. Borrow books.\n"
                + "4. Sort borrowing book by descending.\n" + "5. Find borrowing book by reader's name.\n" + "6. Show readers.\r\n" +
                "7. Show books list.\n" + "8. Show borrowing book management list.\n" + "0. Exit.");
        System.out.println("/****************************************/");
    }

}

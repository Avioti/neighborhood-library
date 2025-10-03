package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] bookInventory= {
                new Book(1, "978-0132350838", "The Phoenix Project", "", false),
                new Book(2, "978-0132350884", "Clean Code", "", false),
                new Book(3, "978-0201633610", "Design Patterns", "", false),
                new Book(4, "978-0136291558", "Object Oriented Software Engineering", "", false),
                new Book(5, "978-0137081073", "The Clean Coder", "", false),
                new Book(6, "978-0134685991", "Effective Java", "", false),
                new Book(7, "978-0135957059", "The Pragmatic Programmer", "", false),
                new Book(8, "978-0321125215", "Domain-Driven Design", "", false),
                new Book(9, "978-0201616224", "The Pragmatic Programmer (1st Ed)", "", false),
                new Book(10, "978-1449373320", "Designing Data-Intensive Applications", "", false),
                new Book(11, "978-0596517748", "JavaScript: The Good Parts", "", false),
                new Book(12, "978-0262033848", "Introduction to Algorithms", "", false),
                new Book(13, "978-0134494166", "Clean Architecture", "", false),
                new Book(14, "978-1617294136", "Grokking Algorithms", "", false),
                new Book(15, "978-0321573513", "Algorithms", "", false),
                new Book(16, "978-1491950357", "Building Microservices", "", false),
                new Book(17, "978-0135974445", "Refactoring", "", false),
                new Book(18, "978-0672337383", "Code Complete", "", false),
                new Book(19, "978-0596007126", "Head First Design Patterns", "", false),
                new Book(20, "978-1492040347", "Kubernetes: Up and Running", "", false)
        };

        while(true){
            displayHomeScreen();

            int command = scanner.nextInt();
            scanner.nextLine();

            switch(command){
                case 1:
                    listAllBooks(bookInventory);
                    System.out.println("Select an option:");
                    System.out.println("Option 1 - Select a book to check out");
                    System.out.println("Option 2 - Exit to homescreen");
                    int option = scanner.nextInt();
                    if(option == 1){
                        System.out.println("Choose book");
                        int bookId = scanner.nextInt();
                        System.out.println("Enter your name");
                        String name = scanner.next();
                        checkOutBook(bookInventory,bookId,name);



                    }
                    break;
                case 2:
                    listCheckedOutBooks(bookInventory);
                    System.out.println("C to check in a book");
                    System.out.println("X - to go back to home screen");
                    String choice = scanner.nextLine();
                    if(choice.equalsIgnoreCase("C")){
                        System.out.println("Enter book ID to check in");
                        int bookId = scanner.nextInt();
                        for (Book book : bookInventory) {
                            if(book.getId() == bookId){
                                if(book.isCheckedOut()){
                                    book.checkIn();
                                } else {
                                    System.out.println("That book is not checked out.");
                                }
                                break;

                            }
                        }
                    }
                    break;

                default:
                    System.out.println("Exiting application. Goodbye!");
                    System.exit(0);
                    scanner.close();
                    break;


            }




        }



    }



    public static void checkOutBook(Book[] inventory, int bookId, String name){
        for (Book book : inventory) {
            if(book.getId() == bookId){
                if(!book.isCheckedOut()){
                    book.checkOut(name);
                }
                return;
            }
        }
        System.out.println("Sorry, we don't have a book with that ID.");
    }




    public static void listCheckedOutBooks(Book[] inventory) {
        for (Book book : inventory) {
            // Only show books that are NOT checked out
            if (book.isCheckedOut()) {
                System.out.println(book.getId() + " | " + book.getIsbn() + " | " + book.getTitle() +" | " + book.getCheckedOutTo());
            }
        }
    }

    public static void listAllBooks(Book[] inventory) {
        for (Book book : inventory) {
            // Only show books that are NOT checked out
            if (!book.isCheckedOut()) {
                System.out.println(book.getId() + " | " + book.getIsbn() + " | " + book.getTitle());
            }
        }
    }

    public static void displayHomeScreen(){
        System.out.println("1 - Show Available Books");
        System.out.println("2 - Show Checked Out Books");
        System.out.println("3 - Exit - Close out the Application");

        System.out.printf("%nEnter Option: ");
    }
}

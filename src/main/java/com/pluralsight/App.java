package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] bookInventory= {
                new Book(1, "978-0134685991", "Effective Java", "", false),
                new Book(2, "978-0596009205", "Head First Java", "", false),
                new Book(3, "978-0321356683", "Effective Java (2nd Edition)", "", false),
                new Book(4, "978-1617293290", "Java 8 in Action", "", false),
                new Book(5, "978-1491981955", "Mastering Ethereum", "", false),
                new Book(6, "978-1484252772", "Beginning Ethereum Smart Contracts Programming", "", false),
                new Book(7, "978-1484250389", "Mastering Blockchain Programming with Solidity", "", false),
                new Book(8, "978-1119555018", "Blockchain Development with Ethereum", "", false),
                new Book(9, "978-1491971949", "Mastering Bitcoin and Ethereum", "", false),
                new Book(10, "978-0134190440", "The Java Language Specification", "", false),
                new Book(11, "978-0596516178", "Java Concurrency in Practice", "", false),
                new Book(12, "978-1449374648", "Ethereum Development with Go", "", false),
                new Book(13, "978-0262033848", "Introduction to Algorithms", "", false),
                new Book(14, "978-0393347944", "The Selfish Gene", "", false),
                new Book(15, "978-0393349948", "The Greatest Show on Earth", "", false),
                new Book(16, "978-0226901169", "The Evolution of Cooperation", "", false),
                new Book(17, "978-0815344322", "Molecular Biology of the Cell", "", false),
                new Book(18, "978-0393355482", "Why Evolution Is True", "", false),
                new Book(19, "978-0393929270", "The Origin of Species", "", false),
                new Book(20, "978-0879694357", "Evolution (Douglas Futuyma)", "", false)
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
                case 3:
                    bookInventory = donateBook(scanner, bookInventory);
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
    public static Book[] donateBook(Scanner input, Book[] inventory){
        System.out.println("Enter the ISBN of the book you want to donate: ");
        String isbn = input.nextLine();
        System.out.println("Enter the title of the book you want to donate: ");
        String title = input.nextLine();

        int newId = inventory.length + 1;
        Book newBook = new Book(newId, isbn, title, "", false);

        Book[] newInventory = new Book[inventory.length + 1];
        for (int i = 0; i < inventory.length + 1; i++) {
            if (i == inventory.length) {
                newInventory[i] = newBook;
            } else {
                newInventory[i] = inventory[i];
            }
        }

        System.out.println("Thank you for donating " + title + "!");

        return newInventory;
    }

    public static void displayHomeScreen(){
        System.out.println("1 - Show Available Books");
        System.out.println("2 - Show Checked Out Books");
        System.out.println("3 - Donate a Book of your choice");
        System.out.println("4 - Exit - Close out the Application");

        System.out.printf("%nEnter Option: ");
    }
}

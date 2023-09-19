package mdi;

import library.Publication;
import library.Library;
import java.util.Scanner;

public class LibraryManager {
    public static void main (String[] args)
    {
        //Create a new library
        Library myLibrary = new Library("\nHogwart Restricted Section\n");

        //Add 3 books to the system
        Publication book1 = new Publication("1Q84", "Haruki Murakami", 2009,null, null);
        Publication book2 = new Publication("Ticket To Childhood", "Nguyen Nhat Anh", 2008, null, null);
        Publication book3 = new Publication("Twenty Thousand Leagues Under the Sea", "Jules Verne", 1994, null, null);

        myLibrary.addPublication(book1);
        myLibrary.addPublication(book2);
        myLibrary.addPublication(book3);

        System.out.println(myLibrary.toString());

        //Ask for info
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Which book to check out? ");
        int publicationIndex = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Who are you? ");
        String patron = scanner.nextLine();

        //Call checkOut and print out
        myLibrary.checkOut(publicationIndex - 1, patron);

        System.out.println(myLibrary.toString());

        scanner.close();

    }
}

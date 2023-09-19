package mdi;

import library.Publication;
import library.Video;
import library.Library;

import java.time.Duration;
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

        
        //Add 3 videos to the system
        Video video1 = new Video("Pacific Rim", "Guillermo del Toro", 2013, null, null, Duration.ofMinutes(132));
        Video video2 = new Video("Interstellar", "Christopher Nolan", 2014, null, null, Duration.ofMinutes(169));
        Video video3 = new Video("How'l Moving Castle", "Hayao Miyazaki", 2004, null, null, Duration.ofMinutes(119));

        myLibrary.addVideo(video1);
        myLibrary.addVideo(video2);
        myLibrary.addVideo(video3);


        System.out.println(myLibrary.toString());


        //Ask for info
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Which publication to check out? ");
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

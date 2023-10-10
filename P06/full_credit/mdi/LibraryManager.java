// Copyright 2023 Tin Ngo <https://github.com/tinngo777/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>.
package mdi;

import library.Library;
import library.Publication;
import library.Video;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LibraryManager {
    //declare private field
    private Library library;

    //constructor
    public LibraryManager(Library library)
    {
        this.library = library;
    }

    //listPublications
    public void listPublications()
    {
        System.out.println(library);
    }

    //addPublication
    public void addPublication()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter publication title: ");
            String title = reader.readLine();

            System.out.print("Enter author: ");
            String author = reader.readLine();

            System.out.print("Enter copyright year: ");
            int copyright = Integer.parseInt(reader.readLine());

            Publication publication = new Publication(title, author, copyright);
            library.addPublication(publication);
            System.out.println("Publication added successfully.");
        }
        catch (IOException | NumberFormatException e)
        {
            System.err.println("Error when adding publication: " + e.getMessage());
        }
    }

    //addVideo
    public void addVideo() 
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter video title: ");
            String title = reader.readLine();

            System.out.print("Enter producer: ");
            String producer = reader.readLine();
            
            System.out.print("Enter copyright year: ");
            int copyright = Integer.parseInt(reader.readLine());

            System.out.print("Enter runtime (in minutes): ");
            int runtime = Integer.parseInt(reader.readLine());

            Video video = new Video(title, producer, copyright, runtime);
            library.addPublication(video);
            System.out.println("Video added successfully.");
        } 
        catch (IOException | NumberFormatException e) 
        {
            System.err.println("Error when adding video: " + e.getMessage());
        }
    }

    //checkOut
    public void checkOutPublication() 
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter publication index to check out: ");
            int publicationIndex = Integer.parseInt(reader.readLine());

            System.out.print("Enter patron name: ");
            String patron = reader.readLine();

            library.checkOut(publicationIndex, patron);
            System.out.println("Publication checked out successfully.");
        } 
        catch (IOException | NumberFormatException e) 
        {
            System.err.println("Error checking out publication: " + e.getMessage());
        }
    }

    //checkIn
    public void checkInPublication() 
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter publication index to check in: ");
            int publicationIndex = Integer.parseInt(reader.readLine());

            library.checkIn(publicationIndex);
            System.out.println("Publication checked in successfully.");
        } 
        catch (IOException | NumberFormatException e) 
        {
            System.err.println("Error checking in publication: " + e.getMessage());
        }
    }

    //saveLibrary method
    public void saveLibrary()
    {   
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try 
        {
            System.out.print("Enter your filename to save: ");
            String filename = reader.readLine();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
            {
                library.save(writer);
                System.out.println("Library saved successfully.");
            }
            catch (IOException e)
            {
                System.err.println("Error: couldn't save file " + e.getMessage());
            }
        }
        catch (IOException e)
        {
            System.err.println("Error: couldn't read filename " +e.getMessage());
        }
    }


    //openLibrary method
    public void openLibrary()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            System.out.print("Enter your filename to open: ");
            String filename = reader.readLine();

            try (BufferedReader br = new BufferedReader(new FileReader(filename)))
            {
                library = new Library(br);
                System.out.println("Library opened successfully.");
            }
            catch (IOException e)
            {
                System.err.println("Error: couldn't open file " + e.getMessage());
            }
        }
        catch (IOException e)
        {
            System.err.println("Error: couldn't read filename " + e.getMessage());
        }
    }


    //Main menu
    public void run()
    {
        //set exit to false for while loop
        boolean exit = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (!exit)
        {   
            //Display menu
            System.out.println("=========");
            System.out.println("Main Menu");
            System.out.println("=========");
            System.out.println("");
            System.out.println("Hogwarts Library's Restricted Section");
            System.out.println("");
            System.out.println("0) Exit");
            System.out.println("1) List");
            System.out.println("2) Add Publication");
            System.out.println("3) Add Video");
            System.out.println("4) Check out");
            System.out.println("5) Check in");
            System.out.println("6) Save Library");
            System.out.println("7) Open Library");
            System.out.println("");


            // Ask for menu option
            System.out.print("Selection: ");
            
            try 
            {   
                int select = Integer.parseInt(reader.readLine());
                switch (select)
                {
                    case 0:
                        exit = true;
                        break;
                    case 1:
                        listPublications();
                        break;
                    case 2:
                        addPublication();
                        break;
                    case 3:
                        addVideo();
                        break;
                    case 4:
                        checkOutPublication();
                        break;
                    case 5:
                        checkInPublication();
                        break;
                    case 6:
                        saveLibrary();
                        break;
                    case 7:
                        openLibrary();
                        break;
                    default:
                        System.out.println("Invalid selection. Please try again");
                }   
            }
            catch (IOException e)
            {
                System.err.println("Error reading output " + e.getMessage());
                break;
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library("Hogwarts Library's Restricted Section");
        library.addPublication(new Publication("Ticket to Childhood", "Nguyen Nhat Anh", 2008));
        library.addPublication(new Publication("1Q84", "Haruki Murakami", 2009));
        library.addPublication(new Publication("The Bro Code", "Barney Stinson", 2006));
        library.addPublication(new Video("Pacific Rim", "Guillermo del Toro", 2013, 132));
        library.addPublication(new Video("Memento", "Christopher Nolan", 2000, 113));
        library.addPublication(new Video("The Song Remains the Same", "Led Zeppelin", 1976, 138));
        
        //Declare manager object
        LibraryManager manager = new LibraryManager(library);
        manager.run();
    }
}

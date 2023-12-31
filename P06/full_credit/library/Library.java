// Copyright 2023 Tin Ngo <https://github.com/tinngo777/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>.
package library;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


 public class Library {
    
    //Declare private fields
    private String name;
    private ArrayList<Publication> publications;


    //Create library instance
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
    }

    //second constructor
    public Library(BufferedReader br) throws IOException
    {
        this.name = br.readLine();
        this.publications = new ArrayList<>();

        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++)
        {
            String type = br.readLine();
            if ("video".equals(type))
            {
                publications.add(new Video(br));
            }
            else 
            {
                publications.add(new Publication(br));
            }
        }
    }


    
    //Add publication to this instance
    public void addPublication(Publication publication) {
        publications.add(publication);
    }
   
    //Check out publication from this library instance
    //Due date is 14 days from the date checking out
    public void checkOut(int publicationIndex, String patron) {
        try {
            publications.get(publicationIndex).checkOut(patron);
        } catch(Exception e) {
            System.err.println("\nUnable to check out publication #" + publicationIndex 
                + ": " + e.getMessage() + "\n");
        }
    }


    public void checkIn(int publicationIndex)
    {
        try{
            publications.get(publicationIndex).checkIn();
        } catch (Exception e) {
            System.err.println("Unable to check in publication #" + publicationIndex
                + ": " + e.getMessage() + "\n");
        }
    }


    
    //List all publication in this library instance
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "\n\n");
        for(int i=0; i<publications.size(); ++i)
            sb.append("" + i + ") " + publications.get(i).toString() + "\n");
        return sb.toString();
    }

    public void save(BufferedWriter bw) throws IOException
    {
        bw.write(name + "\n");
        //size of ArrayList
        bw.write(publications.size() + "\n");

        //Write each Publication object to stream
        for (Publication pub : publications)
        {
            if (pub instanceof Video)
            {
                bw.write("video\n");
            }
            else
            {
                bw.write("publication\n");
            }
            pub.save(bw);
        }
    }
    
}

package library;

import java.util.ArrayList;

public class Library 
{   
    //Declare private fields
    private String name;
    private ArrayList<Publication> publications;
    
    //Constructor
    public Library(String name)
    {
        this.name = name;
        this.publications = new ArrayList<>();
    }

    //Methods 

    public void addPublication(Publication publication)
    {
        publications.add(publication);
    }

    public void checkOut(int publicationIndex, String patron)
    {
        if (publicationIndex >= 0 && publicationIndex < publications.size())
        {
            Publication publication = publications.get(publicationIndex);
            publication.checkOut(patron);
        }
        else
        {
            throw new IndexOutOfBoundsException(String.valueOf(publicationIndex));
        }
    }

    @Override
    public String toString()
    {
        StringBuilder indexString = new StringBuilder();
        indexString.append(name).append("\n");

        for (int i = 0; i < publications.size(); i++)
        {
            Publication publication = publications.get(i);
            indexString.append(i + 1).append(") ").append(publication).append("\n");
        }

        return indexString.toString();
    }








}

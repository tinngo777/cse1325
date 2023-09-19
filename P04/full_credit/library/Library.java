package library;

import java.util.ArrayList;

public class Library 
{   
    //Declare private fields
    private String name;
    private ArrayList<Publication> publications;
    private ArrayList<Video> videos;
    
    //Constructor
    public Library(String name)
    {
        this.name = name;
        this.publications = new ArrayList<>();
        this.videos = new ArrayList<>();
    }

    //Methods 

    public void addPublication(Publication publication)
    {
        publications.add(publication);
    }

    public void addVideo(Video video)
    {
        videos.add(video);
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

        int i = 0;

        for (i = 0; i < publications.size(); i++)
        {
            Publication publication = publications.get(i);
            indexString.append(i).append(") ").append(publication).append("\n");
        }

        for (i = 0; i < videos.size(); i++)
        {
            Video video = videos.get(i);
            indexString.append(i + 3).append(") ").append(video).append("\n");
        }


        return indexString.toString();
    }

}


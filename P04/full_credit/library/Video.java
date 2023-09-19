package library;

import java.time.Duration;
import java.time.LocalDate;

public class Video extends Publication {
    private Duration runtime;
    
    //Constructor
    public Video(String title, String author, int copyright, String loanedTo, LocalDate dueDate, Duration runtime)
    {
        super(title, author, copyright, loanedTo, dueDate);
        this.runtime = runtime;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(super.toString());
        
        sb.append("Video: ").append(title).append(", directed by ");
        sb.append(author).append(", copyright in ").append(copyright);
        sb.append("\n");

        if (loanedTo != null)
        {
            sb.append("It was loaned to ").append(loanedTo);
            sb.append(", due on ").append(dueDate);
        }

        return sb.toString();
    }
}

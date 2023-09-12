package P03.full_credit;
import java.time.LocalDate;

public class Publication 
{   
    //Declare private fields
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

    //Constructor 
    public Publication(String title, String author, int copyright, String loanedTo, LocalDate dueDate)
    {
        this.title = title;
        this.author = author;
        this.copyright = copyright;
        this.loanedTo = loanedTo;
        this.dueDate = dueDate;

        
    }

}

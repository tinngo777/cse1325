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
        //Initialize fields
        this.title = title;
        this.author = author;
        this.copyright = copyright;
        this.loanedTo = loanedTo;
        this.dueDate = dueDate;

        //get current year and perform data validation for copyright year
        int currentYear = LocalDate.now().getYear();

        if (copyright < 1900 || copyright > currentYear)
        {
            throw new IllegalArgumentException("The year has to be between 1900 and current year");
        }
    }

    public void checkOut (String patron)
    {
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Book Title: ").append(title).append(", ");
        sb.append("written by ").append(author).append(", copyright in ").append(copyright);
        sb.append("\n");

        if (loanedTo != null)
        {
            sb.append("It was loaned to ").append(loanedTo);   
            sb.append(", due on ").append(dueDate);
        }

        return sb.toString();
    }

}

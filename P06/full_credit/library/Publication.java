// Copyright 2023 Tin Ngo <https://github.com/tinngo777/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>.
package library;

import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


public class Publication {
    //declare private fields
    public static final int LOAN_PERIOD = 14; // days
    
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

    // Create publication instance (year must be from 1900 to present)
    public Publication(String title, String author, int copyright) {
        if(copyright < 1900 || copyright > LocalDate.now().getYear())
            throw new IllegalArgumentException("Invalid copyright year : " + copyright);
        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }

    //second Publication constructor 
    public Publication (BufferedReader br) throws IOException
    {   
        //read in the same order as save method
        title = br.readLine();
        author = br.readLine();
        copyright = Integer.parseInt(br.readLine());

        String checkStatus = br.readLine();
        if ("checked in".equals(checkStatus))
        {
            loanedTo = null;
            dueDate = null;
        }
        else
        {
            loanedTo = br.readLine();
            dueDate = LocalDate.parse(br.readLine());
        }
    }



    
    //Notes the patron who borrowed this publication along with the due date
    //The Patron is a string, with no data validation. This will require a lot
    //of discipline on the part of the libraries to make this field useful.
   
    public void checkOut(String patron) {
        loanedTo = patron;
        dueDate = LocalDate.now().plusDays(LOAN_PERIOD);
    }
    

    //Note that publication has been returned
    public void checkIn() {
        loanedTo = null;
        dueDate = null;
    }
    
    protected String toStringBuilder(String pre, String mid) {
        return pre + " \"" + title + "\" by " + author + ", copyright " + copyright
             + mid 
            + ((loanedTo != null) ? "\n     : loaned to " + loanedTo + " until " + dueDate
                                  : "");
    }
    
    //Format field of publication in human readeable form
    @Override
    public String toString() {
        return toStringBuilder("Book", "");
    }

    //save method 
    public void save(BufferedWriter bw) throws IOException
    {
        bw.write(title + "\n");
        bw.write(author + "\n");
        bw.write("" + copyright + "\n");

        if (loanedTo == null)
        {
            bw.write("checked in\n");
        }
        else 
        {
            bw.write("checked out\n");
            bw.write(loanedTo + "\n");
            bw.write(dueDate.toString() + "\n");
        }
    }
    
}

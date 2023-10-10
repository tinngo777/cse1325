// Copyright 2023 Tin Ngo <https://github.com/tinngo777/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>.
package library;

import java.time.Duration;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


public class Video extends Publication {
    //Declare private field
    Duration runtime;

    //Thown when a Video runtime is invalid.
    public class InvalidRuntimeException extends ArithmeticException {
        
        //Constructs an InvalidRuntimeException with no detail message.
        public InvalidRuntimeException() {super();}
        
        //Constructs an InvalidRuntimeException with with the specified detail message.
        public InvalidRuntimeException(String message) {super(message);}
        
        //Constructs an InvalidRuntimeException with a custom message.
        public InvalidRuntimeException(String title, int runtime) {
            super(title + " has invalid runtime " + runtime);
        }
    }

    //Constructor
    public Video(String title, String author, int copyright, int runtime) {
        super(title, author, copyright);
        if(runtime < 1) throw new InvalidRuntimeException(title, runtime);
        this.runtime = Duration.ofMinutes(runtime);
    }

    //Second constructor
    public Video(BufferedReader br) throws IOException
    {
        super(br);
        long minutes = Long.parseLong(br.readLine());
        this.runtime = Duration.ofMinutes(minutes);
    }


    //Inherit save from Publication
    @Override
    public void save(BufferedWriter bw) throws IOException
    {
        super.save(bw); //chain to superclass Publication's save method
        bw.write("" + runtime.toMinutes() + "\n");
    }
   
    @Override
    public String toString() {
        return toStringBuilder("Video", ", runtime " + runtime.toMinutes() + " minutes");
    }
    
}

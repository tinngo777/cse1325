#ifndef LOCATION_H
#define LOCATION_H

#include <iostream>


class Location
{
    private:
        std::string _filename;
        int _line;

    public:
        Location(std::string filename, int line);

        //Comparison operator
        bool operator==(const Location& rhs) const;
        bool operator!=(const Location& rhs) const;
        bool operator<(const Location& rhs) const;
        bool operator>(const Location& rhs) const;
        bool operator<=(const Location& rhs) const;
        bool operator>=(const Location& rhs) const;
        
        //Friend function
        friend std::ostream& operator<<(std::ostream& os, const Location& loc);

        //Compare function
        int compare(const Location& rhs) const;
};


#endif
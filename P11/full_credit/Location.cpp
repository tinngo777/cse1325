#include "Location.h"

//Constructor
Location::Location(std::string filename, int line) : _filename(filename), _line(line) {}

//Comparison operators
bool Location::operator==(const Location& rhs) const 
{ 
    return compare(rhs) == 0; 
}

bool Location::operator!=(const Location& rhs) const 
{ 
    return compare(rhs) != 0; 
}

bool Location::operator<(const Location& rhs) const 
{ 
    return compare(rhs) < 0; 
}

bool Location::operator<=(const Location& rhs) const 
{ 
    return compare(rhs) <= 0; 
}

bool Location::operator>(const Location& rhs) const 
{ 
    return compare(rhs) > 0; 
}

bool Location::operator>=(const Location& rhs) const 
{ 
    return compare(rhs) >= 0; 
}

//Friend function
std::ostream& operator<<(std::ostream& os, const Location& loc) {
    return os << loc._filename << " line " << loc._line;
}

// Spaceship-style compare
int Location::compare(const Location& rhs) const {
    if (_filename < rhs._filename) 
    {
        return -1;
    }

    if (_filename > rhs._filename) 
    {
        return 1;
    }

    if (_line < rhs._line) 
    {
        return -1;
    }
    if (_line > rhs._line) 
    {
        return 1;
    }

    
    return 0;
}

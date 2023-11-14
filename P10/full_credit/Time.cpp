#include "Time.h"

void Time::rationalize()
{   
    //Make sure seconds are from 0-59
    while (_second >= 60)
    {
        _second -= 60;
        _minute++;
    }

    while (_second < 0)
    {
        _second += 60;
        _minute--;
    }
    
    //Make sure minutes are from 0-59
    while (_minute >= 60)
    {
        _minute -= 60;
        _hour++;
    }

    while (_minute <0)
    {
        _minute += 60;
        _hour--;
    }

    //Make sure hours are from 0-23
    while (_hour >= 24)
    {
        _hour -= 24;
    }

    while (_hour < 0)
    {
        _hour += 24;
    }
}

//Initializes obj with time provided then rationalize it
Time::Time(int hour, int minute, int second) : _hour(hour), _minute(minute), _second(second)
{
    rationalize();
}

//Overload +
Time Time::operator+(const Time& rhs) const 
{
    Time result(_hour + rhs._hour, _minute + rhs._minute, _second + rhs._second);
    result.rationalize();
    return result;
}

//Overload prefix ++ 
Time& Time::operator++()
{
    ++_second;
    rationalize();
    return *this;
}

//Overload postfix ++
Time Time::operator++(int)
{
    Time temp = *this;
    ++(*this);
    return temp;
}

//Overload ==
bool Time::operator==(const Time& rhs) const
{
    return _hour == rhs._hour && _minute == rhs._minute && _second == rhs._second;
}

//Overload !=
bool Time::operator!=(const Time& rhs) const
{
    return !(*this == rhs);
}

//Overload <
bool Time::operator<(const Time& rhs) const
{
    if (_hour < rhs._hour) return true;
    if (_hour > rhs._hour) return false;
    if (_minute < rhs._minute) return true;
    if (_minute > rhs._minute) return false;

    return _second < rhs._second;
}

//Overload >
bool Time::operator>(const Time& rhs) const 
{
    return rhs < *this;
}

//Overload <=
bool Time:: operator<=(const Time& rhs) const 
{
    return !(*this > rhs);
}

//Overload >=
bool Time::operator>=(const Time& rhs) const 
{
    return !(*this < rhs);
}

//Friend function overloads the stream insertion operator for output
std::ostream& operator<<(std::ostream& os, const Time& obj)
{   
    //Output time in HH:MM:SS format
    os << std::setfill('0') << std::setw(2) << obj._hour << ":"
       << std::setw(2) << obj._minute << ":" << std::setw(2) << obj._second;
    return os;
}

//Friend function overloads stream extraction operator for input
std::istream& operator>>(std::istream& is, Time& obj)
{
    char delim1, delim2;
    //Read input stream, check if colons are present
    is >> obj._hour >> delim1 >> obj._minute >> delim2 >> obj._second;
    
    if (delim1 != ':' || delim2 != ':' || !is)
    {
        is.setstate(std::ios::failbit);
    } 
    else
    {
        obj.rationalize();
    }
    return is;
}

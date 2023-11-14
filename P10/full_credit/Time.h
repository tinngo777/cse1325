#ifndef TIME_H
#define TIME_H

#include <iostream>
#include <iomanip>

class Time
{
    private:
        int _hour;
        int _minute;
        int _second;

        void rationalize();
    
    public:
        Time(int hour = 0, int minute = 0, int second = 0);

        Time operator+ (const Time& rhs) const;
        Time& operator++();
        Time operator++(int);

        bool operator==(const Time& rhs) const;
        bool operator!=(const Time& rhs) const;
        bool operator<(const Time& rhs) const;
        bool operator>(const Time& rhs) const;
        bool operator<=(const Time& rhs) const;
        bool operator>=(const Time& rhs) const;

        friend std::ostream& operator<<(std::ostream& os, const Time& obj);
        friend std::istream& operator>>(std::istream& is, Time& obj);
};

#endif
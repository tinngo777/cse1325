#ifndef SHAPE_H
#define SHAPE_H

#include <string>

class Shape
{   //declare function
    public:
        virtual ~Shape() = default;
        virtual std::string name() const {return "Shape";}
        virtual double area() const {return 0.0;}
        virtual std::string to_string() const
        {
            return name() + " with area " + std::to_string(area());
        } 
};

#endif 
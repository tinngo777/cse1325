#ifndef SHAPE_H
#define SHAPE_H

#include <string>

class Shape
{
    public:
        virtual ~Shape() = default;

        //Keep everything the same as full_credit, only add '=0' for abstract
        virtual std::string name() const = 0;
        virtual double area() const = 0;
        virtual std::string to_string() const
        {
            return name() + " with area " + std::to_string(area());
        } 
};

#endif 
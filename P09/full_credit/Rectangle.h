#ifndef RECTANGLE_H
#define RECTANGLE_H

#include "Shape.h"

class Rectangle : public Shape 
{
    private:
        double height;
        double width;
    
    public:
        Rectangle (double height, double width);
        std::string name() const override;
        double area() const override;
        std::string to_string() const override;
};

#endif
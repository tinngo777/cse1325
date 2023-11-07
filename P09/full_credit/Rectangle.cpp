#include "Rectangle.h"
#include <sstream>
#include <iomanip>

Rectangle::Rectangle(double h, double w) : height(h), width(w) {}

//return name
std::string Rectangle::name() const 
{
    return " Rectangle";
}

//calculate area
double Rectangle::area() const
{
    return height * width;
}

//print Rectangle to terminal
std::string Rectangle::to_string() const 
{
    std::ostringstream oss;
    oss << std::fixed << std::setprecision(6) << height << "x" << width << name() << " with area " << area();
    return oss.str();
}
#include "Rectangle.h"
#include <sstream>
#include <iomanip>

Rectangle::Rectangle(double h, double w) : height(h), width(w) {}

std::string Rectangle::name() const 
{
    return " Rectangle";
}

double Rectangle::area() const
{
    return height * width;
}

std::string Rectangle::to_string() const 
{
    std::ostringstream oss;
    oss << std::fixed << std::setprecision(6) << height << "x" << width << name() << " with area " << area();
    return oss.str();
}
#include "Circle.h"
#include <cmath>
#include <sstream>
#include <iomanip>

Circle::Circle(double r) : radius(r) {}

//return name
std::string Circle::name() const 
{
    return "Circle of radius ";
}

//calculate area
double Circle::area() const 
{
    return M_PI * radius * radius;
}

//print Circle to terminal
std::string Circle::to_string() const 
{
    std::ostringstream oss;
    oss << std::fixed << std::setprecision(6) << name() << radius << " with area " << area();
    return oss.str();
}
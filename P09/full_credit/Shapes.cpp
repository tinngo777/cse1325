#include "Shape.h"
#include "Rectangle.h"
#include "Circle.h"
#include <iostream>
#include <vector>
#include <memory>



int main()
{   
    //create vector to hold objects 
    std::vector <std::unique_ptr<Shape>> shapes;

    //add value from subclasses to vector 
    shapes.push_back(std::make_unique<Rectangle>(3.0, 4.0));
    shapes.push_back(std::make_unique<Circle>(2.0));

    //for loop to print result to terminal
    for (const auto& shape : shapes)
    {
        std::cout << shape->to_string() << std::endl;
    }


    return 0;
}
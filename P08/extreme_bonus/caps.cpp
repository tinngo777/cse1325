#include <iostream>
#include <vector>
#include <string>
#include <algorithm>


int main(int argc, char** argv)
{   
    //stack and heap vector
    std::vector<std::string> caps;
    std::vector<std::string>* no_caps = new std::vector<std::string>();

    for (int i = 1; i < argc; i++)
    {
        std::string temp(argv[i]);
        if (temp[0] >= 'A' && temp[0] <= 'Z')
        {
            caps.push_back(temp);
        }
        else
        {
            no_caps->push_back(temp);
        }
    }

    //Sort caps in natural order
    std::sort(caps.begin(), caps.end());

    //Sort no_caps based on length and then natural order
    std::sort(no_caps->begin(), no_caps->end(), [](const std::string &a, const std::string &b)
    {
        if (a.length() == b.length())
        {
            return a < b;
        }
        return a.length() < b.length();
    });


    //Print out words from caps
    std::cout << "Capitalized:" << std::endl;
    for (int i = 0; i < static_cast<int>(caps.size()); ++i)
    {
        std::cout << caps[i] << std::endl;
    }

    std::cout << " " << std::endl;

    //Print out words from no_caps
    std::cout << "Lower Case:" << std::endl;
    for (int i = 0; i < static_cast<int>(no_caps->size()); ++i)
    {
        std::cout << (*no_caps)[i] << std::endl;
    }


    delete no_caps;
    return 0;
}

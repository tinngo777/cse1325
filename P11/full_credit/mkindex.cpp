#include "Index.h"
#include <fstream>
#include <sstream>
#include <iostream>

//Function to help clean and convert word to lowercase
std::string clean(const std::string& word)
{
    std::string cleaned_word;
    for (char ch : word)
    {
        if (std::isalpha(ch))
        {
            cleaned_word += std::tolower(ch);
        }
    }

    return cleaned_word;
}





void process_file(const std::string& filename, Index& index)
{
    std::ifstream file(filename);
    if (!file)
    {
        std::cerr << "Error: Could not open file '" << filename << "'" << std::endl;
        return;
    }

    std::string line;
    int line_num = 0;
    while (std::getline(file, line))
    {
        line_num++;
        std::istringstream iss(line);
        std::string word;
        while (iss >> word)
        {
            word = clean(word);
            if (!word.empty())
            {
                index.add_word(word, filename, line_num);
            }
        }
    }
}

int main(int argc, char* argv[])
{
    if (argc < 2)
    {
        std::cerr << "Usage: mkindex [file...]" << std::endl;
        return 1;
    }

    Index index;
    for (int i = 1; i < argc; ++i)
    {
        process_file(argv[i], index);
    }

    std::cout << index;
    return 0;
}
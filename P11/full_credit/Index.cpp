#include "Index.h"
#include <algorithm>
#include <cctype>
#include <sstream>

void Index::add_word(const Word& word, const std::string& filename, int line)
{
    Location loc(filename, line);
    _index[word].insert(loc);
}

std::ostream& operator<<(std::ostream& os, const Index& idx)
{
    for (const auto& pair : idx._index)
    {
        os << pair.first << ": ";
        for (auto it = pair.second.begin(); it != pair.second.end(); ++it)
        {
            if (it != pair.second.begin())
            {
                os << ", ";
            }
        }
        os << std::endl;
    }

    return os;
}
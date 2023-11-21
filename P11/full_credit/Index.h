#ifndef INDEX_H
#define INDEX_H

#include <iostream>
#include <map>
#include "Types.h"

class Index
{
    private:
        std::map<Word, Locations> _index;

    public:
        void add_word(const Word& word, const std::string& filename, int line);
        friend std::ostream& operator<<(std::ostream& os, const Index& idx);
};

#endif
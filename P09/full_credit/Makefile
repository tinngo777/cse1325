CXXFLAGS += --std=c++17

shapes: Shapes.o Shape.o Circle.o Rectangle.o
	$(CXX) $(CXXFLAGS) Shapes.o Shape.o Circle.o Rectangle.o -o shapes


Circle.o: Circle.cpp Circle.h Shape.h
	$(CXX) $(CXXFLAGS) -c Circle.cpp -o Circle.o

Rectangle.o: Rectangle.cpp Rectangle.h Shape.h
	$(CXX) $(CXXFLAGS) -c Rectangle.cpp -o Rectangle.o

Shape.o: Shape.cpp Shape.h
	$(CXX) $(CXXFLAGS) -c Shape.cpp -o Shape.o

Shapes.o: Shapes.cpp Shape.h Circle.h Rectangle.h
	$(CXX) $(CXXFLAGS) -c Shapes.cpp -o Shapes.o


clean:
	rm -f *.o *.gch *~ shapes


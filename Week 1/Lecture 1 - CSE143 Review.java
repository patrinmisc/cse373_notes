//// DAY 1 What is this class about?

/* 
// TOPICS IN CSE143
- Classes and interfaces
- Methods, variables, and conditionals
- loops and recursion
- Linked lists and binary trees
- Sorting and searching
- O(n) analysis
- Generics 

// TOPICS IN CSE373
Design decisions
Design analysis
Implementations of data structures
Debugging and testing
Abstract data types
Code modeling
Coplexity analysis
Software Engineering Practices */

// ===============================

/* DATA STRUCTURES AND ALGORITHMS
Data structure: A way of organizing and storing related data points
Examples from CSE143: Arrays, linkedlists, stacks, queues, trees

Algorithm: A series of precise instructions used to do some kind of job.
In layman's terms, it's just a set of instructions written in code.  Examples
from CSE143: binary search, merge sort, recursive backtracking. */

// ===============================

/* CLIENTS VS OBJECTS
Client Class: The object that is actually executable.  Like the client in Critters
Object Class: The objects that support the client. Like Ants from Critters
*/

// ===============================

/* Abstract Data Types (ADT)

A definition for expected operations and behavior. An example of this is a list,
which has a clear set of rules defining what it is supposed to be able to do. One
implementation of its ideas, an array, is an INTERPRETATION of this idea, not the
abstract idea itself. 
ex) List, Map, Set, Stack, Queue, Priority Queue, Graph
*/

/* Example: The List ADT
stores an ordered sequence of information
- Each item is accessible by an index
- Lists have a variable size so items can be added and removed

There are two implementations (data structures) of this abstract data type.
ArrayList<E> // uses array as the underlying data storage.  Easier for Random
			 // access, but worse for memory
LinkedList<E> // uses nodes as the underlying data storage.  Better for memory,
			  // but worse for random access

So when you write the following code, the left side describes the ADT you want
to use, and the one on the right is the implementation */
List example = new ArrayList<Integer>();


// ===============================

/* Design Decisions
Every ADT has many different implementations.  When deciding which to use,
consider:
- Memory vs speed
- Generic/Reusability vs level of specialization
- One function vs another
- Robustness vs performance

THIS CLASS IS ABOUT IMPLEMENTING ADTs.  Common topic for interview questions
is why you implemented a certain ADT

// ===============================

/* O(n)

n refers to your dataset.  If it is 10 items long, then n = 10.
As you increase the size of n, how does your algorithm perform?  That
is what's referred to as the growth rate, and it models your efficiency. */

/* Complexity Classes
O(1) often means you directly accessed a single point of data in your code
O(log2 N) often refers to searching down a branch of a tree
O(n) often means you have a loop in your code looking at everything
O(n^2) often means you have a nested loop looking at everything more than once

// ===============================


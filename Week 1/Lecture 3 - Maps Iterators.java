// ### Lecture 3 Maps and Iterators ###
/* Map: Holds a set of unique keys and values.  Each key is associated 
        with one value */

put(key, value) // if you put a pre-existing key, it REPLACES the value.

// Implementing a map with ArrayDictionary<K, V>
// two pieces of information are stored at once
Map arrayMapExample = new ArrayDictionary<K, V>()
put(key, value)  // O(n) linear time.  Must check if key already exists
get(key)		 // O(n) linear time
containsKey(key) // O(n) linear time
remove(key)		 // O(n) linear time
size()			 // O(1) constant time

// Implementing a map with LinkedDictionary<K, V>
// It's ok to change the value of a key when using put()
Map linkedMapExample = new LinkedDictionary<K, V>()
put(key, value)  // O(n) linear time.  Must check if key already exists
get(key)		 // O(n) linear time
containsKey(key) // O(n) linear time
remove(key)		 // O(n) linear time
size()			 // O(1) constant time
// ===============================

/* Traversing Data
Given a collection, chances are at some point you're going to want
to see everything in it.

In an array iteration often looks like a for loop.
In a list, it's often using the size() method, which is also a forloop. */

// foreach loops, another method, are an example of iterator.
for (T item : list) {
	System.out.println(item);
}

// ===============================

/* Iterators

Iterators: A Java INTERFACE (not an ADT) that dictates how to travel through
a collection of data.  It can only move forward. */
hasNext() // return true if the iteration has elements it hasn't examined yet
next()	  // returns the next element in the iterator, and moves index forward

// ArrayList is an iterable structure.  You can call the .iterator() method on it
ArrayList<Integer> list = new ArrayList<Integer>();
Iterator itr = list.iterator();

// ===============================
/* Testing your code
Software Test: a separate piece of code that exercises the code you are
assessing by providing input to your code.
1. Isolate - break your code into small modules
2. Build in increments - Make a plan from simplest to most complex cases
3. Test as you go - As your code grows, so should your tests 

Black box tests
- Behavior only
- From an outside point of view
- Does your code uphold its contracts with its users?
- Performance/efficiency

White box tests
- Includes an understanding of the implementation
- Written by the author as they develop their code
- Break apart requirements into smaller steps
- "unit tests" break implementation into single assertions

What do I test?
- Expected behavior
- Forbidden input
- Empty/Null
- Boundary/Edge cases
- Scale (10, 100, 100,000 items) */

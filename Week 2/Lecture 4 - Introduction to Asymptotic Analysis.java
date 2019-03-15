/* ### INTRODUCTION TO ASYMPTOTIC ANALYSIS ###

Algorithm Analysis
How do we compare two pieces of code to find the better one?
- Time needed to run (WE CARE MOST ABOUT THIS IN THIS COURSE.)
- Memory used
- Number of network calls (if we working with external entities)
- Amount of data saved to disk
- Specialized vs generalized
- Code reusability
- Security

Given 3 algorithms and their runtime, it's impossible to know
which one is the "best".  Too many other variables are involved
Algorithm 1 // 1 ms
Algorithm 2 // 30 ms
Algorithm 3 // 100 ms 

Review: Sequential Search
Iterating through an array or list looking for a specific target value.
What are the best and worst cases in terms of runtime?

- The best case scenario is O(1) constant time when item is index 1 
- The worst case is O(n) linear time when index of item is at the very end 

Review: Binary Search
Locating a target value in a sorted array/list by eliminating half the array
at a time
- The best case scenario is O(1) constant time when item is at index n/2
- worst case is O(log(n))? It will never have to iterate over more 
than half the list

Asymptotic Analysis
the process of mathematically representing runtime of an algorithm in relation to
the number of inputs and how that relationship changes as the number of inputs 
grow.  This is a two step process.
	1. Model - Reduce code runtime to a mathematical relationship with the
	   number of inputs
	2. Analyze - Compute runtime/input relationship across multiple algorithms

PART ONE - Code Modeling 
The process of mathematically representing HOW MANY OPERATIONS a piece of code
will run in relation to the number of inputs n

Examples: 
Sequential search f(n) = n
Binary search f(n) = log2(n)

DETAILED EXAMPLE */
// compares to see if array has consecutive pair of elements
// HOW TO COUNT OPERATIONS:
// 1. Start with basic operations and work inside out
// Each basic operation is +1
// Conditionals--consider the worst case test branch
// loop = iterations
public boolean hasDuplicate2(int[] array) {
	for(int i = 0; i < array.length - 1; i++) {
		if (array[i] == array[i + 1]) { // +4 this whole conditional is 5
			return true; // +1
		}
	}
	return false; // +1
}


// ===============================
/* ### LECTURE 5 COMPARING FUNCTIONS ###

FUNCTION GROWTH
imagine you have the following algorithms to choose between that have
already been reduced to their mathematical model
f(n) = n
g(n) = 4n
h(n) = n^2 // since this graph is so dramatically different, 4n vs n is so similar
           // is arbitrarily referred to as the same

// =============================

COMPLEXITY CLASS
	Complexity class - Category of algorithm efficiency based on the 
	algorithm's relationship to the input of size N

O(1)
O(log2 n)
O(n)
O(nlog2 n)
O(n^2)
O(n^3)
O(n^c)
O(c^n)

// =============================
MOVING FROM MODEL TO COMPLEXITY CLASS
Let's say an algorithm runs in 0.4N^3 + 25N^2 + 8N + 17

1. Assume runtime of N is gigantic
2. Since 17 would be dwarfed by the other inputs, we can ignore it
3. Constant coefficients like 25 or 8 become INSIGNIFICANT
4. N^3 is so powerful that nothing else matters.  It dominates the rate of change
5. This model just simplifies to O(N^3)

Another example:
10n(log n) + 3n = O(nlog n)
5(n^2)logn + 13n^3 = O(n^3)

// =============================
DEFINITION OF BIG-O

f(n) is O(g(n)) if there exists positive constants c, n0.  For all values of 
n >= n0, f(n) <= c * g(n)

Basically if one term dominates an entire function, that term is g(n).  Since
this is not always the case, n0 defines the range when the domination begins and
the model is relevant.

Example - 
Show that f(n) = 10n + 15 is O(n).  Apply the definition term by term.
1. 10n <= c * n. when c = 10 and for all n values
2. 15 <= c * n when c = 15 and when n >= 1
3. Since this stuff applies to each term, it qualifies as O(n)
4. Add all your truths. 10n + 15 <= 10n + 15n <= 25n  ||  when n>= 1

Example -5n^2 + 3n + 6
1. 5n^2 <= 5 * n^3 when c = 5 and for all values of n
2. 3n <= 3 * n^3 when c = 3 and for all values of n
3. 6 <= 6 * n^3 when c = 1 and when n >= 2 // c can be anything
4. 5n^2 + 3n + 6 <= 5n^3 + 3n^3 + n^3 for n>= 2

Edge Cases
True or False: 10n^2 + 15n is O(n^3)
This is actually true, because the definition of O(n) encompasses it and any
speed faster than it.  So even though the tightest bound for this equation is
O(n^2), you can still call it O(n^3).  This is because Big O represents an
upper bound, and it's allowed to be anything underneath it.

Why does Big-O matter?
We've already intuitively understood what Big O is from 143.  This is to 
familiarize ourselves with the concept which is a much bigger deal

Examples:
True or false--are these functions f(n) dominated by the function g(n)?
DOMINANT INCLUDES EQUIVALENCE, NOT JUST BEING GREATER THAN.
f(n) = n << g(n) = 5n + 3			// all linear functions are equivalent
f(n) = 5n + 3 << g(n) = n 			// Both in linear time
f(n) = 5n + 3 << g(n) = 1			// false.  g(n) is in constant time
f(n) = 5n + 3 << g(n) = n^2			// True. Quadratic dominates linear
f(n) = n^2 + 3n + 2 << g(n) = n^3	// True. n^3 is a higher degree
f(n) = n^3 << g(n) = n^2 + 3n + 2	// False.  Lower power

// =============================
BIG-OMEGA & BIG-THETA
Big-Omega represents the lower bound--the best case runtime scenario.

Big-O is the upper bound, representing at MOST how long code takes to run.
How about if I want to find big-Omega?

f(n) is omega(g(n)) if there exists positive constants c, n0 such that for all
n >= n0, f(n) >= c*g(n).  It's the same as the big O equation but with the sign
flipped.

f(n) is theta(g(n)) if the O(g(n)) and the omega(g(n)) of the function are EQUAL.

// =============================
VIEWING BIG O AS A CLASS

Big-O alternative definition; You can write that f(n) is in the set of O(g(n)).
g(n) represents all possible n runtime equations.

Examples:
4n^2 is in the set of omega(1) // yes--constant functions as the lower bound of n^2
4n^2 is in the set of omega(n) // yes--n acts as a lower bound
4n^2 is in the set of omega(n^2) // yes-- they equal
4n^2 is in the set of O(1) // no--O(n) represents an upper bound and this function is
						   // higher order than that

// =============================
MODELING RECURSION */
public int factorial (int n) {
if (n == 0) || n == 1) {
	return 1;
} else {
	return n * factorial(n - 1);
}

}
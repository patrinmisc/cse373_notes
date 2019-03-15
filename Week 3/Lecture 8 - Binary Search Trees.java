/* ### Lecture 8 - Binary Search Trees ###
Warm up - Tree Method
T(n) = { 4 when n <= 1
	   { 3T(n/4) + cn^2 otherwise

Notice that each node calls the method `3` times each.  In the tree,
you'll add 3 more nodes per level.
You're dividing n by `4` every single level as well.

log4 (n) is the number of levels there will end up being.

How many nodes on each branch level? 3^i
How much work for each branch node? c(n/4^i)^2
How much work per branch level?  3^ic(n/4^i)^2 = (3/16)^i * cn^2

// =======================

SOLVING RECURRENCES
How do we go from code model to big O?
1. Explore the recursive pattern
2. Write a new model in terms of `i`
3. Use algebra simplify the T away
4. Use algebra to find closed form

There is an easier equation for Big Theta, but not for Big O
Given the following:
T(n) = { d when n = 1
	   { aT(n/b) + n^c otherwise

if logb (a < c) then T(n) is in the set of theta(n^c)
if logb (a = c) then T(n) is in the set of theta(n^c * log2 (n))
if logb (a > c) then T(n) is in the set of theta(n^logb (a))

// =======================
TREES 
Storing Sorted Items in an Array.  From here on out, log of something
means log base 2 */
get()		// O(log n)
put()		// O(n)
remove()	// O(n)
/* 
Tree - A collection of nodes with at most 1 parent, and 0+ children
Root Node - A single node with no parent--the top of the tree
Branch node - A node with 1+ children
Leaf node - A node with no children
Edge - A pointer from one node to another
Subtree - A node and all of its descendants
Height - The number of edges contained in the longest path from the root node
		 to some leaf node

Traversal - An examination of all of the elements in the tree.  Often done in
			certain orderings--preorder, in-order, post-order traversals, etc
			Don't forget the sailboat method where you're sailing around the tree.

The Binary Search Tree - Every left pointer of a node points to a value less than
						 the current node, and every pointer on the right points
						 to something larger than the current node's data.

To do something like implement a dictionary is easy with BST. Lets us quickly
find what we're searching for, and add/remove values with ease

Dictionary Operations:
Runtime is described in terms of height "h". */
get()	// O(h)
put()	// O(h)
remove() // O(h)  This is tricky.  There's a lot of things you can replace with
		 // either replace the node with the node immediately to the left, or go
		 // right one and then left one and that value will work as well

/* HEIGHT IN TERMS OF NODES FOR BALANCED TREES
h = logc (n) where c is the number of branches allowed per node

// =================================

UNBALANCED TREES
Degenerate trees - Worst case runtime is O(n), best case O(logn).  Note that
this isn't the same as trees which are O(h).  
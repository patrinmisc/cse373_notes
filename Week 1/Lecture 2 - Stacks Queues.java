// ### Lecture 2 - Stacks Queues ###

/* List ADT tradeoff

- Time needed to ACCESS i-th element
	- O(1) Constant time.  You can directly touch the datapoint
	- O(n) linear time, because you have to iterate through each 
	  node one by one until you get to your datapoint.

- Time needed to INSERT at i-th element
	- ArrayList: O(n).  You have to iterate through to find your desired index
	- LinkedList: O(n).  You have to iterate through to find your desired index
- Amount of space used overall
	- ArrayList: Sometimes wasted space.  Can matter on large scale databases
	- LinkedList: Referred to as compact.  Only creates space when necessary
- Amount of space used per element
	- ArrayList: Minimal
	- LinkedList: A tiny bit more. Is an object, and requires a reference field 

// ===============================
// What implementation of List works best for each situation?

1. Write a data structure that implements the List ADT that will be used to store
   a list of songs in the playlist.
   	- LinkedList, because it is optimized for growth of list and 
   	  movement of songs
2. Write a data structure that implements the List ADT that will be used to store
   the history of a bank customer's transactions.
    - ArrayList, because people will want to randomly access specific 
      transactions
3. Write a data structure that implements the List ADT that will be used to store 
   the order of students waiting to speak to a TA at a tutoring center
    - Queues HAHA TRICK QUESTION gotcha
    - LinkedLists generally are optimized for removal from the front
    - ArrayLists are generally optimized for addition to the back
*/

/* Stacks and Queues

// ===============================
// Review: What is a stack?
A collection based on the principle of adding elements and retrieving them in
opposite order.
- Last in, first out("LIFO")
- Lunch trays or shirts in your drawer.  The one you put in the most recently is
  the one that's going to be taken out first */

// Implementing a stack with an ArrayStack<E>
Stack<E> arrayExample = new ArrayStack<E>()
push(item) 	// O(n) linear time
pop() 		// O(1) constant time
peek() 		// O(1) constant time
size() 		// O(1) constant time
isEmpty() 	// O(1) constant time

// Implementing a stack with a LinkedStack<E>
// items are always added to front
Stack<E> linkedExample = new ArrayStack<E>()
push(item) 	// O(1) constant time
pop() 		// O(1) constant time
peek() 		// O(1) constant time
size() 		// O(1) constant time
isEmpty() 	// O(1) constant time

// ===============================
/* Review: What is a queue?
Retrieves elements in the order they were added
- First in, first out("FIFO")
- Works like a line to a cash register. */

// Implementing a queue with ArrayQueue<E>
// stores an int var to track where the front of the line is
Queue<E> arrayExample = new ArrayQueue<E>()
add() 		// O(n) linear time
remove() 	// O(1) constant time
peek() 		// O(1) constant time
size() 		// O(1) constant time
isEmpty()  	// O(1) constant time

// Implementing a queue with LinkedQueue<E>
// stores a 'back' pointer so that you don't have to iterate through it
Queue<E> linkedExample = new LinkedQueue<E>()
add() 		// O(1) constant time
remove() 	// O(1) constant time
peek() 		// O(1) constant time
size() 		// O(1) constant time
isEmpty()  	// O(1) constant time

// ===============================
/* Review: Generics
A parameterized class.  Forces a client to supply a type to build your
data structure. */
// Often referred to by E to represent "element"
List genericExample = new ArrayList<E>();
List genericExample = new ArrayList<Integer>(); // can specify anything
List genericExample = new ArrayList<String>();	// that fits the context
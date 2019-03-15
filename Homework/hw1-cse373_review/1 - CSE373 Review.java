// ### HW 1 ###
// Week 1/Week 2
// Maps, LinkedLists
// a series of practiceit questions
/* https://courses.cs.washington.edu/courses/cse373/19wi/files/
homework/homework01.pdf */

// ============================= QUESTION 1 // Maps
/*Write a method intersect that takes two Maps of strings to integers 
as parameters and that returns a new map whose contents are the 
intersection of the two. 
The intersection of two maps is defined here as the set of keys 
and values that exist in both maps.
parameters
{Janet=87, Logan=62, Whitaker=46, Alyssa=100, Stefanie=80, Jeff=88, Kim=52}
{Logan=62, Kim=52, Whitaker=52, Jeff=88, Stefanie=80, Brian=60, Lisa=83}
returns
{Logan=62, Stefanie=80, Jeff=88, Kim=52} */

public Map<String, Integer> intersect(Map<String, Integer> a, 
									   Map<String, Integer> b) {
    Map<String, Integer> output = new TreeMap<String, Integer>();
    for (String i : a.keySet()) {
        if (b.containsKey(i)) {
            if (a.get(i) == b.get(i)) {
                output.put(i, a.get(i));    
            }
        }
    }
    return output;
}

// ============================= QUESTION 2 // Maps
/* Write a method contains3 that accepts a List of strings as a 
parameter and returns true if any single string occurs at least 3 
times in the list, and false otherwise. Use a map as auxiliary storage. */

public boolean contains3(List<String> input) {
    Map<String, Integer> count = new TreeMap<String, Integer>();
    for (String i : input) {
        if (count.containsKey(i)) {
            count.put(i, count.get(i) + 1);
            if (count.get(i) >= 3) return true;
        } else {
            count.put(i, 1);   
        }
    }
    return false;
}

// ============================= QUESTION 3 // LinkedList
/* Write the code necessary to convert the following sequence of 
ListNode objects:
list -> [5] -> [4] -> [3] /
Into this sequence of ListNode objects:
list -> [3] -> [4] -> [5] /					*/

ListNode temp = list.next.next;
list.next.next = list;
temp.next = list.next;
list.next = null;
temp.next.next = list;
list = temp;

// ============================= QUESTION 4 // LinkedList
/* Write a method firstLast that could be added to the LinkedIntList
 class that moves the first element of the list to the back end of 
 the list. Suppose a LinkedIntList variable named list stores the 
 following elements from front (left) to back (right):
[18, 4, 27, 9, 54, 5, 63]
If you made the call of list.firstLast();, the list 
would then store the elements in this order:
[4, 27, 9, 54, 5, 63, 18] */

private void firstLast() {
    if (front != null && front.next != null) {
        ListNode temp = front;
        front = front.next;
        ListNode index = front;
        while (index.next != null) {
            index = index.next;
        }
        index.next = temp;
        temp.next = null;
    }
}

// ============================= QUESTION 5 // LinkedList
/* Write a method shift that rearranges the elements of a list of 
integers by moving to the end of the list all values that are in 
odd-numbered positions and otherwise preserving list order. For example,
suppose a variable list stores the following values:
[0, 1, 2, 3, 4, 5, 6, 7]
The call of list.shift(); should rearrange the list to be:
[0, 2, 4, 6, 1, 3, 5, 7] */

public void shift() {
    ListNode end;
    ListNode index = front;
    if (front != null && front.next != null) {
        // get end pointer
        int size = 1;
        while (index.next != null) {
            index = index.next;
            size++;
        }
        end = index;
        
        // move odd indexes to the back using end pointer
        if (size >= 3) {
            index = front;
            for (int i = 0; i < size - 1; i++) {
                if (i % 2 == 0) {
                    ListNode temp = index.next;
                    index.next = temp.next;
                    end.next = temp;
                    temp.next = null;
                    end = temp;
                } else {
                    index = index.next;
                }
            }
        }
    }
}

// ============================= QUESTION 6 // Binary Trees
/* Write a method depthSum that returns the sum of the values stored in 
a binary tree of integers weighted by the depth of each value. 
You should return the value at the overallRoot plus 2 times the values 
stored at the next level of the tree plus 3 times the values stored at the
next level of the tree plus 4 times the values stored at the next level 
of the tree and so on.  */

public int depthSum() {
    return(depthSumHelper(overallRoot, 1));
}

private int depthSumHelper(IntTreeNode i, int depth) {
    if (i != null) {
        return(depth * i.data
                    + depthSumHelper(i.left, depth + 1)
                    + depthSumHelper(i.right, depth + 1));
    } else {
        return 0;
    }
}

// ============================= QUESTION 7 // Binary Trees
/* Write a method numberNodes that changes the data stored in a 
binary tree, assigning sequential integers starting with 1 to each
node so that a pre-order traversal will produce the numbers in 
order(1, 2, 3, etc.). */

public int numberNodes() {
    return numberNodesHelper(overallRoot, 0);    
}

private int numberNodesHelper(IntTreeNode i, int index) {
    if (i != null) { // general recursive case
        index++;
        i.data = index;
        index = numberNodesHelper(i.left, index);
        index = numberNodesHelper(i.right, index);
        return index;
    } else { // edge recursive case
        return index;    
    }
}

// ============================= QUESTION 8 // Binary Trees
/* Write a method removeLeaves that removes the leaves from a tree. 
A leaf node that has empty left and right subtrees. If a variable tree 
refers to the first tree below, the call of tree.removeLeaves(); should 
remove the four leaves from the tree */

// if you write down 'prev' as null instead of 'overallRoot', there
// will be a point in the code where it checks for prev.left and prev.right.
// it will throw a nullpointerexception as a result
public void removeLeaves() {
    removeLeavesHelper(overallRoot, overallRoot); // use overallRoot for prev
}

private void removeLeavesHelper(IntTreeNode i, IntTreeNode prev) {
    if (i == null) return;
    
    // check if leaf node
    if (i.left == null && i.right == null) {
        // delete current node
        if (prev.left == i) prev.left = null;
        else if (prev.right == i) prev.right = null;
        else overallRoot = null;
    }
    removeLeavesHelper(i.left, i);
    removeLeavesHelper(i.right, i);
}

// ============================= QUESTION 9 // Binary Trees
/* Write a method tighten that eliminates branch nodes that 
have only one child. */
public void tighten() {
    overallRoot = tighten(overallRoot);
}

private IntTreeNode tighten(IntTreeNode i) {
    if (i == null) return null; // end case
    
    if (i.left == null && i.right != null) { // general case
        return tighten(i.right);
    } else if (i.left != null && i.right == null)  {
        return tighten(i.left);
    } else {
        i.left = tighten(i.left);
        i.right = tighten(i.right);
        return i;
    }
}

// ============================= QUESTION 10 // Binary Trees
/* Write a method trim that could be added to the IntTree class. 
The method accepts minimum and maximum integers as parameters and 
removes from the tree any elements that are not within that range, 
inclusive. For this method you should assume that your tree is a binary 
search tree (BST) and that its elements are in valid BST order. Your 
method should maintain the BST ordering property of the tree. */

public void trim(int min, int max) {
    overallRoot = trimHelper(overallRoot, min, max);
}

private IntTreeNode trimHelper(IntTreeNode i, int min, int max) {
    if (i == null) return null; // end case
    
    if (i.data < min) { // general case
        return trimHelper(i.right, min, max);
    } else if (i.data > max) {
        return trimHelper(i.left, min, max);
    } else {
        i.left = trimHelper(i.left, min, max);
        i.right = trimHelper(i.right, min, max);
        return i;
    }
}
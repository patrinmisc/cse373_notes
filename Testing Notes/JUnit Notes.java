// ### What is JUnit? ###
// https://courses.cs.washington.edu/courses/cse373/19wi/resources/junit/
// A JUnit test suite is any class with at least one method marked as @Test.
// Each method marks with @Test is referred to as a single unit test.

// This JUnit class has absolutely two units
import static org.junit.Assert.assertTrue;	// unit tests ALWAYS have an assert
import org.junit.Test;				

import datastructures.concrete.DoubleLinkedList;
import datastructures.interfaces.IList;

import misc.Cse373BaseTest;

public class TestDoubleLinkedListSimple extends Cse373BaseTest {
    @Test
    public void testAddAndRemove() {	
        IList<Integer> list = new DoubleLinkedList<>();

        list.add(3);
        list.add(7);
        list.add(9);

        assertTrue(list.remove() == 9); // does nothing if it evaluates to true
        assertTrue(list.remove() == 7); // causes the test to fail if it's false
        assertTrue(list.remove() == 3);
    }

    @Test(timeout=1000) // intentionally fails test after 1 second has passed
    public void testSize() {
        IList<Integer> list = new DoubleLinkedList<>();

        int amount = 5134;

        for (int i = 0; i < amount; i++) {
            list.add(i);
        }

        assertTrue(list.size() == amount);
    }

    // it's also possible to add helper methods.  Just don't label them @Test
}

// ==========================================================
// Testing that you're producing the right exception
// this is a big awkward.

@Test(timeout = 1000)
public void testRemoveCorrectlyThrowsEmptyContainerException() {
    IList<Integer> list = this.makeList();

    try {
        // Since we're trying to see what exception `remove` throws,
        // we do so in a try catch
        list.remove();

        // This is if you somehow succeeded LOL.  But like you're trying to
        // fail it on purpose to see what exception it throws so this is
        // not what you want
        fail("Expected an EmptyContainerException");

    } catch (EmptyContainerException ex) {
        // you did it! remove threw the exception we wanted to.  You can
        // opt to do nothing or you can opt to just assertTrue(true) to
        // denote that you passed this test.
    }

    // If the method somehow throws a *different* unexpected exception,
    // the "catch" block won't catch it and the test will fail.
    // For example, if list.remove() could throw a NullPointerException.
}
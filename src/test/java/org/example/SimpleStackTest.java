package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // When a freshly stack is created
        Stack stack = new SimpleStack();

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test the push of two items")
    public void testPushTwoItems() throws EmptyStackException {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");
        assertSame( item, stack.peek(),"The pushed item must be is on top of the stack");

        // Given a new item to add
        Item item2 = new SimpleItem();

        // When we add the new item
        stack.push(item2);

        // then...
        assertFalse(stack.isEmpty(), "The stack must be not empty");
        assertEquals(2, stack.getSize(),"The stack must constain 2 items");
        assertSame( item2, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test the push of one item")
    public void testPushOneItem() throws EmptyStackException {
        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");
        assertSame( item, stack.peek(),"The pushed item must be is on top of the stack");

    }

    @Test
    @DisplayName("Test the push of one item null")
    public void testPushOneItemNullException() throws EmptyStackException {
        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        assertThrows(NullPointerException.class, ()->stack.push(null), "NullPointerException not thrown");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStackException()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "pop" the stack, should throws an EmptyStackException.
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test limit when trying to peek an empty stack")
    public void testPeekOnEmptyStackException()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "peek" the stack,
        // Then should throws an EmptyStackException.
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test the pop of two items")
    public void testPopTwoItems() throws EmptyStackException {

        // Given a stack with 2 items
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();
        Item item2 = new SimpleItem();
        stack.push(item);
        stack.push(item2);

        // When we "pop" the stack
        Item poppedItem = stack.pop();

        // Then
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");
        assertEquals(item2, poppedItem, "The item popped must be the same as last pushed");

        // When we "pop" the stack
        poppedItem = stack.pop();

        // Then
        assertTrue(stack.isEmpty(), "The stack must be empty");
        assertEquals(0, stack.getSize(),"The stack must constain 0 item");
        assertEquals(item, poppedItem, "The item popped must be the same as first pushed");
    }

    @Test
    @DisplayName("Test the pop of one items")
    public void testPopOneItem() throws EmptyStackException {

        // Given a stack with 2 items
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();
        stack.push(item);

        // When we "pop" the stack
        Item poppedItem = stack.pop();

        // Then
        assertTrue(stack.isEmpty(), "The stack must be empty");
        assertEquals(0, stack.getSize(),"The stack must constain 0 item");
        assertEquals(item, poppedItem, "The item popped must be the same as first pushed");
    }

    @Test
    @DisplayName("Test the peek of items")
    public void testPeek() throws EmptyStackException {

        // Given a stack with 2 items
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();
        Item item2 = new SimpleItem();
        stack.push(item);
        stack.push(item2);

        // When we "peek" the stack
        Item peekedItem = stack.peek();

        // Then
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(2, stack.getSize(),"The stack must constain 2 items");
        assertEquals(item2, peekedItem, "The item peeked must be the same as last pushed");
    }
}

/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		//assertEquals("Remove: check prev attachment ", list1.head, list1.get(0).prev);
		
		// TODO: Add more tests here
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			longerList.remove(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		int i = 5;
		int b = longerList.remove(i);
		assertEquals("Remove: check b is correct ", i, b);
		String text = "Remove: check element " + i + " is correct ";
		assertEquals(text, (Integer)(i+1), longerList.get(i));
		assertEquals("Remove: check size is correct ", LONG_LIST_LENGTH-1, longerList.size());
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try {
			shortList.add(null);
			fail("Check null");
		}
		catch (NullPointerException e) {
			
		}
		
		emptyList.add(1);
		assertEquals("Add at end: size ", 1, emptyList.size());
		shortList.add("C");
		assertEquals("Add at end: size short", 3, shortList.size());
		assertEquals("Add at end: last element", "C", shortList.get(shortList.size()-1));
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Size: empty ", 0, emptyList.size());
		assertEquals("Size: long list ", LONG_LIST_LENGTH, longerList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			shortList.add(0, null);
			fail("Check null");
		}
		catch (NullPointerException e) {
			
		}
		
		try {
			longerList.add(-1, 5);
			fail("Check index range");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		try {
			longerList.add(LONG_LIST_LENGTH + 1, 5);
			fail("Check index range");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		emptyList.add(0,1);
		assertEquals("Add at index: empty 0 correct ", (Integer) 1, emptyList.get(0));
		
		shortList.add(0,"Z");
		assertEquals("Add at index: short 0 correct ", "Z", shortList.get(0));
		assertEquals("Add at index: short 1 correct ", "A", shortList.get(1));
		assertEquals("Add at index: short size ", 3, shortList.size());
		
		longerList.add(LONG_LIST_LENGTH, 10);
		assertEquals("Add at index: long end correct ", (Integer) 10, longerList.get(LONG_LIST_LENGTH));
		assertEquals("Add at index: short size ", LONG_LIST_LENGTH + 1, longerList.size());
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			shortList.set(0, null);
			fail("Check null");
		}
		catch (NullPointerException e) {
			
		}
		
		try {
			emptyList.set(0, 5);
			fail("Check index range");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			longerList.set(-1, 5);
			fail("Check index range");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			longerList.set(LONG_LIST_LENGTH, 5);
			fail("Check index range");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		shortList.set(0, "Z");
		assertEquals("Set: short begin ", "Z", shortList.get(0));
		
		shortList.set(1, "Y");
		assertEquals("Set: short later ", "Y", shortList.get(1));
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}

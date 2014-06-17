package com.csci4370.test;

import junit.framework.TestCase;

import org.junit.Test;

import com.csci4370.impl.Table;

public class TableTypeCheckTest extends TestCase {

	private Class[] testDomain;
	private Class[] testSingleDomain;
	private Comparable[] testSingleTuple;
	private Comparable[] testSingleTupleRepeat;
	private Comparable[] testTuples;
	private Comparable[] testInvalidTuples;
	
	protected void setUp() {
		
		testDomain = new Class[] {Double.class, String.class, Integer.class, Byte.class};
		testSingleDomain = new Class[] {String.class};
		testTuples = new Comparable[] {"Testing", 1000.00, 2345678, "This class is acceptable", Byte.MAX_VALUE};
		testSingleTuple = new Comparable[] {"Testing"};
		testSingleTupleRepeat = new Comparable[] {"This", "Is", "A", "Test"};
		testInvalidTuples = new Comparable[] {"Testing", 1000.00f};
		
	}
	
	@Test
	public void testValidCheck() {
		assertTrue(Table.typeCheck(testTuples, testDomain));
	}
	
	@Test
	public void testSingleCheck() {
		assertTrue(Table.typeCheck(testSingleTuple, testSingleDomain));
		assertTrue(Table.typeCheck(testSingleTupleRepeat, testSingleDomain));
	}
	
	@Test
	public void testInvalidCheck() {
		assertFalse(Table.typeCheck(testInvalidTuples, testDomain));
	}
	
	@Test
	public void testNullAcceptane() {
		assertFalse(Table.typeCheck(null, testDomain));
		assertFalse(Table.typeCheck(testTuples, null));
		assertFalse(Table.typeCheck(null, null));
	}

}

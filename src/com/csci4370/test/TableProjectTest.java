package com.csci4370.test;

/****************************************************************************************
 * @file TableProjectTest.java
 *
 * @author Vincent Lee
 */

import static java.lang.System.out;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.csci4370.impl.Table;

/****************************************************************************************
 * This class implements tests for the relational algebra operator: PROJECT
 * 
 * A test with no duplicates is preformed.
 * Duplicate tests are also preformed to correctly verify rows returned.
 * 
 * A debug switch is included to turn off console print outs.
 * 
 */
public class TableProjectTest {
	// Testing data
	private Table movie;
	private static final boolean DEBUG = false;
	
	//Create the testing data
	@SuppressWarnings("rawtypes")
	@Before
	public void setUp() throws Exception {
		movie = new Table("movie",
				"title year length genre studioName producerNo",
				"String Integer Integer String String Integer", "title year");
		
		Comparable[] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
		Comparable[] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
		Comparable[] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
		Comparable[] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
		if (DEBUG) out.println();
		movie.insert(film0);
		movie.insert(film1);
		movie.insert(film2);
		movie.insert(film3);
		if (DEBUG) movie.print();
	}
	
	@Test
	public void testProject() {
		Table t_project = movie.project("title year");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 4);
	}
	
	@Test
	public void testDuplicate() {
		Table t_project = movie.project("length genre");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 3);
	}
	
	@Test
	public void testDuplicate1() {
		Table t_project = movie.project("length studioName");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 3);
	}
	
	@Test
	public void testDuplicate2() {
		Table t_project = movie.project("length producerNo");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 3);
	}
	
	@Test
	public void testDuplicate3() {
		Table t_project = movie.project("genre studioName");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 2);
	}
	
	@Test
	public void testDuplicate4() {
		Table t_project = movie.project("genre producerNo");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 3);
	}
	
	@Test
	public void testDuplicate5() {
		Table t_project = movie.project("studioName producerNo");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 3);
	}
	
	@Test
	public void testDuplicate6() {
		Table t_project = movie.project("length genre studioName");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 3);
	}
	
	@Test
	public void testDuplicate7() {
		Table t_project = movie.project("length genre producerNo");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 3);
	}
	
	@Test
	public void testDuplicate8() {
		Table t_project = movie.project("length studioName producerNo");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 3);
	}
	
	@Test
	public void testDuplicate9() {
		Table t_project = movie.project("genre studioName producerNo");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 3);
	}
	
	@Test
	public void testDuplicate10() {
		Table t_project = movie.project("length genre studioName producerNo");
		if (DEBUG) t_project.print();
		
		assertEquals("# of tuples", t_project.size(), 3);
	}
}

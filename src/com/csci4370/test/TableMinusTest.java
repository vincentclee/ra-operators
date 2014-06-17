package com.csci4370.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.csci4370.impl.Table;

public class TableMinusTest extends TestCase {
	

	private Table movie, movie2, cinema, movieStar;
	private static final boolean DEBUG = false;
	
	@Before
	public void setUp() {
		movie = new Table("movie",
				"title year length genre studioName producerNo",
				"String Integer Integer String String Integer", "title year");
		
		movie2 = new Table("movie2",
				"title year length genre studioName producerNo",
				"String Integer Integer String String Integer", "title year");

		cinema = new Table("cinema",
				"title year length genre studioName producerNo",
				"String Integer Integer String String Integer", "title year");

		movieStar = new Table("movieStar", "name address gender birthdate",
				"String String Character String", "name");

		Comparable[] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
		Comparable[] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
		Comparable[] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
		Comparable[] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
		Comparable[] film4 = { "Galaxy_Quest", 1999, 104, "comedy",
				"DreamWorks", 67890 };

		if (DEBUG) {
			System.out.println();
		}
		
		movie.insert(film0);
		movie.insert(film1);
		movie.insert(film2);
		movie.insert(film3);
		
		if (DEBUG) {
			movie.print();
		}
		
		Comparable[] film2a = { "Rocky", 1985, 200, "action", "Universal", 12125 };
		Comparable[] film3a = { "Rambo", 1978, 100, "action", "Universal", 32355 };
		Comparable[] film4a = { "Galaxy_Quest", 1999, 104, "comedy",
				"DreamWorks", 67890 };
		
		if (DEBUG) {
			System.out.println();
		}
		
		movie2.insert(film2a);
		movie2.insert(film3a);
		movie2.insert(film3a);
		
		if (DEBUG) {
			System.out.println();
		}
		
		cinema.insert(film2);
		cinema.insert(film3);
		cinema.insert(film4);
		
		if (DEBUG) {
			cinema.print();
		}
		
		Comparable[] star0 = { "Carrie_Fisher", "Hollywood", 'F', "9/9/99" };
		Comparable[] star1 = { "Mark_Hamill", "Brentwood", 'M', "8/8/88" };
		Comparable[] star2 = { "Harrison_Ford", "Beverly_Hills", 'M', "7/7/77" };
		
		if (DEBUG) {
			System.out.println();
		}
		
		movieStar.insert(star0);
		movieStar.insert(star1);
		movieStar.insert(star2);
		
		if (DEBUG) {
			movieStar.print();
		}
		
		Comparable[] cast0 = { "Star_Wars", 1977, "Carrie_Fisher" };
		Comparable[] cast1 = { "Star_Wars", 1976, "Mark_Hamill" };
		Comparable[] cast2 = { "Star_Wars", 1920, "Harrison_Ford" };
		

		Comparable[] exec0 = { 9999, "S_Spielberg", "Hollywood", 10000.00f };
		
		if (DEBUG) {
			System.out.println();
		}

		Comparable[] studio0 = { "Fox", "Los_Angeles", 7777 };
		Comparable[] studio1 = { "Universal", "Universal_City", 8888 };
		Comparable[] studio2 = { "DreamWorks", "Universal_City", 9999 };
	
	}// setUp
	
	
	@Test
	public void testMinus1() {
		Table t_minus1 = movieStar.minus(movieStar);
		if (DEBUG) {
			System.out.println();
			t_minus1.print();
		}

		assertEquals("testMinus1", t_minus1.size(), 0);
	}// testMinus1
	
	@Test
	public void testMinus2() {
		Table t_minus2 = movie.minus(cinema);
		if (DEBUG) {
			System.out.println();
			t_minus2.print();
		}

		assertEquals("testMinus2", t_minus2.size(), 2);
	}// testMinus2
	
	@Test
	public void testMinus3() {
		Table t_minus3 = movie.minus(movie2);
		if (DEBUG) {
			System.out.println();
			t_minus3.print();
		}

		assertEquals("testMinus3", t_minus3.size(), 2);
	}// testMinus2
	
	
}

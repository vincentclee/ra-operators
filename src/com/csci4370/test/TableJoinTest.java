package com.csci4370.test;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.csci4370.impl.Table;

public class TableJoinTest extends TestCase {
	private Table movie, cinema, movieStar, starsIn, movieExec, studio;
	private static final boolean DEBUG = false;

	@Before
	public void setUp() {
		movie = new Table("movie",
				"title year length genre studioName producerNo",
				"String Integer Integer String String Integer", "title year");

		cinema = new Table("cinema",
				"title year length genre studioName producerNo",
				"String Integer Integer String String Integer", "title year");

		movieStar = new Table("movieStar", "name address gender birthdate",
				"String String Character String", "name");

		starsIn = new Table("starsIn", "movieTitle movieYear starName",
				"String Integer String", "movieTitle movieYear starName");

		movieExec = new Table("movieExec", "certNo name address fee",
				"Integer String String Float", "certNo");

		studio = new Table("studio", "name address presNo",
				"String String Integer", "name");

		Comparable[] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
		Comparable[] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
		Comparable[] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
		Comparable[] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
		if (DEBUG)
			System.out.println();
		movie.insert(film0);
		movie.insert(film1);
		movie.insert(film2);
		movie.insert(film3);
		if (DEBUG)
			movie.print();

		Comparable[] film4 = { "Galaxy_Quest", 1999, 104, "comedy",
				"DreamWorks", 67890 };
		if (DEBUG)
			System.out.println();
		cinema.insert(film2);
		cinema.insert(film3);
		cinema.insert(film4);
		if (DEBUG)
			cinema.print();

		Comparable[] star0 = { "Carrie_Fisher", "Hollywood", 'F', "9/9/99" };
		Comparable[] star1 = { "Mark_Hamill", "Brentwood", 'M', "8/8/88" };
		Comparable[] star2 = { "Harrison_Ford", "Beverly_Hills", 'M', "7/7/77" };
		if (DEBUG)
			System.out.println();
		movieStar.insert(star0);
		movieStar.insert(star1);
		movieStar.insert(star2);
		if (DEBUG)
			movieStar.print();

		Comparable[] cast0 = { "Star_Wars", 1977, "Carrie_Fisher" };
		Comparable[] cast1 = { "Star_Wars", 1976, "Mark_Hamill" };
		Comparable[] cast2 = { "Star_Wars", 1920, "Harrison_Ford" };
		if (DEBUG)
			System.out.println();
		starsIn.insert(cast0);
		starsIn.insert(cast1);
		starsIn.insert(cast2);
		if (DEBUG)
			starsIn.print();

		Comparable[] exec0 = { 9999, "S_Spielberg", "Hollywood", 10000.00f };
		if (DEBUG)
			System.out.println();
		movieExec.insert(exec0);
		if (DEBUG)
			movieExec.print();

		Comparable[] studio0 = { "Fox", "Los_Angeles", 7777 };
		Comparable[] studio1 = { "Universal", "Universal_City", 8888 };
		Comparable[] studio2 = { "DreamWorks", "Universal_City", 9999 };
		if (DEBUG)
			System.out.println();
		studio.insert(studio0);
		studio.insert(studio1);
		studio.insert(studio2);
		if (DEBUG)
			studio.print();
	}// setUp

	@Test
	public void testJoin1() {
		Table t_join1 = movie.join("studioName", "name", studio);
		if (DEBUG) {
			System.out.println();
			t_join1.print();
		}

		assertEquals("testJoin1", t_join1.size(), 4);
	}// testJoin1

	@Test
	public void testJoin2() {
		Table t_join2 = movie.join("title year", "title year", cinema);
		if (DEBUG) {
			System.out.println();
			t_join2.print();
		}

		assertEquals("testJoin2", t_join2.size(), 2);
	}// testJoin2

	@Test
	public void testJoin3and4() {
		Table t_join3 = movieStar.join("name", "starName", starsIn);
		if (DEBUG) {
			System.out.println();
			t_join3.print();
		}

		assertEquals("testJoin3", t_join3.size(), 0);

		Table t_join4 = t_join3.join("movieYear", "year", movie);
		if (DEBUG) {
			System.out.println();
			t_join4.print();
		}

		assertEquals("testJoin4", t_join4.size(), 0);
	}// testJoin3

	@Test
	public void testJoin5() {
		Table t_join5 = movieExec.join("name", "name", studio);
		if (DEBUG) {
			System.out.println();
			t_join5.print();
		}

		assertEquals("testJoin5", t_join5.size(), 0);
	}// testJoin5
}// TableJoinTest

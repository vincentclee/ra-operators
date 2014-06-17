package com.csci4370.test;
import static java.lang.System.out;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.csci4370.impl.Table;
@SuppressWarnings("unused")
public class TableUnionTest {
	/**
	 * @author DBgroup
	 * This class tests RA function Union
	 */


		// testing data
		/**
		 * @param movie The table containing the movies
		 * @param cinema The table containing the cinemas
		 */
		private Table movie;
		private Table cinema;
		/**
		 * @param DEBUG for checking the state of the tables before pulling and pushing into them
		 */
		private static final boolean DEBUG = false;
		@SuppressWarnings("rawtypes")
		@Before
		/**
		 * This initializes the tables with appropriate data
		 * @throws Exception 
		 * 
		 */
		public void setUp() throws Exception {
			
			movie = new Table("movie",
					"title year length genre studioName producerNo",
					"String Integer Integer String String Integer", "title year");
			cinema = new Table("cinema",
					"title year length genre studioName producerNo",
					"String Integer Integer String String Integer", "title year");
			Table movieStar = new Table("movieStar",
					"name address gender birthdate",
					"String String Character String", "name");

			Table starsIn = new Table("starsIn", "movieTitle movieYear starName",
					"String Integer String", "movieTitle movieYear starName");

			Table movieExec = new Table("movieExec", "certNo name address fee",
					"Integer String String Float", "certNo");

			Table studio = new Table("studio", "name address presNo",
					"String String Integer", "name");
			
			Comparable[] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
			Comparable[] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
			Comparable[] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
			Comparable[] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
			if (DEBUG) {out.println();}
			movie.insert(film0);
			movie.insert(film1);
			movie.insert(film2);
			movie.insert(film3);
			if (DEBUG){ movie.print();}

			Comparable[] film4 = { "Galaxy_Quest", 1999, 104, "comedy",
					"DreamWorks", 67890 };
			if (DEBUG) {out.println();}
			cinema.insert(film2);
			cinema.insert(film3);
			cinema.insert(film4);
			if(DEBUG) {cinema.print();}
			Comparable[] star0 = { "Carrie_Fisher", "Hollywood", 'F', "9/9/99" };
			Comparable[] star1 = { "Mark_Hamill", "Brentwood", 'M', "8/8/88" };
			Comparable[] star2 = { "Harrison_Ford", "Beverly_Hills", 'M', "7/7/77" };
			if(DEBUG) out.println();
			movieStar.insert(star0);
			movieStar.insert(star1);
			movieStar.insert(star2);
			if(DEBUG) movieStar.print();

			Comparable[] cast0 = { "Star_Wars", 1977, "Carrie_Fisher" };
			if(DEBUG) out.println();
			starsIn.insert(cast0);
			if(DEBUG) starsIn.print();

			Comparable[] exec0 = { 9999, "S_Spielberg", "Hollywood", 10000.00 };
			if(DEBUG) out.println();
			movieExec.insert(exec0);
			if(DEBUG) movieExec.print();

			Comparable[] studio0 = { "Fox", "Los_Angeles", 7777 };
			Comparable[] studio1 = { "Universal", "Universal_City", 8888 };
			Comparable[] studio2 = { "DreamWorks", "Universal_City", 9999 };
			if(DEBUG) out.println();
			studio.insert(studio0);
			studio.insert(studio1);
			studio.insert(studio2);
			if(DEBUG) studio.print();
		}
		
		@Test
		/**
		 * This function tests the Union function. It passes a table to the funcion and do a union 
		 * with another table and checks the number of tuples that the new table should represents
		 * @testUnion it does a union on two tables, caller of union and its parameter table and checks
		 * whether the number of tuples matches as supposed
		 * @param t_union It is the table created by doing a union on two tables
		 *
		 */
		public void testUnion()
		{
			Table t_union = movie.union(cinema);
			/**
			 * assertEquals takes three parameters, the number of tuples, the actual size of the union table, 
			 * and the predicted number of tuples for checking the correctness.
			 * If the number of tuples is as predicted the test results are successful. 
			 */
			assertEquals("# of tuples",t_union.size(),7);
			
		}
		
		

}

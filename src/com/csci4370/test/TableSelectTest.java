package com.csci4370.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.csci4370.impl.Table;

public class TableSelectTest extends TestCase 
{
  private Table movie;
  private static final boolean DEBUG = false;

  @Before
  public void setUp()
  {
    movie = new Table("movie",
		      "title year length genre studioName producerNo",
		      "String Integer Integer String String Integer", "title year");
    
    Comparable[] film0 = { "Star_Wars", 1977, 124, "sciFi", "Fox", 12345 };
    Comparable[] film1 = { "Star_Wars_2", 1980, 124, "sciFi", "Fox", 12345 };
    Comparable[] film2 = { "Rocky", 1985, 200, "action", "Universal", 12125 };
    Comparable[] film3 = { "Rambo", 1978, 100, "action", "Universal", 32355 };
    Comparable[] film4 = { "Galaxy_Quest", 1999, 104, "comedy",
			   "DreamWorks", 67890 };

    if(DEBUG) System.out.println();
    movie.insert(film0);
    movie.insert(film1);
    movie.insert(film2);
    movie.insert(film3);
    movie.insert(film4);
    if(DEBUG) movie.print();
  }// setUp

  @Test
  public void testSelect1()
  {
    // title == "Star_Wars" AND year == 1977
    Table t_select1 = movie.select(t -> t[movie.col("title")].equals("Star_Wars") && 
				  t[movie.col("year")].equals(1977));
    if(DEBUG) t_select1.print();

    assertEquals("testSelect1", t_select1.size(), 1);
  }// testSelect1

  @Test
  public void testSelect2()
  {
    // length == 124
    Table t_select2 = movie.select(t -> t[movie.col("length")].equals(124));
    if(DEBUG) t_select2.print();

    assertEquals("testSelect2", t_select2.size(), 2);
  }// testSelect2

  @Test
  public void testSelect3()
  {
    // genre == "action"
    Table t_select3 = movie.select(t -> t[movie.col("genre")].equals("action"));
    if(DEBUG) t_select3.print();

    assertEquals("testSelect3", t_select3.size(), 2);
  }// testSelect3

  @Test
  public void testSelect4()
  {
    // producerNo > 0
    Table t_select4 = movie.select(t -> t[movie.col("producerNo")].compareTo(0) > 0);
    if(DEBUG) t_select4.print();

    assertEquals("testSelect4", t_select4.size(), 5);
  }// testSelect4

  @Test
  public void testSelect5()
  {
    /// genre == "sciFi" OR studioName == "Universal"
    Table t_select5 = movie.select(t -> t[movie.col("genre")].equals("sciFi") || 
				   t[movie.col("studioName")].equals("Universal"));
    if(DEBUG) t_select5.print();

    assertEquals("testSelect5", t_select5.size(), 4);
  }// testSelect5

  @Test
  public void testSelect6()
  {
    /// genre == "sciFi" AND studioName == "Universal"
    Table t_select6 = movie.select(t -> t[movie.col("genre")].equals("sciFi") && 
				   t[movie.col("studioName")].equals("Universal"));
    if(DEBUG) t_select6.print();

    assertEquals("testSelect6", t_select6.size(), 0);
  }// testSelect6
  
  @Test
  public void testSelect7()
  {
    // year <= 1980
    Table t_select7 = movie.select(t -> t[movie.col("year")].compareTo(1980) <= 0);
    if(DEBUG) t_select7.print();

    assertEquals("testSelect7", t_select7.size(), 3);
  }// testSelect7

  @Test
  public void testSelect8()
  {
    // exact match for galaxy quest
    Table t_select8 = movie.select(t -> t[movie.col("title")].equals("Galaxy_Quest") &&
				   t[movie.col("year")].equals(1999) &&
				   t[movie.col("length")].equals(104) &&
				   t[movie.col("genre")].equals("comedy") &&
				   t[movie.col("studioName")].equals("DreamWorks") &&
				   t[movie.col("producerNo")].equals(67890));
    if(DEBUG) t_select8.print();

    assertEquals("testSelect8", t_select8.size(), 1);
  }// testSelect8

  @Test
  public void testSelect9()
  {
    // title == "Blade_Runner"
    Table t_select9 = movie.select(t -> t[movie.col("title")].equals("Blade_Runner"));
    if(DEBUG) t_select9.print();

    assertEquals("testSelect9", t_select9.size(), 0);
  }// testSelect9

  @Test
  public void testSelect10()
  {
    // title != "Blade_Runner"
    Table t_select10 = movie.select(t -> !t[movie.col("title")].equals("Blade_Runner"));
    if(DEBUG) t_select10.print();

    assertEquals("testSelect10", t_select10.size(), 5);
  }// testSelect10
}// TableSelectTest

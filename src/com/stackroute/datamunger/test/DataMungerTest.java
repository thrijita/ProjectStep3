package com.stackroute.datamunger.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;
import com.stackroute.datamunger.reader.CsvQueryProcessor;

public class DataMungerTest {

	private static CsvQueryProcessor reader;

	@BeforeClass
	public static void init() throws FileNotFoundException {
		reader = new CsvQueryProcessor("data/ipl.csv");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void successRetrieveHeaderTestCase() throws IOException {
		Header result = reader.getHeader();

		assertEquals(new String[] { "id", "season", "city", "date", "team1", "team2", "toss_winner", "toss_decision", "result", "dl_applied", "winner", "win_by_runs", "win_by_wickets", "player_of_match", "venue", "umpire1", "umpire2", "umpire3" }, result.getHeaders());
		display("successRetrieveHeaderTestCase", result.toString());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void successRetrieveDataTypesTestCase() throws IOException {
		DataTypeDefinitions result = reader.getColumnType();

		assertEquals(new String[] { "java.lang.Integer", "java.lang.Integer", "java.lang.String", "java.lang.String", "java.lang.String", "java.lang.String", "java.lang.String", "java.lang.String", "java.lang.String", "java.lang.Integer", "java.lang.String", "java.lang.Integer", "java.lang.Integer", "java.lang.String", "java.lang.String", "java.lang.String", "java.lang.String", "java.lang.String" }, result.getDataTypes());
		display("successRetrieveDataTypesTestCase", result.toString());
	}

	@Test(expected = FileNotFoundException.class)
	public void fileNotFoundTestCase() throws IOException {
		reader = new CsvQueryProcessor("data/ipl2.csv");
		Header result = reader.getHeader();

	}
	
	@Test
    public void notNullHeaderTestCase() throws IOException {
        Header result = reader.getHeader();
        assertNotNull(result);
        display("notNUllHeaderTestCase", result.toString());
    }
	
	@Test
    public void notNullDataTypesTestCase() throws IOException {
        DataTypeDefinitions result = reader.getColumnType();
        assertNotNull(result);
        display("notNUllDataTypesTestCase", result.toString());
    }

	private void display(String testCaseName, String result) {
		System.out.println(testCaseName);
		System.out.println("----------------------------------------------");
		System.out.println(result);
	}

}
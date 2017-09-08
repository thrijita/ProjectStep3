package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {
	//declaring the file variable
	String file;

	//parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
		this.file=fileName;
		//fetched the file name and stored in variable as of now.
	}
	
	
	//implementation of getHeader() method
	@Override
	public Header getHeader() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader headerBuffer=new BufferedReader(new FileReader(file));
		Header header = new Header();
		header.setHeaders(headerBuffer.readLine().split(","));
		return header;
		//the header is derived here
	}
	
		
	/**
	 getDataRow() method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {
		

	}


	//implementation of getColumnType() method
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		// TODO Auto-generated method stub
		//reading the file name
		BufferedReader dataTypeBuffer=new BufferedReader(new FileReader(file));
		//getting the header count here
		int headerCount = dataTypeBuffer.readLine().split(",").length;
		//storing in temp variable
		String[] temp = dataTypeBuffer.readLine().split(",");
		DataTypeDefinitions dataTypeDefinitions = new DataTypeDefinitions();
		//storing the datatype
		String[] dataType = new String[headerCount];
		for (int index = 0; index < headerCount; index++) {
		try{
		Integer.parseInt(temp[index]);
		dataType[index]=Integer.class.getName();
		}
		catch(Exception e)
		{
		dataType[index]=String.class.getName();
		}
		}
		dataTypeDefinitions.setDataTypes(dataType);
		return dataTypeDefinitions;
		}
	}


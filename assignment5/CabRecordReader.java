package edu.trident.wingo.assignment5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CabRecordReader {
	ArrayList<CabSort> cabList = new ArrayList<CabSort>();
	int currentRecord = 0;
	String next;
	CabSort cab;
	Scanner input;
	boolean moreRecords;

	public CabRecordReader(String inputFile) {
		int lineCount = 0;
		try {
			input = new Scanner(new File(inputFile));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (input.hasNext()) {

			try {
				lineCount++;
				next = input.nextLine();
				String[] fields = next.split(",");

				if (fields.length >= 5) {
					cab = new CabSort(fields[0], fields[1], fields[2],
							fields[3], fields[4]);
					
				} else {
					cab = new CabSort(fields[0], fields[1], fields[2],
							fields[3], "0");
					
				}
				cabList.add(cab);
			} catch (Exception e) {
				System.err.println("Invalid line " + lineCount);
				System.err.println(e);
			}

		}
		input.close();
	}

	public boolean hasMoreRecords() {
		int size = cabList.size();
		return (size > currentRecord);
	}

	public CabRecord getNextRecord() {
		CabRecord cr = cabList.get(currentRecord);
		currentRecord++;
		return cr;
	}
}

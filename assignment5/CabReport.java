package edu.trident.wingo.assignment5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import edu.trident.wingo.assignment5.CabRecord.RecordType;

public class CabReport 
{
	public static void showInfo (ArrayList<CabRecord> list){

		for(CabRecord record : list)
			System.out.println(record.getDate());
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileAlreadyExistsException, IOException 
	{

		//SimpleDateFormat now = new SimpleDateFormat("yyyy/MM/dd");
		//DecimalFormat df = new DecimalFormat("#.##");

		List<CabInfo> cabList = new ArrayList<CabInfo>();	
		CabInfo cab;
		String inputFile = "C:/Users/Ksenia/Downloads/defaultRecords.csv";
		String outputFile = "C:/Users/Ksenia/Downloads/test.txt";
		//String inputFile = (JOptionPane.showInputDialog(null,"Enter read file path."));
		// String outputFile = (JOptionPane.showInputDialog(null,"Enter output file path"));
		File file = new File(outputFile);
		CabRecordReader reader = new CabRecordReader(inputFile);
		try{ 

			PrintWriter output = new PrintWriter(file);
			while(reader.hasMoreRecords())
			{
				CabRecord record = reader.getNextRecord();

				//cab = new CabInfo(record.getCabId());
				cab = null;
				for(int i =0; i<= cabList.size()-1; i++){
					if(record.getCabId().equals(cabList.get(i).getCabId()))
					{
						cab = cabList.get(i);
					}	
				}

				if(cab == null)
				{
					cab = new CabInfo(record.getCabId());
					cabList.add(cab);
					
				}

				if (record.getType() == RecordType.valueOf("SERVICE"))
				{
					cab.addService(new ServiceRecords(record.getCabId(),record.getDate(),record.getValue()));
				}
				else if (record.getType() == RecordType.valueOf("GAS"))
				{
					cab.addGas(new GasRecords(record.getCabId(),record.getDate(),record.getValue(),record.getPerGallonCost()));
				}
				else if (record.getType() == RecordType.valueOf("FARE"))
				{
					cab.addFare(new FareRecords(record.getCabId(),record.getDate(),record.getValue()));
					if(cab == null)
					{
						cab = new CabInfo(record.getCabId());
						cabList.add(cab);
						
					}			}

			}
			Collections.sort(cabList);
			cab = null;
			int i = 0;
			for(CabInfo taxi : cabList){
				taxi.sortList();
				
				System.out.println(cabList.get(i));
				System.out.println(cabList.size());
				System.out.println(taxi.gasList.getCabId);
				System.out.println(taxi.faresList.size());
				System.out.println(((ServiceRecords) taxi.servicesList.getServiceCostTotal()));
				i++;
				//taxi.getFirstDate(d1, d2, d3);
			}
			//System.out.(cabList);
			output.close();

		}

		catch(IOException | ParseException e){
			System.out.println("Error: %s\n" + e);

		}

		
	}
	
		
	}








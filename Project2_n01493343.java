/* 
 *  Author: Samuel Olunuga

 *  Course: COP3503 
 *  Project #: 2
 *  Title  : Input/Output
 *  Due Date:  25/10/2022
 *  
 *  Reads in and writes out File 
 */ 

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/**
 * The Class Project2 for reading and writing files.
 */
public class Project2_n01493343 {

	/** The dates array list for storing the dates. */
	public static ArrayList<String> dates = new ArrayList<String>();

	/** The times array lists for storing the time. */
	public static ArrayList<String> times = new ArrayList<String>();

	/** The sensor 2278 for storing the sensor column. */
	public static ArrayList<Double> sensor2278 = new ArrayList<Double>();

	/** The sensor 3276 for storing the sensor column. */
	public static ArrayList<Double> sensor3276 = new ArrayList<Double>();

	/** The sensor 4689 for storing the sensor column. */
	public static ArrayList<Double> sensor4689 = new ArrayList<Double>();

	/** The sensor 5032 for storing the sensor column. */
	public static ArrayList<Double> sensor5032 = new ArrayList<Double>();

	/** The section 1 diff array list to store the first difference. */
	public static ArrayList<Double> section1Diff = new ArrayList<Double>();

	/** The section 2 diff array list to store the second difference. */
	public static ArrayList<Double> section2Diff = new ArrayList<Double>();

	/** The total avg array list to store the total average. */
	public static ArrayList<Double> totalAvg = new ArrayList<Double>();



	/**
	 * The main method.
	 * @param an array of sequence of characters
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Project 2 Data Preprocessing\n");

		//FileName stores the name of the file from user input
		String fileName = new String();
		fileName = readFile();
		System.out.println("Reading in Data from the file " + fileName );

		//Calling the convert date function
		//Also, adding the result back to dates
		System.out.println("Converting Dates from MM/DD/YYYY to YYYY/MM/DD ");
		//dates = ConvertDate(dates);

		//Calling the two difference functions
		System.out.println("Calculating Speed Difference ");
		section1Diff = firstDifference(section1Diff);
		section2Diff = secondDifference(section2Diff);

		// Calling the Average function
		System.out.println("Calculating Speed Average ");
		totalAvg = Average(totalAvg);

		//Replacing the ".csv" at the end of the file name with nothing
		//printing out the new file name
		fileName = fileName.replace(".csv", "");
		System.out.println("Writing data to file " + fileName + "_Difference.csv ");
		//Passing the file name to the write function
		writeContent(fileName);
		//Exiting program
		System.out.println("Done! Exiting Program ");

	}

	/**
	 * Reading in the file through user input.
	 */
	public static String readFile() {
		// Variable declaration 
		boolean flag = true;
		String inputFileName = new String();
		while(flag) {
			// Get user input 
			Scanner console = new Scanner(System.in);
			System.out.println("Enter file name and location. ");
			inputFileName = console.next();
			String line = "";//Stores each line

			try {
				//variable declarations
				BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
				int i = 0;
				line = reader.readLine();
				while(((line = reader.readLine()) != null)) {
					//Spliting the line by commas; creating a column string array for each array List 
					String[] columns = line.split(",");
					//Adding each column to its own Array List 
					dates.add(columns[0]);
					times.add(columns[1]);
					sensor2278.add(Double.parseDouble(columns[2]));
					sensor3276.add(Double.parseDouble(columns[3]));
					sensor4689.add(Double.parseDouble(columns[4]));
					sensor5032.add(Double.parseDouble(columns[5]));
					flag = false;
				}
				//Set dates to the value returned by the convert date function
				dates = ConvertDate(dates);
				//System.out.println(dates);
				//closing the buffered reader
				reader.close();
			} //end try.
			//Catching the FileNotFoundException, NumberFormatException, IOException, and Parse Exception
			catch (FileNotFoundException e) {
				System.out.println("Reading in Data from the file " + inputFileName);
				System.out.println("*File does not exist or path was entered incorrectly.* ");
				System.out.println("Please try again."); 
				//Emptying the data after the exception is found 
				dates.clear();
				times.clear();
				sensor2278.clear();
				sensor3276.clear();
				sensor4689.clear();
				sensor5032.clear();
				flag = true;
			} //End FileNotFoundException catch
			catch (IOException e) {
				//System.out.println("united exception");
				//e.printStackTrace(); 
				//Emptying the data after the exception is found 
				dates.clear();
				times.clear();
				sensor2278.clear();
				sensor3276.clear();
				sensor4689.clear();
				sensor5032.clear();
				flag = true;

			}//end catch
			catch (NumberFormatException nfe) {
				System.out.println("Reading in Data from the file " + inputFileName);
				System.out.println("*Bad Number Data in CSV File.*");
				System.out.println("Check CSV file data and try again.");
				//Emptying the data after the exception is found 
				dates.clear();
				times.clear();
				sensor2278.clear();
				sensor3276.clear();
				sensor4689.clear();
				sensor5032.clear();
				flag = true;
			}//End NumberFormatException catch
			catch(ParseException e) {
				System.out.println("Reading in Data from the file " + inputFileName);
				System.out.println("Converting Dates from MM/DD/YYYY to YYYY/MM/DD");
				System.out.println("*Bad Date Data in CSV File.*");
				System.out.println("Check CSV file data and try again.");
				//Emptying the data after the exception is found 
				dates.clear();
				times.clear();
				sensor2278.clear();
				sensor3276.clear();
				sensor4689.clear();
				sensor5032.clear();
				flag = true;
			}//End ParseException catch
		}
		return inputFileName;

	}

	/**
	 * Convert the date from mm/dd/yyyy to yyyy/mm/dd.
	 * @param Array List of columns.
	 * @return The dates column with the newly updated format.
	 * @throws ParseException 
	 */
	public static ArrayList<String> ConvertDate(ArrayList<String> columns) throws ParseException {
		// Variable declaration 
		SimpleDateFormat currentFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy/MM/dd");
		//Loop through every element and set the column(dates) to its new format
		for (int i = 0; i < columns.size(); i++) {
			Date dateObject = currentFormat.parse(columns.get(i));
			columns.set(i, newFormat.format(dateObject)) ;
			//System.out.println(dates);
		}
		return columns;
	}

	/**
	 * Calculates the total average of the sensors.
	 * @param Array List of columns
	 * @return The average of the four arrayLists.
	 */
	public static ArrayList<Double> Average(ArrayList<Double> columns){
		// Variable declaration 
		int i;
		ArrayList<Double> result = new ArrayList<Double>();
		//Loop through every element and calculate the average
		for (i = 0; i < sensor2278.size(); i++) {
			result.add((sensor2278.get(i)+sensor3276.get(i)+sensor4689.get(i)+sensor5032.get(i))/4.0);		
		}
		return result;
	}

	/**
	 * Calculates the first difference between two sensors.
	 * @param double Array list of columns
	 * @return The difference between sensor2278 and sensor3276.
	 */
	public static ArrayList<Double> firstDifference(ArrayList<Double> columns){
		// Variable declaration 
		int i;
		ArrayList<Double> result = new ArrayList<Double>();
		//Loop through every element and calculate the difference
		for (i = 0; i < sensor2278.size(); i++) {
			result.add(sensor2278.get(i) - sensor3276.get(i));		
		}
		return result;
	}

	/**
	 * Calculates the second difference between two sensors.
	 * @param columns the columns
	 * @return The difference between sensor4689 and sensor5032
	 */
	public static ArrayList<Double> secondDifference(ArrayList<Double> columns){
		int i;
		ArrayList<Double> result = new ArrayList<Double>();
		//Loop through every element and calculate the difference.
		for (i = 0; i < sensor2278.size(); i++) {
			result.add(sensor4689.get(i) - sensor5032.get(i));		
		}
		return result;
	}
	/**
	 * Writes content to a new file
	 * @param the file name
	 */
	public static void writeContent(String inputFileName) throws IOException{
		//variable declaration
		inputFileName = inputFileName.replace(".csv", "");
		//System.out.println(inputFileName);
		BufferedWriter writeTo = new BufferedWriter (new FileWriter (inputFileName + "_Difference.csv"));
		//System.out.println(writeTo);
		//Write the header back out manually
		writeTo.write("Date, Time, Sensor_2278, Sensor_3276, Sensor_4689, Sensor_5032, Section1_Difference, Section2_Difference, Total Avg");
		writeTo.newLine();
		//Loop through the size of dates and write each column out by its
		for (int i= 0; i < dates.size() ; i++) {
			writeTo.write(dates.get(i) + ",");
			writeTo.write(times.get(i) + ",");
			writeTo.write(sensor2278.get(i) + ",");
			writeTo.write(sensor3276.get(i) + ",");
			writeTo.write(sensor4689.get (i) + ",");
			writeTo.write(sensor5032.get(i) + ",");
			writeTo.write(section1Diff.get(i) + ",");
			writeTo.write(section2Diff.get(i) + ",");
			writeTo.write(totalAvg.get(i) + ",");
			writeTo.newLine();
			//System.out.println(i);
		}
		//Closing the writer
		writeTo.close();
	}


}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * The Class FileHandler.
 */
public class FileHandler {

	/** The scanner. */
	Scanner scnr = new Scanner(System.in);

	/**
	 * Write data.
	 *
	 * @param workOrderFile the work order file
	 */
	public void writeData(String workOrderFile) {
		try {
			try (BufferedWriter writeTo = new BufferedWriter (new FileWriter (workOrderFile))) {
				//Write the header back out manually
				writeTo.write("employee_id, employee_first_name, employee_last_name, clocked_in, customer_id , customer_first_name, customer_last_name, ticket_id, ticket_createdAt, workorder_createdAt");
				writeTo.newLine();
				//Loop through the size of work order list and write the data in getFIleData and getInfo out.
				for (int i= 0; i < project3_n01493343.workorderList.size() ; i++) {
					writeTo.write(project3_n01493343.workorderList.get(i).getFileData());
					logger(project3_n01493343.workorderList.get(i).getInfo());
					writeTo.newLine();

				}
				//Closing the writer
				writeTo.close();
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Read employee data.
	 *
	 * @param employeeFileName the employee file name
	 */
	public void readEmployeeData(String employeeFileName) {
		String line = "";

		try {
			//variable declarations
			BufferedReader reader = new BufferedReader(new FileReader(employeeFileName));
			line = reader.readLine();
			while(((line = reader.readLine()) != null)) {
				//Splitting the line by commas; creating a column string array for each array List 
				String[] columns = line.split(",");
				//Adding each column to the Employee Constructor
				Employee newEmployees = new Employee(columns[1],columns[2], columns[4], columns[5], columns[3], columns[0], columns[6], columns[7]);
				//add employees to its array list
				project3_n01493343.employeeList.add(newEmployees);

			}
			//closing the buffered reader and Scanner
			scnr.close();
			reader.close();
			//System.out.println(columns[0]);
		}
		catch (FileNotFoundException e) {

		} //End FileNotFoundException catch
		catch (IOException e) {

		}//end catch

	}

	/**
	 * Read ticket data.
	 *
	 * @param ticketFileName the ticket file name
	 */
	public void readTicketData(String ticketFileName) {
		String line = "";

		try {
			//variable declarations
			BufferedReader reader = new BufferedReader(new FileReader(ticketFileName));
			line = reader.readLine();
			while(((line = reader.readLine()) != null)) {
				//Splitting the line by commas; creating a column string array for each array List 
				String[] columns = line.split(",");
				//Adding each column to to its respective Constructors: customers and tickets
				Customer customers = new Customer(columns[1], columns[2], columns[4], columns[5],columns[3],columns[0], columns[6]);
				Ticket tickets = new Ticket(customers, columns[8], columns[7]);
				//Add tickets to its array list
				project3_n01493343.ticketList.add(tickets);

			}
			scnr.close();
			reader.close();
		}
		catch (FileNotFoundException e) {

		} //End FileNotFoundException catch
		catch (IOException e) {

		}//end catch

	}

	/**
	 * Logger.
	 *
	 * @param log the log
	 */
	public void logger(String log) {
		try {
			//variable declarations
			try (BufferedWriter writeTo = new BufferedWriter (new FileWriter ("log.txt",true))) {
				String namer = (project3_n01493343.createdAt() + ":" + log);
				writeTo.write(namer);
				//Closing the writer
				writeTo.close();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}//end catch
	}


}

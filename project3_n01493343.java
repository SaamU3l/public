/* 
 *  Author: Samuel Olunuga

 *  Course: COP3503 
 *  Project #: 3
 *  Title  : Objects & Classes
 *  Due Date:  11/23/2022
 *  
 *  Creating a Work order Generator that implements class files, classes, methods,and interfaces for creating objects.
 */ 

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The Class project3_n01493343.
 */
public class project3_n01493343 {

	/** The employee file. */
	public static String employeeFile = "employee_data.csv";
	
	/** The ticket file. */
	public static String ticketFile = "ticket_data.csv";
	
	/** The work order file. */
	public static String workorderFile = "workorder_data.csv";

	/** The employee list. */
	public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	/** The ticket list. */
	public static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	
	/** The work order list. */
	public static ArrayList<WorkOrder> workorderList = new ArrayList<WorkOrder>();

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		System.out.println("Project 3 Work Order Generator");
		
		//Passing the file name to the write function
		FileHandler fileHandler = new FileHandler();
		System.out.println();

		System.out.println("Loading Employee Data");
		fileHandler.logger("Loading Employee Data");
		
		//Passing the file name to the read employee data function
		fileHandler.readEmployeeData(employeeFile);


		System.out.println("Loading Ticket Data");
		fileHandler.logger("Loading Ticket Data");

		//Passing the file name to the read ticket data function
		fileHandler.readTicketData(ticketFile);

		System.out.println("Creating Work Orders");
		fileHandler.logger("Creating Work Orders");

		//call create work orders
		createWorkorders();

		System.out.println("Writing Work Order Data to File");
		fileHandler.logger("Writing Work Order Data to File");

		//Passing the file name to the write function
		fileHandler.writeData(workorderFile);

		System.out.println("Work Orders Created. Program Exiting");
		fileHandler.logger("Work Orders Created. Program Exiting");

	}
	
	/**
	 * Creates the work orders.
	 */
	public static void createWorkorders() {
		//variable declarations
		int count = 0;
		int r = 0;
		//iterates over the list of Tickets and Employees to create WorkOrders for each Ticket 
		for(int i =0;i <employeeList.size(); i++) {
			int ticketNumbers = ticketList.size() / employeeList.size(); //Set ticket numbers to divide ticketList by employee list
			for(int c = 0; c< ticketNumbers; c++) {
				if(count+1 <= ticketList.size()) {
					WorkOrder myorder = new WorkOrder(employeeList.get(i), ticketList.get(count), createdAt());
					//adding the work orders to its array list
					workorderList.add(myorder);
					count++;
				}
			}
			r++;
		}
		r = 0;
		//iterates for the remainder of employee list, ticket list, and created at
		for(; count < ticketList.size(); count++) {
			WorkOrder myorder = new WorkOrder(employeeList.get(r), ticketList.get(count), createdAt());
			//adding the remaining work orders to its array list
			workorderList.add(myorder);
			r++;//increment r
			
		}

	}

	/**
	 * Created at.
	 *
	 * @return the string
	 */
	public static String createdAt() {
		// Variable declaration 
		Date date = new Date();
		SimpleDateFormat currentFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		String createdAt1 = currentFormat.format(date);

		return createdAt1;
	}


}


/**
 * The Class WorkOrder.
 */
public class WorkOrder implements DataHandler {
	
	/** The employee. */
	private Employee employee;
	
	/** The ticket. */
	private Ticket ticket;
	
	/** The created at. */
	private String createdAt;

	/**
	 * Instantiates a new work order.
	 *
	 * @param employee the employee
	 * @param ticket the ticket
	 * @param createdAt the created at
	 */
	public WorkOrder(Employee employee, Ticket ticket, String createdAt) {
		setCreatedAt(createdAt);
		setEmployee(employee);
		setTicket(ticket);

	}
	
	/**
	 * Gets the info.
	 *
	 * @return the info
	 */
	@Override
	public String getInfo() {
		//variable declarations
		String workOrderInfo = (employee.getInfo() + ticket.getInfo() + "  WorkOrder Info:" + "\t" + "Created At: " + getCreatedAt() + "\n");

		return workOrderInfo;

	}
	
	/**
	 * Gets the file data.
	 *
	 * @return the file data
	 */
	@Override
	public String getFileData() {
		//variable declarations
		String workOrderInfo = employee.getFileData()+ "," + ticket.getFileData() + "," + getCreatedAt();

		return workOrderInfo;
	}

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * Sets the ticket.
	 *
	 * @param ticket the new ticket
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/**
	 * Gets the ticket.
	 *
	 * @return the ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	public String getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * Sets the created at.
	 *
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}



}

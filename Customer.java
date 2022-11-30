
/**
 * The Class Customer.
 */
public class Customer extends Person implements DataHandler {
	
	/** The customer id. */
	private String customerId;
	
	/** The account number. */
	private String accountNumber;
	
	/**
	 * Instantiates a new customer.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param address the address
	 * @param phoneNumber the phone number
	 * @param email the email
	 * @param customerId the customer id
	 * @param accountNumber the account number
	 */
	public Customer(String firstName, String lastName, String address, String phoneNumber, String email, String customerId, String accountNumber) {
		//		super.getInfo();
		//		super.getFileData();
		super(firstName,lastName, address, phoneNumber, email);

		setCustomerId(customerId);
		setAccountNumber(accountNumber);

	}

	/**
	 * Gets the info.
	 *
	 * @return the info
	 */
	@Override
	public String getInfo() {
		//variable declarations
		String customerInfo = ("Customer Info: Customer Name: " + super.getInfo() + "\t\t" + "Customer ID: " + getCustomerId() + "\t\t" + "Account Number: " + getAccountNumber() + "\t");
		return customerInfo;

	}

	/**
	 * Gets the file data.
	 *
	 * @return the file data
	 */
	@Override
	public String getFileData() {
		//variable declarations
		String customerInfo = getCustomerId() + "," + super.getFileData();
		return customerInfo;
	}


	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public String getCustomerId() {
		return customerId;
	}
	
	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(String customerId) {

		this.customerId = customerId;
	}
	
	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}

import java.util.ArrayList;

import th.ac.ku.kps.eng.cpe.dao.CustomerDAO;
import th.ac.ku.kps.eng.cpe.entity.Customer;

public class testcustomer {
	public static void main(String[] args) {
		ArrayList<Customer> listOfCustomers = CustomerDAO.getAllCustomers();
		System.out.println(listOfCustomers.get(0).getPhonenumbers().get(0).getNumber());
	}
}

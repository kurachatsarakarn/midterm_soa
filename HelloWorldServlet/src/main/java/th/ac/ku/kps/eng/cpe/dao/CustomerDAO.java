package th.ac.ku.kps.eng.cpe.dao;

import java.util.ArrayList;

import th.ac.ku.kps.eng.cpe.entity.Customer;
import th.ac.ku.kps.eng.cpe.entity.phonenumber;

public class CustomerDAO {
	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<Customer> getAllCustomers()
	{	
		ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();
		
		Customer c1 = new Customer();
		c1.setName("feel");
		ArrayList<phonenumber> p1 = new ArrayList<phonenumber>();
		p1.add(new phonenumber("097"));
		p1.add(new phonenumber("095"));
		c1.setPhonenumbers(p1);
		Customer c2 = new Customer();
		c2.setName("didkuy");
		listOfCustomers.add(c1);
		listOfCustomers.add(c2);
		
		return listOfCustomers;
	}
}

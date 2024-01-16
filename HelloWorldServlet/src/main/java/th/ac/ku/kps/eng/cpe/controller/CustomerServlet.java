package th.ac.ku.kps.eng.cpe.controller;

import java.io.BufferedReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import th.ac.ku.kps.eng.cpe.dao.CustomerDAO;
import th.ac.ku.kps.eng.cpe.entity.Customer;
import th.ac.ku.kps.eng.cpe.entity.phonenumber;

public class CustomerServlet extends HttpServlet {
	public CustomerServlet() {
// TODO Auto-generated constructor stub
	}
	ArrayList<Customer> listOfCustomers = CustomerDAO.getAllCustomers();

	
	
	
	
	public static String getBody(HttpServletRequest request) throws IOException {

		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		body = stringBuilder.toString();
		return body;
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		//ArrayList<Customer> listOfCustomers = CustomerDAO.getAllCustomers();
		ByteArrayOutputStream op = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(op, listOfCustomers);
		byte[] data = op.toByteArray();
		out.write(new String(data).toString());
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		//ArrayList<Customer> listOfCustomers = CustomerDAO.getAllCustomers();
		ByteArrayOutputStream op = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		String s = getBody(req);
	    //JsonObject j = jsonread(req);
		//for (int i = 0; i < listOfCustomers.size(); i++) {
            //out.write(listOfCustomers.get(i).getName());
           // String a = String.valueOf(i);
            //out.write(a);
			//if (!listOfCustomers.contains(s)) {
                listOfCustomers.add(new Customer(s));
                //out.write(s+","+listOfCustomers.get(i).getName());
                //break;
            //}
        
		//mapper.writeValue(op, listOfCustomers);
		//byte[] data = op.toByteArray();
		//out.write("ss");
        		
        	    //JsonObject j = jsonread(req);
        		
        		mapper.writeValue(op, listOfCustomers);
        		byte[] data = op.toByteArray();
        		out.write(new String(data).toString());

	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		String s = getBody(req);
		//out.write("dwdwdw");
		for (int i = 0; i < listOfCustomers.size(); i++) {
			 //out.write(i);
			if (listOfCustomers.get(i).getName().equals(s)) {
                //out.write("xxx");	
            	listOfCustomers.remove(i);
            }
        }
		ByteArrayOutputStream op = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		
	    //JsonObject j = jsonread(req);
		
		mapper.writeValue(op, listOfCustomers);
		byte[] data = op.toByteArray();
		out.write(new String(data).toString());
		

	}
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		//ArrayList<Customer> listOfCustomers = CustomerDAO.getAllCustomers();
		ByteArrayOutputStream op = new ByteArrayOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		String s = getBody(req);
		String[] a = s.split(",");
	    //JsonObject j = jsonread(req);
		for (int i = 0; i < listOfCustomers.size(); i++) {
            if (listOfCustomers.get(i).getName().equals(a[0])) {
                listOfCustomers.get(i).setName(a[1]);
                out.write(listOfCustomers.get(i).getName());
                break;
            }
        }
		//mapper.writeValue(op, listOfCustomers);
		//byte[] data = op.toByteArray();
		//out.write("ss");
		

	}
	
}
package com.org.HibernateAssessment;

import java.util.HashSet;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String a[])
    {
    	Configuration cfg = new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		SessionFactory fact = cfg.buildSessionFactory();
		Session session = fact.openSession();    

        Vendor vendor=new Vendor();
        vendor.setVendorId(001);
        vendor.setVendorName("ABC");

        Customer customer=new Customer();
        customer.setCustomerId(002);
        customer.setCustomerName("NIFY");
        customer.setCustomerAddress("DEL");

        Customer customer2=new Customer();
        customer2.setCustomerId(003);
        customer2.setCustomerName("TCS");
        customer2.setCustomerAddress("KAN");

        Customer customer3=new Customer();
        customer3.setCustomerId(004);
        customer3.setCustomerName("VERIZON");
        customer3.setCustomerAddress("BANG");

        Set customers = new HashSet();
        customers.add(customer);
        customers.add(customer2);
        customers.add(customer3);

        vendor.setCustomers(customers);

        Transaction transaction=session.beginTransaction();

        session.save(vendor);

        transaction.commit();

        session.close();
    }

}

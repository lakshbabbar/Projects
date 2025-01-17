package com.hcl.AnnoEmploy;

import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class InsertEmploy {

	public static void main(String[] args) {
		Employ e = new Employ();
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		int empno = 0 ;
		Query q = s.createQuery("Select max(empno) from Employ");
		for(Iterator it = q.iterate();it.hasNext();){
			empno = (Integer)it.next();
		}
		empno++;
		e.setEmpno(empno);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.nextLine();
		e.setName(name);
		System.out.println("Enter dept");
		String dept = sc.nextLine();
		e.setDept(dept);
		System.out.println("Enter desig");
		String desig = sc.nextLine();
		e.setDesig(desig);
		System.out.println("Enter basic");
		int basic = sc.nextInt();
		e.setBasic(basic);
		
		Transaction t = s.beginTransaction();
		s.save(e);
		t.commit();
		System.err.println("Record Inserted...");
	}
}


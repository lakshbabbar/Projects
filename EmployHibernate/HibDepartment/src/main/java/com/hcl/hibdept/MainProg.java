package com.hcl.hibdept;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class MainProg {

	public static void main(String[] args) {
		Configuration cfg =new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Department");
		List<Department> lstdept = q.list();
		for (Department department : lstdept) {
			System.out.println("Department no " + department.getDeptno());
			System.out.println("Department name " + department.getDname());
			System.out.println("Department location " + department.getLoc());
			System.out.println("Head " + department.getHead());
		}
		
	}
}

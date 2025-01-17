package com.hcl.college;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




public class CollegeCRUD {

	public String addsubjects(subjects sub){
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(sub);
		t.commit();
		return "Record Inserted...";
	}
	
	public String generateFid(){
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		String fid="";
		Query q=s.createQuery("from feedback ");
		List<Integer> c = q.list();
		int y=c.size();
		y++;
		String str = String.format("%03d", y);
		String feed = "F" + str;
		return feed;
	}
	
	public List<String> InstrSub(String instructor){
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		Query q=s.createQuery("select subject from subjects where instructor='" + instructor +"'");
		List<String> lst = q.list();
		return lst;
	}
	
	public List<String> GetInstr(){
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		Query q = s.createQuery("select distinct instructor from subjects");
		List<String> lst = q.list();
		return lst;
	}
	
	public String addfeedback(feedback fd){
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(fd);
		t.commit();
		return "Record Inserted...";
	}
	
	public List<xyz> showfeedback(String instructor,String subject){
		SessionFactory sf = HibernateUtil.getConnection();
		Session s = sf.openSession();
		Query q = s.createQuery("select fbvalue,count(*) from feedback where instructor = '" +instructor+"' and subject = '" +subject+ "'group by fbvalue");
		List<xyz> list = q.list();
		return list;
	}
	
}

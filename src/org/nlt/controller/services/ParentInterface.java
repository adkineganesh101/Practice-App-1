package org.nlt.controller.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.nlt.model.Persons;
import org.nlt.model.Users;

public interface ParentInterface 
{
	public static SessionFactory sf=getDatabaseConnection();
	public static Session ses=sf.openSession();
	
	public static SessionFactory getDatabaseConnection()
	{
		System.out.println("Static getDatabaseConnection() of ParentInterface!");
		SessionFactory sesFact=new Configuration().configure("org/nlt/controller/hibernate.cfg.xml").buildSessionFactory();
		return sesFact;
	}
	
	public static List<Users> userList=new ArrayList<>();
	//public static List<Persons> personList=new ArrayList<>();
	
}

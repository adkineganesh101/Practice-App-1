package org.nlt.controller.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.nlt.model.Persons;
import org.nlt.model.Users;
import org.springframework.stereotype.Service;

@Service
public class PersonServices implements ParentInterface
{
	public PersonServices() 
	{
		System.out.println("PublicServices' Object Created!");
	}
	
	public boolean addPerson(Users user)
	{
		//SessionFactory sf=new Configuration().configure("org/nlt/controller/hibernate.cfg.xml").buildSessionFactory();
		//Session ses=sf.openSession();
		
		ses.beginTransaction();
		
			ses.save(user);
			
		ses.getTransaction().commit();
		//ses.close();
		//sf.close();
		
		return true;
	}
	
	public boolean addUsers(Users user)
	{
		//SessionFactory sf=new Configuration().configure("org/nlt/controller/hibernate.cfg.xml").buildSessionFactory();
		//Session ses=sf.openSession();
		
		ses.beginTransaction();
		
			ses.save(user);
			
		ses.getTransaction().commit();
		//ses.close();
		//sf.close();
		
		return true;
	}
	public boolean updatePerson(Users user)
	{
		//SessionFactory sf=new Configuration().configure("org/nlt/controller/hibernate.cfg.xml").buildSessionFactory();
		//Session ses=sf.openSession();
		
		ses.beginTransaction();
		
			ses.update(user);
		
		ses.getTransaction().commit();
		//ses.close();
		//sf.close();
		
		return true;
	}
	
	/*public boolean deletePerson(Persons person)
	{
		//SessionFactory sf=new Configuration().configure("org/nlt/controller/hibernate.cfg.xml").buildSessionFactory();
		//Session ses=sf.openSession();
		
		ses.beginTransaction();
		
			ses.update(person);
		
		ses.getTransaction().commit();
		//ses.close();
		//sf.close();
		
		return true;
	}*/
	
	//public List<Persons> getPersonList()
	public void getPersonList()
	{
		userList.clear();
		System.out.println("Executing getPersonList method from PersonServices!");
		
		//SessionFactory sf=new Configuration().configure("org/nlt/controller/hibernate.cfg.xml").buildSessionFactory();
		//Session ses=sf.openSession();
		
		ses.beginTransaction();
			
			Query query=ses.createQuery("from Users where status=1");
			userList.addAll(query.list());
			//List<Persons> personList=query.list();
		
		ses.getTransaction().commit();
		//ses.close();
		//sf.close();
		
		//return personList;
	}
	
	public Users getPerson(int id)
	{
		Users user=userList.stream().filter(P->P.getId()==id).findAny().orElse(null);  	 
		return user;
	}
}

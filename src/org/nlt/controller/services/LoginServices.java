package org.nlt.controller.services;

import java.util.List;

import org.hibernate.Query;
import org.nlt.model.Users;
import org.springframework.stereotype.Service;

@Service
public class LoginServices implements ParentInterface
{
	public LoginServices() 
	{
		System.out.println("LoginServices' Object Created!");
	}
	
	public Users getLoginUser(String username,String password)
	{
		ses.beginTransaction();
			Query query=ses.createQuery("from Users where status=1 and username='"+username+"'and password='"+password+"'");
			List<Users> userList=query.list();
		ses.getTransaction().commit();
		
		if(!userList.isEmpty())
		{
			return userList.get(0);
		}
		else
		{
			return null;
		}
	}
}

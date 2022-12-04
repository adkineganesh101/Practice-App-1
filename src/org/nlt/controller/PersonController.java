package org.nlt.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.io.ReplicationStream;
import org.nlt.controller.services.ParentInterface;
import org.nlt.controller.services.PersonServices;
import org.nlt.model.Persons;
import org.nlt.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController extends ParentController implements ParentInterface
{
	//@Autowired
	//private PersonServices personService;
	
	public PersonController() 
	{
		System.out.println("PersonController's Object Created!");
	}
	
	@RequestMapping(value="/submitPerson",method=RequestMethod.POST)
	public ModelAndView addPerson(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap();
		
//		String name=req.getParameter("name");
//		String age=req.getParameter("age");
//		String phone=req.getParameter("phone");
		
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String id=req.getParameter("id");
		
		m.put("nameValue",name);
		m.put("addressValue",address);
		m.put("cityValue",city);
		m.put("stateValue",state);
		
		if(name.isEmpty() && address.isEmpty() && city.isEmpty()) 
		{
			m.put("fieldsError","All fields are mandatory!");
		}
		else if(name.isEmpty())
		{
			m.put("nameError","NameField empty! Name required!");
		}
		else if(address.isEmpty()) 
		{
			m.put("ageError","AgeField empty! Age required!");
		}
		else if(city.isEmpty()) 
		{
			m.put("phoneError","PhoneField empty! Phone required!");
		}
		else
		{
			Users user=new Users();
			
			user.setName("name");
			user.setDob("dob");
			user.setAddress("address");
			user.setGender("gender");
			user.setCity("city");
			user.setState("state");
			user.setUsername("username");
			user.setPassword("password");
			user.setModified(new Date());
			user.setCreated(new Date());
			user.setStatus(1);
			
			Users personRepeated=userList.stream().filter(P->P.getUsername()==user.getUsername()).findAny().orElse(null);
			
			if(personRepeated==null)
			{
				boolean result=personService.addPerson(user);
				
				if(result==true)
				{
					m.put("successMessage","Record Submitted Successfully into SpringApp2 DataBase!");
					personService.getPersonList();
					
					m.put("nameValue","");
					m.put("ageValue","");
					m.put("phoneValue","");
				}
				else
				{
					m.put("errorMessage","Unable to Submit Record from PersonController!");
				}
			}	
		}
		m.put("buttonValue","SUBMIT");
		m.put("actionValue","./submitPerson");
		m.put("userList",userList);
		
		//List<Persons> pList=personService.getPersonList();
		//m.put("personList",pList);
		
		return new ModelAndView("index",m);
	}
	
	@RequestMapping(value="/userSubmit",method=RequestMethod.POST)
	public ModelAndView addUsers(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap();
		
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String gender=req.getParameter("gender");
		String address=req.getParameter("address");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		m.put("usernameValue",username);
		m.put("phoneValue",password);
		
		if(username.isEmpty() && password.isEmpty()) 
		{
			m.put("fieldsError","All fields are mandatory!");
		}
		
		else if(username.isEmpty()) 
		{
			m.put("ageError","UsernameField empty! Username required!");
		}
		else if(password.isEmpty()) 
		{
			m.put("phoneError","PasswordField empty! Password required!");
		}
		else
		{
			Users user=new Users();
			
			user.setName(name);
			user.setDob(dob);
			user.setAddress(address);
			user.setGender(gender);
			user.setCity(city);
			user.setState(state);
			user.setUsername(username);
			user.setPassword(password);
			user.setModified(new Date());
			user.setCreated(new Date());
			user.setStatus(1);
//			person.setAge(Integer.parseInt(age));
//			person.setCreated(new Date());
//			person.setModified(new Date());
//			person.setName(name.toUpperCase());
//			person.setPhone(Long.parseLong(phone));
//			person.setStatus(1);
			
			Users personRepeated=userList.stream().filter(P->P.getName()==user.getName()).findAny().orElse(null);
			
			if(personRepeated==null)
			{
				boolean result=personService.addUsers(user);
				
				if(result==true)
				{
					m.put("successMessage","Record Submitted Successfully into SpringApp2 DataBase!");
					personService.getPersonList();
					
					m.put("nameValue","");
					m.put("ageValue","");
					m.put("phoneValue","");
				}
				else
				{
					m.put("errorMessage","Unable to Submit Record from PersonController!");
				}
			}	
		}
		m.put("SuccessMessage","Record Submitted Successfully");
		m.put("buttonValue","SUBMIT");
		m.put("actionValue","./userSubmit");
		m.put("userList",userList);
		
		//List<Persons> pList=personService.getPersonList();
		//m.put("personList",pList);
		
		return new ModelAndView("signup1",m);
	}
	
	@RequestMapping(value="/getPersonEdit")
	public ModelAndView showPersonForEdit(HttpServletRequest req,HttpServletResponse resp)
	{
		String id=req.getParameter("id");
		int pid=Integer.parseInt(id);
		
		Map m=new HashMap<>();
		m.put("personList",userList);
		
		//List<Persons> pList=personService.getPersonList();
		//m.put("personList",pList);
		
		//Persons person=pList.stream().filter(P->P.getId()==pid).findAny().orElse(null);
		
		Users person=personService.getPerson(pid);
		
		m.put("nameValue",person.getName());
		m.put("addressValue",person.getAddress());
		m.put("cityValue",person.getCity());
		m.put("stateValue",person.getState());
		m.put("idValue",person.getId());
		m.put("buttonValue","UPDATE");
		m.put("actionValue","./updatePerson");
		
		return new ModelAndView("index",m);
	}
	
	@RequestMapping(value="/getPersonDelete")
	public ModelAndView showPersonForDelete(HttpServletRequest req,HttpServletResponse resp)
	{
		String id=req.getParameter("id");
		int pid=Integer.parseInt(id);
		
		Map m=new HashMap<>();
		m.put("personList",userList);
		
		//List<Persons> pList=personService.getPersonList();
		//m.put("personList",pList);
		
		//Persons person=pList.stream().filter(P->P.getId()==pid).findAny().orElse(null);
		
		Users person=personService.getPerson(pid);
		
		m.put("nameValue",person.getName());
		m.put("addressValue",person.getAddress());
		m.put("cityValue",person.getCity());
		m.put("stateValue",person.getState());
		m.put("idValue",person.getId());
		m.put("buttonValue","DELETE");
		m.put("actionValue","./deletePerson");
		
		return new ModelAndView("index",m);
	}
	
	@RequestMapping(value="/updatePerson",method=RequestMethod.POST)
	public ModelAndView updatePerson(HttpServletRequest req,HttpServletResponse resp)
	{
		Map m=new HashMap<>();
		
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String id=req.getParameter("id");
		
		int pid=Integer.parseInt(id);
		
		m.put("nameValue",name);
		m.put("addressValue",address);
		m.put("cityValue",city);
		m.put("stateValue",state);
		m.put("idValue",id);
		
		if(name.isEmpty())
		{
			m.put("nameError","NameField empty! Name required!");
		}
		else if(address.isEmpty())
		{
			m.put("addressError","AddressField empty! Address required!");
		}
		else if(city.isEmpty())
		{
			m.put("phoneError","PhoneField empty! Phone required!");
		}
		else
		{
			//List<Persons> pList=personService.getPersonList();
			//Persons person=pList.stream().filter(P->P.getId()==pid).findAny().orElse(null);
			
			Users person=personService.getPerson(pid);
			
			m.put("nameValue",person.getName());
			m.put("addressValue",person.getAddress());
			m.put("cityValue",person.getCity());
			m.put("stateValue",person.getState());
			m.put("idValue",person.getId());
			
			boolean result=personService.updatePerson(person);
			
			if(result==true)
			{
				m.put("successMessage","Record Updated Successfully from SpringApp2 DataBase!");
				personService.getPersonList();
				
				m.put("nameValue","");
				m.put("ageValue","");
				m.put("phoneValue","");
				m.put("idValue","");
			}
			else
			{
				m.put("errorMessage","Unable to Update Record from PersonController!");
			}
		}
		
		m.put("buttonValue","SUBMIT");
		m.put("actionValue","./submitPerson");
		m.put("userList",userList);
		
		//List<Persons> pList=personService.getPersonList();
		//m.put("personList",pList);
		
		return new ModelAndView("index",m);
	}
	
	@RequestMapping(value="/deletePerson",method=RequestMethod.POST)
	public ModelAndView deletePerson(HttpServletRequest req,HttpServletResponse resp)
	{
		Map m=new HashMap<>();
		
		//String name=req.getParameter("name");
		//String age=req.getParameter("age");
		//String phone=req.getParameter("phone");
		
		String id=req.getParameter("id");
		int pid=Integer.parseInt(id);
		
		Users person=personService.getPerson(pid);
		
		//m.put("nameValue",name);
		//m.put("ageValue",age);
		//m.put("phoneValue",phone);
		//m.put("idValue",id);
		
		
			//List<Persons> pList=personService.getPersonList();
			//Persons person=pList.stream().filter(P->P.getId()==pid).findAny().orElse(null);
			
			//person.setAge(Integer.parseInt(age));
		
			person.setStatus(0);
			person.setModified(new Date());
			
			personService.updatePerson(person);
			
			//person.setName(name.toUpperCase());
			//person.setPhone(Long.parseLong(phone));
			
			//boolean result=personService.updatePerson(person);
			//boolean result=personService.deletePerson(person);
			
			//if(result==true)
			//{
				m.put("successMessage","Record Deleted Successfully from SpringApp2 DataBase!");
				personService.getPersonList();
				
				m.put("nameValue","");
				m.put("ageValue","");
				m.put("phoneValue","");
				m.put("idValue","");
			//}
			//else
			//{
				//m.put("errorMessage","Unable to Delete Record from PersonController!");
			//}
		
		
		m.put("buttonValue","SUBMIT");
		m.put("actionValue","./submitPerson");
		m.put("userList",userList);
		
		//pList=personService.getPersonList();
		//m.put("personList",pList);
		
		return new ModelAndView("index",m);
	}
}

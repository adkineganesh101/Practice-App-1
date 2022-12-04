package org.nlt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nlt.controller.services.ParentInterface;
import org.nlt.controller.services.PersonServices;
import org.nlt.model.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends ParentController implements ParentInterface
{
	//@Autowired
	//private PersonServices personService;
	
	public HomeController() 
	{
		System.out.println("HomeController's Object Created!");
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap<>();
		HttpSession httpSession=req.getSession();
			personService.getPersonList();
			m.put("userList",userList);
			m.put("buttonValue","SUBMIT");
			m.put("actionValue","./employeeSubmit");
			return new ModelAndView("login",m);
		
	}
	@RequestMapping(value="/signup1")
	public ModelAndView signup1(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap<>();
		HttpSession httpSession=req.getSession();
			personService.getPersonList();
			m.put("userList",userList);
			m.put("buttonValue","SUBMIT");
			m.put("actionValue","./employeeSubmit");
			return new ModelAndView("signup1",m);
		
	}
	@RequestMapping(value="/")
	public ModelAndView loginPage(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap<>();
		HttpSession httpSession=req.getSession();
		
		if(httpSession.getAttribute("UserLogin")!=null)
		{
			personService.getPersonList();
			m.put("userList",userList);
			m.put("buttonValue","SUBMIT");
			m.put("actionValue","./submitPerson");
			return new ModelAndView("index",m);
		}
		else
		{
			return new ModelAndView("signup1",m);
		}	
	}
	@RequestMapping(value="/employeeSubmit")
	public ModelAndView SignupPage(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap<>();
		HttpSession httpSession=req.getSession();
			personService.getPersonList();
			m.put("userList",userList);
			m.put("buttonValue","SUBMIT");
			m.put("actionValue","./employeeSubmit");
			return new ModelAndView("login",m);
		
	}
	//@RequestMapping(value="/")
	@RequestMapping(value="/home")
	public ModelAndView home()
	{
		Map m=new HashMap();
		//System.out.println("Home method of HomeController class");
		
		//List<Persons> pList=personService.getPersonList();
		personService.getPersonList();
		//m.put("personList",pList);
		m.put("userList",userList);
		m.put("buttonValue","SUBMIT");
		m.put("actionValue","./submitPerson");
		
		return new ModelAndView("index",m);
	}
	
	@RequestMapping(value="/abc")
	public ModelAndView home2()
	{
		Map m=new HashMap();
		System.out.println("Home2 method of HomeController class");
		return new ModelAndView("index",m);
	}
	
	@RequestMapping(value="/xyz")
	public ModelAndView home3()
	{
		Map m=new HashMap();
		System.out.println("Home3 method of HomeController class");
		return new ModelAndView("index",m);
	}
}

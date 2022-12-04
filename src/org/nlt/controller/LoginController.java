package org.nlt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nlt.controller.services.ParentInterface;
import org.nlt.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends ParentController implements ParentInterface
{
	@RequestMapping(value="/validateLogin",method=RequestMethod.POST)
	public ModelAndView checkLogin(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap<>();
		
		HttpSession httpSession=req.getSession();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		Users user=loginService.getLoginUser(username, password);
		
		if(user==null)
		{
			m.put("error","Invalid Username or Password!");
			return new ModelAndView("login",m);
		}
		else
		{
			httpSession.setAttribute("UserLogin",user);
			personService.getPersonList();
			m.put("userList",userList);
			m.put("buttonValue","SUBMIT");
			m.put("actionValue","./submitPerson");
			return new ModelAndView("index",m);
		}
		
		//return new ModelAndView("index");
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView userLogout(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap<>();
		HttpSession httpSession=req.getSession();
		httpSession.invalidate();//<<will remove all material from session and restart new session for browser
		
		return new ModelAndView("login",m);
	}
}

package org.nlt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class TestController 
{
	//DispatcherServlet
	//InternalResourceViewResolver
	public TestController() 
	{
		System.out.println("TestController's Object Created!");
	}
}

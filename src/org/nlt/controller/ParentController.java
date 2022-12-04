package org.nlt.controller;

import org.nlt.controller.services.LoginServices;
import org.nlt.controller.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;

public class ParentController 
{
	@Autowired
	public PersonServices personService;
	
	@Autowired
	public LoginServices loginService;
}

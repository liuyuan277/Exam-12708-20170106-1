package com.hand.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.dto.Customer;
import com.hand.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;


	@ResponseBody
    @RequestMapping(path = "", method = RequestMethod.GET)
    public Boolean query(@RequestParam(name = "first_name", required = false, defaultValue = "") String first_name,HttpSession session) {
    	Customer c=new Customer(first_name);
    	Boolean b=userService.selectUserById(c);
		if(b) {
			session.setAttribute("OnLineUser", c.getFirst_name());	
		}
        return b; 
    }
}

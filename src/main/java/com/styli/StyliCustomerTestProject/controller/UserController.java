package com.styli.StyliCustomerTestProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.styli.StyliCustomerTestProject.model.Customer;
import com.styli.StyliCustomerTestProject.model.User;
import com.styli.StyliCustomerTestProject.service.CustomerService;
import com.styli.StyliCustomerTestProject.service.UserService;

@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	private CustomerService customerService;

	@Autowired
	public UserController(UserService userService,CustomerService customerService) {
		this.userService = userService;
		this.customerService=customerService;
	}
	
	
	@RequestMapping(path = "/",method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
	private String index() {
		return "index";

	}
	@SuppressWarnings("serial")
	@RequestMapping(path = "/login",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private Map<String, Object> loginUser(@RequestBody User user) {
		boolean result = userService.checkValidUser(user);
		 if(result) {
			 log.info("User Exists");
		 }else {
			 log.error("User doesnt exist");
		 }
	
	return new HashMap<String,Object>() {
		{
			put("isValid",result);
		}
	};
	}
	
	@RequestMapping(path = "/home",method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
	private String home() {
		return "home";

	}
	@RequestMapping(path = "/AllCustomers",method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
	private String allCustomers(Model model) {
		List<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customers",customers);
		return "allCustomers";

	}
	@RequestMapping(path = "/CustomerDetails",method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
	private String CustomerDetails() {
		return "CustomerDetails";

	}
	@SuppressWarnings("serial")
	@RequestMapping(path = "/GetCustomerDetails",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private Map<String,Object> GetCustomerDetails(@RequestBody Customer cust) {
		 Optional<Customer> customer = customerService.getCustomerByEmail(cust);
         return new HashMap<String,Object>(){
			{
			put("Customer",customer.orElseGet(Customer::new));
			}
		};
	}
}

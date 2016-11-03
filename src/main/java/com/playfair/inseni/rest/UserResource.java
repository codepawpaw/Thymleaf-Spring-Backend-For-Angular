package com.playfair.inseni.rest;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.playfair.inseni.model.Product;
import com.playfair.inseni.model.User;
import com.playfair.inseni.service.UserService;

@RestController
@RequestMapping("/meetsup")
public class UserResource {
	
	@Inject
    private UserService userService;
	
	/**
	   * Save user data
	   * This method will return json data type.
	   * @return
	   */
	@CrossOrigin
	@RequestMapping(value = "/rest/data/user/save/{name}/{phone_number}/{address}/{city}/{userGroupId}/{email}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean save(@PathVariable String name, @PathVariable String phone_number, @PathVariable String address, @PathVariable String city, @PathVariable String userGroupId, @PathVariable String email) {
		User user = new User();
		user.setName(name);
		user.setPhoneNumber(phone_number);
		user.setAddress(address);
		user.setCity(city);
		user.setUserGroup(userGroupId);
		user.setEmail(email);
		return userService.save(user) == true ? true: false;
	}
	
	
	/**
	   * Get user data
	   * This method will return json data type.
	   * @return
	   */
	@CrossOrigin
	@RequestMapping(value = "/rest/data/user/{email}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserByEmail(@PathVariable String email) {
		return userService.getUSerById(email);
	}
	
	/**
	   * Get user data
	   * This method will return json data type.
	   * @return
	   */
	@CrossOrigin
	@RequestMapping(value = "/rest/data/user/by/id/{id}",
		method = RequestMethod.GET,
		produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable String id) {
		return userService.getUSer(id);
	}

}

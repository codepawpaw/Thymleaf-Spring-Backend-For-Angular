package com.playfair.inseni.rest;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.playfair.inseni.model.Account;
import com.playfair.inseni.service.AuthenticationService;

@RestController
@RequestMapping("/meetsup")
public class AuthResource {
	@Inject
    private AuthenticationService authenticationService;
    
    /**
	   * Get account data by username and password.
	   * This method will return json data type.
	   * @param username
	   * @param password
	   * @return
	   */
    @CrossOrigin
    @RequestMapping(value = "/rest/data/account/get/{username}/{password}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public Account getUserByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
    	return authenticationService.findAccountByUsernameAndPassword(username, password);
    }
  
    /**
     * Method insert new account
     * This method will return json data type.
     * @param username
     * @param password
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/rest/auth/register/{name}/{username}/{password}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean insertNewAccount(@PathVariable String name, @PathVariable String username, @PathVariable String password) {
    	return authenticationService.insert(username, password) == true ? true: false;
    }
    
    /**
     * Method check is the account data is exist
     * This method will return json data type.
     * @param username
     * @param password
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/rest/auth/login/{username}/{password}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean isAccountExist(@PathVariable String username, @PathVariable String password) {
    	return authenticationService.isExist(username, password) == true ? true: false;
    }
}

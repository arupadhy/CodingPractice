package com.sapient.app.fb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restfb.types.User;
import com.sapient.app.fb.data.FacebookDataRetriever;

@RestController
public class FacebookDataController {
	
	@Autowired
	private FacebookDataRetriever fbDataRetriever;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public ResponseEntity<User> getUserInfo() {
		return new ResponseEntity<User>(fbDataRetriever.retrieveData(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{name}",method=RequestMethod.GET)
	public ResponseEntity<List<User>> getPublicProfile(@PathVariable String name) {
		return new ResponseEntity<List<User>>(fbDataRetriever.findUsers(name),HttpStatus.OK);
	}

}

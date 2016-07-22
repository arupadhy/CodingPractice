package com.sapient.app.fb.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;

@Repository
public class FacebookDataRetriever {
	private static String EXTENDED_AI_APP_USER_ACCESS_TOKEN = "EAASAxlIhLOQBADUZCnV1n2X70Cm6ZCEk3N4WrOqkxMTQ5ukqXKCi5grKk0vw5Aycka8bg2VXnfEfUKQMkIfFmWMycYfqid2bcZABFT2LZAMIGewx68dBGhvXpX2lTxiwBuFWJoL1DV5J7GhssV4qjtmUFSjWr3ZAxiI9Pwc7NZBgZDZD";
	private FacebookClient client = new DefaultFacebookClient(EXTENDED_AI_APP_USER_ACCESS_TOKEN,Version.VERSION_2_7);

	
	@PostConstruct
	public User retrieveData() {
		User user = client.fetchObject("me",User.class,Parameter.with("fields", "name,email,education,about,bio,birthday,work"));
		return user;
	}
	
	public List<User> findUsers(String name) {
		List<User> results = new ArrayList<>();
		Connection<User> users = client.fetchConnection("search", User.class, Parameter.with("q", name),Parameter.with("type", "user"));
		for(User user: users.getData()) {
			if(!StringUtils.isEmpty(user.getAbout())) {
				results.add(user);
			}
		}
		return results;
	}

}

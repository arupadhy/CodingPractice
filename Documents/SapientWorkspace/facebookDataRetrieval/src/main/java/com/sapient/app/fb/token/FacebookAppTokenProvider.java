package com.sapient.app.fb.token;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Version;

public class FacebookAppTokenProvider {
	
	private static String AI_APP_USER_ACCESS_TOKEN = 
			"test";
	

	private static String APP_ID = "1267489176628452";
	private static String SECRET_KEY = "0fb349e7016df73899b1f30437c1fe6b";
	private FacebookClient facebookClient  = new DefaultFacebookClient(AI_APP_USER_ACCESS_TOKEN, Version.UNVERSIONED);

	public void extendTokenExpiry() {
		AccessToken extendedToken = facebookClient.obtainExtendedAccessToken(APP_ID, SECRET_KEY);
		System.out.println(extendedToken.getExpires());
		System.out.println(extendedToken.getAccessToken());
	}
	public static void main(String[] args) {
		new FacebookAppTokenProvider().extendTokenExpiry();
	}
}

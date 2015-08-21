package com.bancvue.facebook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;

@Configuration
public class FacebookConfig {

	private static String ACCESS_TOKEN = "1454693584839154|VcXUu4tVAKfPgHc7POTJZ5zBctk";
	private static String APP_SECRET = "d25fbc0804812085969096abb1a7c236";
	
	@Bean
	FacebookClient facebookClient() {
		return new DefaultFacebookClient(ACCESS_TOKEN, APP_SECRET, Version.VERSION_2_4);
	}
	
}

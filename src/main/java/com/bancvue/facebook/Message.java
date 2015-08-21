package com.bancvue.facebook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.batch.BatchRequest;
import com.restfb.batch.BatchRequest.BatchRequestBuilder;
import com.restfb.batch.BatchResponse;
import com.restfb.types.Account;
import com.restfb.types.User;

@Component
public class Message {

	public static String APP_ID = "1454693584839154";
	
	@Autowired
	FacebookClient facebookClient;
	
	public void sendMessage() {
	
		String accounts = String.format("%s/%s", APP_ID, "accounts");
		Connection<Account> connection = facebookClient.fetchConnection(accounts, Account.class);
		
		List<BatchRequest> batchRequests = new ArrayList<>();
		
		for (List<Account> lists : connection) {
			for (Account account : lists) {
				System.out.println("Account Id: " + account.getId());
	
				User user = facebookClient.fetchObject(account.getId() , User.class);
				System.out.println("Sending notification to " + user.getName());
				String notification = String.format("%s/notifications", user.getId());
				
				
				BatchRequest batchRequest = new BatchRequestBuilder(notification)
					.method("POST")
					.body(Parameter.with("href", "?dashboard=true"), Parameter.with("template", "Did you earn your rewards this month?  Click here to find out!"))
					.build();
				batchRequests.add(batchRequest);
			}
		}
		
		List<BatchResponse> batchResponses = facebookClient.executeBatch(batchRequests);
	
		for (BatchResponse batchResponse : batchResponses) {
			System.out.println("BatchResponse: " + batchResponse);
		}
		
	}
	
	
}

package Models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.google.gson.JsonObject;

public class User {
	//we are going easy here, we keep ids for later when we clean up
	private static ArrayList<Integer> ids = new ArrayList<Integer>();
	private String userName,firstName,lastName,email,password,phone;
	
	public User(String userName,String firstName,String lastName,String email,String password,String phone) {
		this.userName  = userName;
		this.firstName = firstName;
		this.lastName  = lastName;
		this.email     = email;
		this.password  = password;
		this.phone     = phone;
	}
	
	public String toJson() {	
		//create this instance json text for rest assured
		JsonObject orderJson = new JsonObject();		
		orderJson.addProperty("username",this.userName);
		orderJson.addProperty("firstName",this.firstName);
		orderJson.addProperty("lastName",this.lastName);
		orderJson.addProperty("email",this.email);
		orderJson.addProperty("password",this.password);
		orderJson.addProperty("phone",this.phone);
		orderJson.addProperty("userStatus",0);
		return orderJson.toString();
	}
}

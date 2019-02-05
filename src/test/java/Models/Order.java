package Models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Order {
	//we are going easy here, we keep ids for later when we clean up
	private static ArrayList<Long> ids = new ArrayList<Long>();
	private int petId,quantity;

	public Order(int petId,int quantity){
		this.petId    = petId;
		this.quantity = quantity;
	}
	
	public static void addIdToRemove(long createdId) {
		ids.add(createdId);
	}
	
		
	public String toJson() {	
		//create this instance json text for rest assured
		JsonObject orderJson = new JsonObject();		
		orderJson.addProperty("petId",this.petId);
		orderJson.addProperty("quantity",this.quantity);
		orderJson.addProperty("shipDate",new SimpleDateFormat(
			    "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US).format(new Date()));
		orderJson.addProperty("status","placed");
		orderJson.addProperty("complete","false");
		return orderJson.toString();
	}
}

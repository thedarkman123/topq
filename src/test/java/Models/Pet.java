package Models;

import java.util.ArrayList;

import com.google.gson.JsonObject;

public class Pet {
	//we are going easy here, we keep ids for later when we clean up
	private static ArrayList<Integer> ids = new ArrayList<Integer>();
	private String name;
	private int id;
	
	public Pet(int id,String name) {
		ids.add(id);
		this.name = name;
	}
	
	public String getJson() {
		JsonObject petJson = new JsonObject();		
		petJson.addProperty("id",id);
		return null;
	}
	
//	public static void main(String[] args) {
//		System.out.println("create json");
//	}
	
}

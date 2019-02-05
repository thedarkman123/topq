package Models;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Pet {
	//we are going easy here, we keep ids for later when we clean up
	private static ArrayList<Long> ids = new ArrayList<Long>();
	private String name,categoryName;
	private int categoryId;
	private ArrayList<String> photosUrlsArr = new ArrayList<String>();
	private ArrayList<String> tagsArr = new ArrayList<String>();
	
	public Pet(String name){
		this.name = name;
	}
	
	public static void addIdToRemove(long createdId) {
		ids.add(createdId);
	}
	
	public Pet setCategory(String name,int id){
		if (id <= 0) id = 1; //we can do a lot here, not the point 
		categoryName = name;
		categoryId = id;
		return this;
	}
	
	public Pet addPhotoUrl(String url){
		photosUrlsArr.add(url);
		return this;
	}
	
	public Pet addTag(String tag){
		tagsArr.add(tag);
		return this;
	}
	
	public String toJson() {
		//create this instance json text for rest assured
		JsonObject petJson = new JsonObject();		
		petJson.addProperty("name",this.name);
		petJson.addProperty("status","available");
		//categories
		JsonObject category = new JsonObject();	
			category.addProperty("id", (categoryId == 0) ? 1 : categoryId);
			category.addProperty("name", (categoryName == null) ? "Animal" : categoryName);
			petJson.add("category", category);
		//photos arr
		JsonArray jsArr = new JsonArray();
			if (photosUrlsArr.size() == 0) {
				jsArr.add("someDefaultUrl");
			} else {
				for(String photoUrl : photosUrlsArr){
					jsArr.add(photoUrl);
				}
			}
			petJson.add("photoUrls", jsArr);
		//tags arr
		JsonArray tagsToEnter = new JsonArray();
		JsonObject tags;
		if (tagsArr.size() == 0) {
			tags = new JsonObject();
			tags.addProperty("id", 0);
			tags.addProperty("name", "someDefaultTag");
			tagsToEnter.add(tags);
		} else {
			System.out.println("WE GOT A TAG");
			for(int i = 0; i <= tagsArr.size()-1 ;i++){
				tags = new JsonObject();	
				tags.addProperty("id", i);
				tags.addProperty("name", tagsArr.get(i));
				tagsToEnter.add(tags);
			}
		}
		petJson.add("tags", tagsToEnter);
		return petJson.toString();
	}
	
//	public static void main(String[] args) {
//		System.out.println("create json");
//	}
	
}

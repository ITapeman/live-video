package com.pili.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.pili.Credentials;
import com.pili.Meeting;
import com.pili.Meeting.Room;

@Controller
public class MeetingRoom {
	private String accessKey;
    private String secretKey;
    private Meeting meeting;

   /* @ResponseBody
    @RequestMapping("/creatRoom.json")*/
    public void creatRoom(HttpServletRequest request) throws Exception{
    	//主播的ID传过来，用来创建主播的房间
    	String ownerId = request.getQueryString();
    	System.out.println("userID --- " +ownerId);
    	 accessKey = "PbdNvcSv-OfX-H4yFaPQ8psXyOAEjKCerJ6SNUJS";
         secretKey = "d0Kub97tYFKHDukFEgq05-lWIf1ojX0hZBU51hma";

         Credentials credentials = new Credentials(accessKey, secretKey);
         meeting = new Meeting(credentials);
         if(meeting != null){
         	System.out.println("bu wei kong --- "+meeting.toString());
         }else{
        	 System.out.println(" 空 --- Meeting");
         }
    	//String roomName = String.valueOf(new Date().getTime());
    	String roomName = ownerId + "room";
    	Room room = meeting.getRoom(roomName);
    	
    	
    	if(room != null){
    		System.out.println("room.name --- " + room.name);
        	System.out.println("room.ownerId --- " + room.ownerId);
        	System.out.println("room.status --- " + room.status);
    	}else{
    		String newRoom = meeting.createRoom(ownerId, roomName);
    		System.out.println("roomName --- " + roomName);
    	}
    	
    	/*
    	//getRoom
    	 roomName --- 1485158905023
		newRoom --- 1485158905023
		room --- 1485158905023
		room --- user01
		room --- NEW
    	 //计算Roomtoken
    	 Date date = new Date();
    	 String roomToken = meeting.roomToken(roomName, "110", "admin",date );
    	 System.out.println("RoomToken --- "+ roomToken);
    	 
    	 JSONArray array = new JSONArray();
    	 JSONObject object = new JSONObject();
    	 object.put("UserID", 110);
    	 object.put("RoomName", roomName);
    	 object.put("RoomToken", roomToken);
    	 array.add(object);*/
    	/*return array.toString();*/
    }
    
    
    /*public String getRoom(HttpServletRequest request) throws PiliException{
    	String roomName = request.getQueryString();
    	 accessKey = "PbdNvcSv-OfX-H4yFaPQ8psXyOAEjKCerJ6SNUJS";
         secretKey = "d0Kub97tYFKHDukFEgq05-lWIf1ojX0hZBU51hma";

         Credentials credentials = new Credentials(accessKey, secretKey);
         meeting = new Meeting(credentials);
         Room room = meeting.getRoom(roomName);
    	return null;
    }*/
}

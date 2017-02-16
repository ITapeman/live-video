package com.pili.example;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pili.Credentials;
import com.pili.Meeting;
import com.pili.Meeting.Room;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
public class RoomToken {
	private String accessKey;
    private String secretKey;
    private Meeting meeting;
    /*@ResponseBody
    @RequestMapping("/getconnect.json")*/
	public String getRoomToken(HttpServletRequest request) throws Exception{
		String allthings = request.getQueryString();
		String[] info = allthings.split("&");
		String userID = info[0];
		String yonghuID = info[1];
		System.out.println("allthings---"+allthings);
		String roomName = userID + "room";
		 accessKey = "PbdNvcSv-OfX-H4yFaPQ8psXyOAEjKCerJ6SNUJS";
         secretKey = "d0Kub97tYFKHDukFEgq05-lWIf1ojX0hZBU51hma";

         Credentials credentials = new Credentials(accessKey, secretKey);
         meeting = new Meeting(credentials);
         if(meeting != null){
         	System.out.println("bu wei kong --- "+meeting.toString());
         }else{
        	 System.out.println(" 空 --- Meeting");
         }
    	//getRoom
    	 Room room = meeting.getRoom(roomName);
    	 System.out.println("room --- " + room.name);
    	 System.out.println("room --- " + room.ownerId);
    	 System.out.println("room --- " + room.status);
    	 
    	 String string = "2017-2-17 00:00:00";
    	// int i = 1486656000;
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date date = null;
         try {
             date = dateFormat.parse(string);
             System.out.println(date.toLocaleString().split(" ")[0]);//切割掉不要的时分秒数据
         } catch (ParseException e) {
             e.printStackTrace();
         }
    	 //计算Roomtoken
    	 /*Date date = new Date(140000000);*/
    	 String roomToken = meeting.roomToken(roomName, yonghuID, "admin",date);
    	 System.out.println("RoomToken --- "+ roomToken);
    	 
    	 JSONArray array = new JSONArray();
    	 JSONObject object = new JSONObject();
    	 object.put("UserID", yonghuID);
    	 object.put("RoomName", roomName);
    	 object.put("RoomToken", roomToken);
    	 array.add(object);
    	return array.toString();
		
	}
}

package com.saas.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pili.Credentials;
import com.pili.Meeting;
import com.pili.Meeting.Room;
import com.saas.biz.VideoPerSonBiz;
import com.saas.pojo.VideoPerSon;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class CreatRoom {
	private String accessKey;
    private String secretKey;
    private Meeting meeting;
    private String ownername ;//主播
    private String room;//房间编号
    private VideoPerSonBiz videoPerSonBiz;
    
    
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public void setVideoPerSonBiz(VideoPerSonBiz videoPerSonBiz) {
		this.videoPerSonBiz = videoPerSonBiz;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public void creatVideoRoom() throws Exception{
		//主播的ID传过来，用来创建主播的房间
    	 accessKey = "PbdNvcSv-OfX-H4yFaPQ8psXyOAEjKCerJ6SNUJS";
         secretKey = "d0Kub97tYFKHDukFEgq05-lWIf1ojX0hZBU51hma";

         Credentials credentials = new Credentials(accessKey, secretKey);
         meeting = new Meeting(credentials);
         if(meeting != null){
         	System.out.println("bu wei kong --- "+meeting.toString());
         }else{
        	 System.out.println(" 空 --- Meeting");
         }
         
        Boolean falg = false;
     	List<VideoPerSon> videoPerSons = videoPerSonBiz.getallInfo();
     	for(VideoPerSon vi : videoPerSons){
     		if(vi.getPersonname().equals(ownername)){
     			System.out.println("vi.getpName ----" + vi.getPersonname());
     			System.out.println("ownername --- "+ ownername);
     			falg = true;
     			break;
     		}
     	}
     	String roomName = room + "room";
    	if(falg == false){
    		String newRoom = meeting.createRoom(ownername, roomName);
    		VideoPerSon videoPerSon2 = new VideoPerSon(ownername,roomName);
    		videoPerSonBiz.addInfo(videoPerSon2);
    		System.out.println("没有房间但是已经创建房间-----");
    	}else{
    		roomName = videoPerSonBiz.getStreamByname(ownername).getRoomname();
    		Room room = meeting.getRoom(roomName);
    		System.out.println("有房间并且已经得到房间-----");
    	}
    	
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
   	 String roomToken = meeting.roomToken(roomName, ownername, "admin",date);
   	 System.out.println("RoomToken --- "+ roomToken);
   	 
     HttpServletResponse response=ServletActionContext.getResponse();
	 response.setContentType("text/html;charset=utf-8");  
	 PrintWriter out = response.getWriter(); 
   	 JSONArray array = new JSONArray();
   	 JSONObject object = new JSONObject();
   	 object.put("UserID", ownername);
   	 object.put("RoomName", roomName);
   	 object.put("RoomToken", roomToken);
   	 array.add(object);
   	 out.println(array); 
    }
}

package com.saas.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pili.Credentials;
import com.pili.Meeting;
import com.saas.biz.VideoPerSonBiz;
import com.saas.pojo.VideoPerSon;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import main.java.com.qiniu.pili.Client;

public class ZhiBoURL {
    private Meeting meeting;
	private String keyA ;
	private String username;
	private VideoPerSonBiz videoPerSonBiz;
	
	public void setKeyA(String keyA) {
		this.keyA = keyA;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setVideoPerSonBiz(VideoPerSonBiz videoPerSonBiz) {
		this.videoPerSonBiz = videoPerSonBiz;
	}

	public void liveAddress() throws Exception{
		System.out.println("keyA --- "+keyA);
		String accessKey = "PbdNvcSv-OfX-H4yFaPQ8psXyOAEjKCerJ6SNUJS";
	    String secretKey = "d0Kub97tYFKHDukFEgq05-lWIf1ojX0hZBU51hma";
		//初始化client
	    Client cli = new Client(accessKey,secretKey);
	    String hubName = "rmzb123";
	    
	    // RTMP推流地址
        String url = cli.RTMPPublishURL("pili-publish.www.ikechina.com", hubName, keyA, 3600);
        System.out.printf("keyA=%s RTMP推流地址=%s\n", keyA, url);
		
       
        //HDL直播地址
        String url4 = cli.HDLPlayURL("pili-live-hdl.www.ikechina.com", hubName, keyA);
        System.out.printf("keyA=%s HDL直播地址=%s\n", keyA, url4);
        
        VideoPerSon videoPerSon = videoPerSonBiz.getInfoBySname(keyA);
        String roomname = videoPerSon.getRoomname();
        
        Credentials credentials = new Credentials(accessKey, secretKey);
        meeting = new Meeting(credentials);
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
      	
      	 /*Date date = new Date(140000000);*/
      	 String roomToken = meeting.roomToken(roomname, username, "admin",date);
      	 System.out.println("RoomToken --- "+ roomToken);
        
        JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		object.put("RoomName", roomname);
		object.put("RoomToken", roomToken);
		object.put("TLURL", url);
		object.put("BFURL", url4);
		array.add(object);
		
	    HttpServletResponse response=ServletActionContext.getResponse();
	    response.setContentType("text/html;charset=utf-8");  
	    PrintWriter out = response.getWriter(); 
	    out.println(array);
	}
}

package com.saas.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import main.java.com.qiniu.pili.Client;
import main.java.com.qiniu.pili.Hub;
import main.java.com.qiniu.pili.PiliException;
import main.java.com.qiniu.pili.Stream;

public class ShowStream {
	public void showAllStream() throws PiliException, IOException{
		String accessKey = "PbdNvcSv-OfX-H4yFaPQ8psXyOAEjKCerJ6SNUJS";
	    String secretKey = "d0Kub97tYFKHDukFEgq05-lWIf1ojX0hZBU51hma";
		//初始化client
	    Client cli = new Client(accessKey,secretKey);
	    String hubName = "rmzb123";
        //初始化Hub
        Hub hub = cli.newHub("rmzb123");
        
        //所有流
        Hub.ListRet listRet = hub.list("javasdkexample",10 , "");
      
        String[] allstreams = listRet.keys;
		//拼接成json数据
        JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		int flag = 0;
		System.out.println("flag --- "+flag);
		for(String as : allstreams){
			object.put("StreamName", as);
			//是否开播
			Stream streamA  = hub.get(as);
			try{
	            Stream.LiveStatus status = streamA.liveStatus();
	            flag = 1;
	            object.put("VideoState", flag);
	            //System.out.printf("keyA=%s 直播状态: status=%s\n", as, status.toJson());
	        }catch (PiliException e){
	            if (!e.isNotInLive()) {
	                e.printStackTrace();
	            }else{
	            	flag = 0;
	            	object.put("VideoState", flag);
	            }
	        }
			 
			//封面地址
			String url = cli.SnapshotPlayURL("pili-live-snapshot.www.ikechina.com", hubName, as);
			object.put("VideoCover", url);
			String jeson = JSON.toJSONString(object,  SerializerFeature.DisableCircularReferenceDetect);
			array.add(JSON.parse(jeson));
		}
		System.out.println("array.toString ---"+array.toString());
		 HttpServletResponse response=ServletActionContext.getResponse();
		 response.setContentType("text/html;charset=utf-8");  
		 PrintWriter out = response.getWriter(); 
		 out.println(array);
	 }
}

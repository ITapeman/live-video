package com.saas.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.pili.Client;
import com.qiniu.pili.Config;
import com.qiniu.pili.Hub;
import com.qiniu.pili.PiliException;
import com.qiniu.pili.Stream;
import com.saas.biz.VideoPerSonBiz;
import com.saas.pojo.VideoPerSon;
import com.sun.org.apache.xpath.internal.operations.Bool;

import jdk.nashorn.internal.ir.Flags;

public class CreatPushURL {
	private String name;
	private VideoPerSonBiz videoPerSonBiz;
	
	
	public void setVideoPerSonBiz(VideoPerSonBiz videoPerSonBiz) {
		this.videoPerSonBiz = videoPerSonBiz;
	}

	public void setName(String name) {
		this.name = name;
	}
	//创建并保存流，并且一起保存用户的名字
	public void pushURL() throws IOException, PiliException{
		System.out.println("name 啊----------------------"+name);
		String accessKey = "PbdNvcSv-OfX-H4yFaPQ8psXyOAEjKCerJ6SNUJS";
        String secretKey = "d0Kub97tYFKHDukFEgq05-lWIf1ojX0hZBU51hma";
        String streamKeyPrefix = "javasdkexample" + String.valueOf(new Date().getTime());

        String hubName = "rmzb123";
        Config.APIHost = "pili.qiniuapi.com";
        
        //初始化client
        Client cli = new Client(accessKey,secretKey);

        //初始化Hub
        Hub hub = cli.newHub("rmzb123");
        Boolean falg = false;
        String keyA = null;
        VideoPerSon videoPerSon = null;
        List<VideoPerSon> videoPerSons = videoPerSonBiz.getallInfo();
        for(VideoPerSon vi : videoPerSons){
        	if(vi.getPersonname().equals(name)){
        		falg = true;
        		break;
        	}
        }
        Stream streamA = null;
        if(falg == true){
        	 videoPerSon = videoPerSonBiz.getStreamByname(name);
        	 keyA = videoPerSon.getStreamname();
        	  streamA = hub.get(keyA);
        }else{
        	//创建流
        	keyA = streamKeyPrefix + "A";
        	VideoPerSon vp = new VideoPerSon(name,keyA);
        	vp.setStreamname(keyA);
        	videoPerSonBiz.update(vp);
        	try {
        		streamA = hub.create(keyA);
        	}catch (PiliException e){
        		e.printStackTrace();
        	}
        	System.out.printf("keyA=%s 创建\n", keyA);
        	//userNameAndStream.put(name,keyA);
        }
        
      /*  
       try {
    	   videoPerSon = videoPerSonBiz.getStreamByname(name);
       } catch (Exception e) {
    	   
       }
       if(videoPerSon!= null){
    	   keyA = videoPerSon.getStreamname();
    	   falg1 = true;
       }
        Stream streamA = null;
        if(falg1 == true){
            try{
                streamA = hub.get(keyA);
            }catch (PiliException e){
                e.printStackTrace();
            }
            System.out.printf("keyA=%s 查询: %s\n", keyA, streamA.toJson());
        }else{
        	//创建流
        	keyA = streamKeyPrefix + "A";
        	VideoPerSon vp = new VideoPerSon(name,keyA);
        	vp.setStreamname(keyA);
        	videoPerSonBiz.update(vp);
        	try {
        		streamA = hub.create(keyA);
        	}catch (PiliException e){
        		e.printStackTrace();
        	}
        	System.out.printf("keyA=%s 创建\n", keyA);
        	//userNameAndStream.put(name,keyA);
        }*/
        
        // RTMP推流地址
        String url = cli.RTMPPublishURL("pili-publish.www.ikechina.com", hubName, keyA, 3600);
        System.out.printf("keyA=%s RTMP推流地址=%s\n", keyA, url);
        
        HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");  
		PrintWriter out = response.getWriter(); 
        //拼接成json数据
        JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		object.put("TLURL", url);
		object.put("StreamName", streamA);
		array.add(object);
		out.println(array);
	}
}

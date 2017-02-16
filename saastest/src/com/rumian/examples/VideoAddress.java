package com.rumian.examples;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import main.java.com.qiniu.pili.Client;
@Controller
public class VideoAddress {
	/*@ResponseBody
	@RequestMapping("/zburl.json")*/
	public String liveAddress(HttpServletRequest request){
		String keyA = request.getQueryString();
		String accessKey = "PbdNvcSv-OfX-H4yFaPQ8psXyOAEjKCerJ6SNUJS";
	    String secretKey = "d0Kub97tYFKHDukFEgq05-lWIf1ojX0hZBU51hma";
		//初始化client
	    Client cli = new Client(accessKey,secretKey);
	    String hubName = "rmzb123";
	    
	    // RTMP推流地址
        String url = cli.RTMPPublishURL("pili-publish.www.ikechina.com", hubName, keyA, 3600);
        System.out.printf("keyA=%s RTMP推流地址=%s\n", keyA, url);
		/* //HLS直播地址
        String url = cli.HLSPlayURL("pili-live-hls.www.ikechina.com", hubName, keyA);
        //System.out.printf("keyA=%s HLS直播地址=%s\n", keyA, url);
		
        //RTMP直播地址
        String url2 = cli.RTMPPlayURL("pili-live-rtmp.www.ikechina.com", hubName, keyA);
        System.out.printf("keyA=%s RTMP直播地址=%s\n", keyA, url2);*/
       
        //HDL直播地址
        String url4 = cli.HDLPlayURL("pili-live-hdl.www.ikechina.com", hubName, keyA);
        System.out.printf("keyA=%s HDL直播地址=%s\n", keyA, url4);
        
        JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		object.put("TLURL", url);
		object.put("BFURL", url4);
		array.add(object);
		return array.toString();
	}
}

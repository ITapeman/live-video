package com.rumian.examples;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.pili.Client;
import com.qiniu.pili.Config;
import com.qiniu.pili.Hub;
import com.qiniu.pili.PiliException;
import com.qiniu.pili.Stream;

@Controller
public class LiveVideo {
	
	
	//保存用户的名字以及他们的自己的流。
	Map<String,String> userNameAndStream = new HashMap<String,String>();
	
 	/*@ResponseBody
	@RequestMapping("/hello.json")*/
	 public String videoLive(HttpServletRequest request){
		String name = request.getQueryString();
		System.out.println("name --- " + name);
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
        Iterator<Map.Entry<String, String>> it = userNameAndStream.entrySet().iterator();
        while (it.hasNext()) {
        	Map.Entry<String, String> entry = it.next();
        	String keyname = entry.getKey();
        	System.out.println("Mapkeyname --- "+ keyname);
        	if(keyname.equals(name)){
        		falg = true;
        		keyA = entry.getValue();
        		System.out.println("MapkeyA"+keyA);
        		break;
        	}
        }
        Stream streamA;
        if(falg == true){
            try{
                streamA = hub.get(keyA);
            }catch (PiliException e){
                e.printStackTrace();
                return null;
            }
            System.out.printf("keyA=%s 查询: %s\n", keyA, streamA.toJson());
        }else{
        	//创建流
        	keyA = streamKeyPrefix + "A";
        	try {
        		streamA = hub.create(keyA);
        	}catch (PiliException e){
        		e.printStackTrace();
        		return null;
        	}
        	System.out.printf("keyA=%s 创建\n", keyA);
        	userNameAndStream.put(name,keyA);
        }
        
        // RTMP推流地址
        String url = cli.RTMPPublishURL("pili-publish.www.ikechina.com", hubName, keyA, 3600);
        System.out.printf("keyA=%s RTMP推流地址=%s\n", keyA, url);
        
        
        //拼接成json数据
        JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		object.put("TLURL", url);
		object.put("StreamName", streamA);
		array.add(object);
		return array.toString();
	 }
}

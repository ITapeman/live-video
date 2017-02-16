package com.pili.example;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.pili.Credentials;
import com.pili.Hub;
import com.pili.PiliException;
import com.pili.Stream;


@Controller
public class CreatStream {
	private static final String ACCESS_KEY = "PbdNvcSv-OfX-H4yFaPQ8psXyOAEjKCerJ6SNUJS";
	private static final String SECRET_KEY = "d0Kub97tYFKHDukFEgq05-lWIf1ojX0hZBU51hma";
	private static final String HUB_NAME = "rmzb123";
	/*
	@ResponseBody
	@RequestMapping("/creatStream.json")*/
	public String creatStreams(){
		Credentials credentials = new Credentials(ACCESS_KEY, SECRET_KEY); // Credentials Object
        Hub hub = new Hub(credentials, HUB_NAME);

        // Create a new Stream
        String title           = null;     // optional, auto-generated as default
        String publishKey      = null;     // optional, auto-generated as default
        String publishSecurity = null;     // optional, can be "dynamic" or "static", "dynamic" as default
        Stream stream = null;
        try {
            stream = hub.createStream(title, publishKey, publishSecurity);
            System.out.println("hub.createStream:");
            System.out.println(stream.toJsonString());
            /*
            {
                "id":"z1.test-hub.55d97350eb6f92638c00000a",
                "createdAt":"2015-08-22T04:54:13.539Z",
                "updatedAt":"2015-08-22T04:54:13.539Z",
                "title":"55d97350eb6f92638c00000a",
                "hub":"test-hub",
                "disabled":false,
                "publishKey":"ca11e07f094c3a6e",
                "publishSecurity":"dynamic",
                "hosts":{
                    "publish":{
                        "rtmp":"ey636h.publish.z1.pili.qiniup.com"
                     },
                     "live":{
                         "hdl":"ey636h.live1-hdl.z1.pili.qiniucdn.com",
                         "hls":"ey636h.live1-hls.z1.pili.qiniucdn.com",
                         "rtmp":"ey636h.live1-rtmp.z1.pili.qiniucdn.com"
                     },
                     "playback":{
                         "hls":"ey636h.playback1.z1.pili.qiniucdn.com"
                     }
                 }
             }
             */
        } catch (PiliException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return stream.toJsonString();
	}
	
	/*@ResponseBody
	@RequestMapping("/getStream.json")*/
	public String getStream(HttpServletRequest request){
		Credentials credentials = new Credentials(ACCESS_KEY, SECRET_KEY); // Credentials Object
        Hub hub = new Hub(credentials, HUB_NAME);
		Stream stream = null;
		String streamID = request.getQueryString();
		 try {
	            stream = hub.getStream(streamID);
	            System.out.println("hub.getStream:");
	            System.out.println(stream.toJsonString());
	            /*
	            {
	                "id":"z1.test-hub.55d80075e3ba5723280000d2",
	                "createdAt":"2015-08-22T04:54:13.539Z",
	                "updatedAt":"2015-08-22T04:54:13.539Z",
	                "title":"55d80075e3ba5723280000d2",
	                "hub":"test-hub",
	                "disabled":false,
	                "publishKey":"ca11e07f094c3a6e",
	                "publishSecurity":"dynamic",
	                "hosts":{
	                    "publish":{
	                        "rtmp":"ey636h.publish.z1.pili.qiniup.com"
	                     },
	                     "live":{
	                         "hdl":"ey636h.live1-hdl.z1.pili.qiniucdn.com",
	                         "hls":"ey636h.live1-hls.z1.pili.qiniucdn.com",
	                         "rtmp":"ey636h.live1-rtmp.z1.pili.qiniucdn.com"
	                     },
	                     "playback":{
	                         "hls":"ey636h.playback1.z1.pili.qiniucdn.com"
	                     }
	                 }
	             }
	             */
	        } catch (PiliException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		return stream.toJsonString();
		
	}
}

package com.rumian.examples;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import com.qiniu.pili.Client;
import com.qiniu.pili.Config;
import com.qiniu.pili.Hub;
import com.qiniu.pili.PiliException;
import com.qiniu.pili.Stream;

@Controller
public class SaveVideo {
	/*@RequestMapping("/saveVideo.json")*/
	public void saveLiveVideo(HttpServletRequest request){
		String keyA = request.getQueryString();
		System.out.println("sssss-----"+keyA);
		String accessKey = "PbdNvcSv-OfX-H4yFaPQ8psXyOAEjKCerJ6SNUJS";
        String secretKey = "d0Kub97tYFKHDukFEgq05-lWIf1ojX0hZBU51hma";

        String hubName = "rmzb123";
        Config.APIHost = "pili.qiniuapi.com";
        
        //初始化client
        Client cli = new Client(accessKey,secretKey);
        
        //初始化Hub
        Hub hub = cli.newHub("rmzb123");
        
        //获得流
        Stream streamA = null;
        try{
            streamA = hub.get(keyA);
        }catch (PiliException e){
            e.printStackTrace();
        }
        System.out.printf("keyA=%s 查询: %s\n", keyA, streamA.toJson());

        //保存直播数据
        String fname = null;
        try {
            fname = streamA.save(0,1000000);
        }catch (PiliException e){
            if (!e.isNotInLive()) {
                e.printStackTrace();
                
            }else{
                System.out.printf("keyA=%s 不在直播\n",keyA);
            }
        }
        System.out.printf("keyA=%s 保存直播数据: fname=%s\n", keyA, fname);
	}
}

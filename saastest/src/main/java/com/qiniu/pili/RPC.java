package main.java.com.qiniu.pili;

import java.net.URL;

import org.springframework.stereotype.Controller;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
@Controller
public class RPC {
    private Mac mac;
    private OkHttpClient okHttpClient;
    
    public RPC(){}
    
    public RPC(Mac mac) {
        this.mac = mac;
        this.okHttpClient = new OkHttpClient();
    }

    public Mac getMac() {
        return mac;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public String callWithJson(String urlStr, String json) throws Exception {
        String contentType = "application/json";
        URL url = new URL(urlStr);
        byte[] body = json.getBytes("UTF-8");
        String macToken = mac.signRequest(url, "POST", body, contentType);
        RequestBody rBody = RequestBody.create(MediaType.parse(contentType), body);
        Request request = new Request.Builder()
                .url(url)
                .post(rBody)
                .header("User-Agent", Config.APIUserAgent)
                .addHeader("Authorization", "Qiniu " + macToken)
                .addHeader("Content-Type", contentType)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new PiliException(response);
        }
    }
   
    public String callWithGet(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        String macToken = mac.signRequest(url, "GET", null, null);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .header("User-Agent", Config.APIUserAgent)
                .addHeader("Authorization", "Qiniu " + macToken)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new PiliException(response);
        }
    }
}

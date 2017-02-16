package main.java.com.qiniu.pili.utils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public final class HMac {
    private static final String MAC_NAME = "HmacSHA1";
    private static final String UTF8 = "UTF-8";

    public static byte[] HmacSHA1Encrypt(String dataStr, String secretKeyStr) throws Exception {
        SecretKey secretKeySpec = new SecretKeySpec(secretKeyStr.getBytes(), MAC_NAME);
        //鐢熸垚涓�涓寚瀹� Mac 绠楁硶 鐨� Mac 瀵硅薄
        Mac mac = Mac.getInstance(MAC_NAME);
        //鐢ㄧ粰瀹氬瘑閽ュ垵濮嬪寲 Mac 瀵硅薄
        mac.init(secretKeySpec);

        //瀹屾垚 Mac 鎿嶄綔
        return mac.doFinal(dataStr.getBytes());
    }
}

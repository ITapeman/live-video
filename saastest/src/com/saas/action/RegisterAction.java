package com.saas.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class RegisterAction {
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpSession session = request.getSession();
	
	
	public static String url = "http://service.winic.org:8009/sys_port/gateway/index.asp?";  
    public static String userid = "ITBeggar";  
    public static String account = "110120";  
    public static String password = "lishulong";  
          
      
    private String phonename;  
      
    public String getPhonename() {  
        return phonename;  
    }  
  
    public void setPhonename(String phonename) {  
        this.phonename = phonename;  
    }  
  
    //注册-往数据库中添加注册信息  
    public String add(){  
       /* //插入时间  
        Date date=new Date();  
        //String createTime=new Timestamp(date.getTime()).toString();  
        //密码加密后存入数据库  
        String md5Digest=DigestUtils.md5Hex(model.getLoginPassword());  
          
        //头像  
        String headimg="../../../images/默认头像.gif";  
        //等级  
        String userRank="0";  
        //成长值  
        Integer userGrowths=0;  
          
        //给实体赋值管理员类型和时间，头像，成长值，等级  
        model.setUserType(0);  
        model.setDatetime(date);  
        model.setTouxiang(headimg);  
        model.setUserRank(userRank);  
        model.setUserGrowths(userGrowths);  
          
        //往数据库中进行添加  
        userRegisterService.addUserRegister(model);  
          
        //显示注册界面  
*/        return "test";  
    }  
      
    //判断该手机号码是否已经注册  
   /* public void checkLoginname() throws Exception{  
          
        String result = "0";   
        //判断该手机号码是否已经注册  
        List<UserRegisterdomain> userlist=userRegisterService.findUser(phonename);  
        if(userlist!= null && userlist.size() > 0){  
            result = "1";  
        }else{  
            result = "0";  
        }  
        PrintWriter out = response.getWriter();  
        out.write(result.toString());   
    }  
      */
       
     //验证手机短信是否发送成功   
    public void sms() throws Exception {    
    	
        String result = "0";    
        /** 手机号码 */    
        Object jbPhone=request.getParameter("jbPhone");   
        System.out.println("jbphone------------------------"+jbPhone);
        /** 短信验证码 */    
        Object code = request.getParameter("code");
        System.out.println("code---------------------------"+code);
        /** 短信验证码存入session(session的默认失效时间30分钟) */    
        session.setAttribute("code", code.toString());    
   
        /** 单个手机号发送短信的方法的参数准备 */    
        // 手机号码    
        String mobilephone = jbPhone.toString();    
        // 短信内容+随机生成的6位短信验证码    
        String content = "【浙江神造科技】注册验证码为:" + code.toString();     
          
            /** 单个手机号发送短信 */    
           if (!sendMessage(content, mobilephone)) {    
                result = "0";// 失败    
            } else {    
                result = "1";// 成功    
                }    
      
        PrintWriter out = response.getWriter();    
        out.write(result.toString());   
    }    
      
    // 验证短信验证码是否正确   
    public void checkCode() throws Exception{    
        String result = "0";    
        // 获取手动输入的手机短信验证码   
        String SmsCheckCode = (String)(request.getParameter("SmsCheckCode"));     
        // 获取session中存放的手机短信验证码    
        Object code =session.getAttribute("code");    
        try {    
            if(SmsCheckCode != code.toString() && !SmsCheckCode.equals(code.toString())){    
                result = "0";    
            }else{    
                result = "1";    
            }    
        } catch (Exception e) {    
            throw new RuntimeException("短信验证失败", e);    
        }     
        PrintWriter out = response.getWriter();    
        out.write(result.toString());    
    }      
      
//验证手机是否发送成功的方法  
   
    public static boolean sendMessage( String content, String mobileNumber) {    
    	 SmsBase smsBase = new SmsBase();
        // 单个手机号码发送    
        try {    
            String  retObj = smsBase.SendSms(mobileNumber, content);  
            System.out.println("in sendMessage -------------------------");
            //System.out.println(retObj);  
            if (retObj == "未发送，编码异常") {     
                return false;    
            } else {    
                return true;    
            }   
        } catch (Exception ex) {    
            ex.printStackTrace();     
        }    
        return true;    
    }   
} 


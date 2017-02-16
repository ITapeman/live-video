package com.saas.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

public class PostGardenAction {
	private List<File> pstimg ;
	private List<String> pstimgContentType ;
	private List<String> pstimgFileName ;
	private String gtitle;
	private String gkeyword;
	private String gcontent;
	
	
	public String postgarden() throws Exception{
		
		String[] imgs = new String[7];
		String realPath = ServletActionContext.getServletContext().getRealPath("/");
		String chilepath =  getChildPath(realPath);//创建一个子目录
		for(int i = 0 ; i < pstimg.size() ; i++ ){  
			String path = realPath+chilepath;
			String dbpath = chilepath+"/"+pstimgFileName.get(i);
			imgs[i] = dbpath;
			System.out.println("dbpath:"+dbpath);
			File storeDirtory = new File(path);
			if(!storeDirtory.exists()){
				storeDirtory.mkdirs();
			}	
			OutputStream os = new FileOutputStream(new File(path,pstimgFileName.get(i)));  
			InputStream is = new FileInputStream(pstimg.get(i));  
			byte[] buf = new byte[1024];  
			int length = 0 ;  
			while(-1 != (length = is.read(buf) ) ){  
				os.write(buf, 0, length) ;  
			}  
			is.close();  
			os.close();  
		} 
		return "success";
                                                                                                                                                         	}
	
	//检索子目录是否存在，如果不存在则创建。
	private String getChildPath(String realPath) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String timenow = df.format(date);
		
		File file = new File(realPath,timenow);
		if(file.exists()){
			file.mkdirs();
		}
		return timenow;
	}

	
	
	public List<File> getPstimg() {
		return pstimg;
	}
	public void setPstimg(List<File> pstimg) {
		this.pstimg = pstimg;
	}
	public List<String> getPstimgContentType() {
		return pstimgContentType;
	}
	public void setPstimgContentType(List<String> pstimgContentType) {
		this.pstimgContentType = pstimgContentType;
	}
	public List<String> getPstimgFileName() {
		return pstimgFileName;
	}
	public void setPstimgFileName(List<String> pstimgFileName) {
		this.pstimgFileName = pstimgFileName;
	}
	public String getGtitle() {
		return gtitle;
	}
	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}
	public String getGkeyword() {
		return gkeyword;
	}
	public void setGkeyword(String gkeyword) {
		this.gkeyword = gkeyword;
	}
	public String getGcontent() {
		return gcontent;
	}
	public void setGcontent(String gcontent) {
		this.gcontent = gcontent;
	}
	
	
}

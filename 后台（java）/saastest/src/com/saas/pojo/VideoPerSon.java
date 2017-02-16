package com.saas.pojo;

public class VideoPerSon {
	private int vid;
	private String personname;
	private String streamname;
	private String roomname;
	
	public VideoPerSon(){}
	
	/*public VideoPerSon(String personname, String streamname) {
		super();
		this.personname = personname;
		this.streamname = streamname;
	}
*/
	public VideoPerSon(String personname, String roomname) {
		super();
		this.personname = personname;
		this.roomname = roomname;
	}
	
	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public String getStreamname() {
		return streamname;
	}
	public void setStreamname(String streamname) {
		this.streamname = streamname;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	
	
}

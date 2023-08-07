package com.ranga;

import java.io.Serializable;
import java.util.Date;

public class App implements Serializable {
	private String appName;
	private float version;
	private String author;	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public float getVersion() {
		return version;
	}
	public void setVersion(float version) {
		this.version = version;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "App [appName=" + appName + ", version=" + version + ", author="
				+ author +"]";
	}			
}
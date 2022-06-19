package com.dbs.web.crawler.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.omg.CORBA.PUBLIC_MEMBER;

@Entity
@Table(indexes = @Index(columnList = "keywords"))
public class URL {
	
	@Id
	private String url;
	@Transient
	private int depthLimit;
	private String description;
	private String keywords;
	private String text;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	public URL(){
	}
	
	public URL(String url, int depthLimit, String description, String keywords,String text){
		this.url = url;
		this.depthLimit = depthLimit;
		this.description = description;
		this.keywords = keywords;
		this.text = text;
	}

	public int getDepthLimit() {
		return depthLimit;
	}

	public void setDepthLimit(int depthLimith) {
		this.depthLimit = depthLimith;
	}

	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}

package com.instacar.urlshortener.dto;

public class ShortenUrl {

	private String fullUrl;
	private String shortUrl;
	
	public ShortenUrl() {
		shortUrl="";
		fullUrl="";
	}
	
	public ShortenUrl(String shortUrl ,String fullUrl) {
		this.shortUrl=shortUrl;
		this.fullUrl=fullUrl;
	}

	public String getfullUrl() {
		return fullUrl;
	}

	public void setfullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}

	public String getshortUrl() {
		return shortUrl;
	}

	public void setshortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

}

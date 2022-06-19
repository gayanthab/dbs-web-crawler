package com.dbs.web.crawler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.web.crawler.model.URL;
import com.dbs.web.crawler.service.WebCrawlerServiceInterface;

@RestController
public class WebCrawlerController {

	@Autowired
	WebCrawlerServiceInterface webCrawlerService;
	
	@GetMapping("/seach")
	public List<URL> seachText(@RequestParam(value="keyword") String keyword){
		
		return webCrawlerService.seachText(keyword);
		
	}
	
	@PostMapping("/url")
	public void addPageLinks(URL url){
		
		webCrawlerService.addPageLinks(url.getUrl(),0,url.getDepthLimit());
	}
}
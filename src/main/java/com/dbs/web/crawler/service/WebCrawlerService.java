package com.dbs.web.crawler.service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbs.web.crawler.model.URL;
import com.dbs.web.crawler.repository.WebCrawlerRepository;

@Component
public class WebCrawlerService implements WebCrawlerServiceInterface{
	
	@Autowired
	WebCrawlerRepository webCrawlerRepository;
	
	public void addPageLinks(String url,int depth,int depthLimit) {
		
		if((!webCrawlerRepository.existsById(url) && (depth < depthLimit))){
            try {
            	
                Document document = Jsoup.connect(url).get();
                Elements linksOnPage = document.select("a[href]");
                
                String description = !document.select("meta[name=description]").isEmpty() ? document.select("meta[name=description]").get(0).attr("content") : "";
                
                String keywords = !document.select("meta[name=keywords]").isEmpty() ? document.select("meta[name=keywords]").first().attr("content") : "";
                webCrawlerRepository.save(new URL(url,depthLimit,description,keywords,document.text()));
                
                System.out.println("Description : " + description);
                System.out.println("Keywords : " + keywords);
                
                depth++;
                for (Element page : linksOnPage) {
                    addPageLinks(page.attr("abs:href"),depth, depthLimit);
                }
            } catch (IOException e) {
                System.err.println("For '" + url + "': " + e.getMessage());
            }
		}
		
	}

	public List<URL> seachText(String keyword) {
		
		return webCrawlerRepository.findByKeywordsContains(keyword);
	}

}

package com.dbs.web.crawler.service;

import java.util.List;
import com.dbs.web.crawler.model.URL;

public interface WebCrawlerServiceInterface {
	
	public void addPageLinks(String url, int depth, int depthLimit);
	public List<URL> seachText(String keyword);

}

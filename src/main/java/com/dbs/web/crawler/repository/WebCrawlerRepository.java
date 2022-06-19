package com.dbs.web.crawler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.crawler.model.URL;


public interface WebCrawlerRepository extends CrudRepository<URL, String>{
	
	public List<URL> findByKeywordsContains(String keywords);
	
}

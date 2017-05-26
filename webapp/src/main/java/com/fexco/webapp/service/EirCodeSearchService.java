package com.fexco.webapp.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Class responsible for do the communication between the web application and external web service.
 */
@Service
@RequestMapping("/eircode_search")
public class EirCodeSearchService {
	private static final Logger LOG = Logger.getLogger(EirCodeSearchService.class);
	private final static RestTemplate restTemplate = new RestTemplate();
	
	@Value("${fexco.ws.id}")
    private String wsId;
	
	private static final String URL_EIR_CODE_SERVICE = "http://ws.postcoder.com/pcw/%s/address/%s/%s?format=json&lines=3";
	
	/**
	 * Main method to call the web service (ws.postcoder.com) and retrieve the address by eircode
	 * @param dataset - ({@link String})
	 * @param eircode - ({@link String})
	 * @return The answer with the complete address as JSON 
	 */
	@Cacheable("eirCodeCache") // Avoids unnecessary calls to eirCode web service
	@HystrixCommand(fallbackMethod="errorService")
	@ResponseBody
	@RequestMapping(value="/search", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public String searchEirCode(@RequestParam("ds") String dataset, @RequestParam("ec") String eircode) {
		
		LOG.info("EirCodeSearch.searchEirCode called.");
		
		String newEirCodeURL = String.format(URL_EIR_CODE_SERVICE, wsId, dataset, eircode); // Build the URL to the web service of search.
		
		// Was used String because this class need to be detach of the web tier.
        String response = restTemplate.getForObject(newEirCodeURL, String.class); // Call the ws.postcoder.com web service.
		
        if("Incorrect Search Key (check Status service for additional details)".equals(response)) {
        	response = "[{\"errorMessage\":\"" + response + "\"}]";
        }
        
		return response;
	}
	
	/**
	 * Method called if the link to the web service ws.postcoder.com is broken.
	 */
	public String errorService(@RequestParam("ds") String dataset, @RequestParam("ec") String eircode, Throwable t) {
		LOG.error("Hystrix fallbackMethod: " + t.getMessage());
		return "[{\"errorMessage\":\"The web service ws.postcoder.com is broken\"}]";
	}
	
}

package com.fexco.webapp.controller;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.util.StringUtils;

import com.fexco.webapp.model.Address;
import com.fexco.webapp.service.EirCodeSearchService;

/**
 * Class responsible for control the web application.
 */
@Controller
@RequestMapping("/webapp")
public class HomeController {

	private static final Logger LOG = Logger.getLogger(HomeController.class);
	private static final String EIRCODE_WEBSERVICE_URL = "http://localhost:8080/eircode_search/search";
	private final static RestTemplate restTemplate = new RestTemplate();
	
	/**
	 * Method responsible for open the main page.
	 * @param model - ({@link Model}) 
	 * @return The name of the page in the folder <b>"resources/templates"</b>
	 */
	@RequestMapping("/home")
	public String home(Model model) {        
        return "home_page";
	}
	
	/**
	 * Make the link to call the web service to retrieve the address of the eircode
	 * @param dataset - ({@link String})
	 * @param eircode - ({@link String})
	 * @return The same answer of the {@link EirCodeSearchService#searchEirCode(String)}
	 */
	@ResponseBody
	@RequestMapping(value="/search_eircode", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public Address[] searchEirCode(@RequestParam("ds") String dataset, @RequestParam("ec") String eircode) {
		Address[] response = null;
		
		if(StringUtils.isEmpty(eircode) || "undefined".equals(eircode)) {
			LOG.info("Eircode is invalid");
			
			Address addr = new Address();
			addr.setErrorMessage("Eircode is invalid");
			response = new Address[]{addr};
			
		} else {
			LOG.info("Home.searchEirCode called.");
			
			// Build the URL to the web service of search.
			StringBuilder eircodeWBurl = new StringBuilder();
			eircodeWBurl.append(EIRCODE_WEBSERVICE_URL)
				.append("?ds=").append(dataset)
				.append("&ec=").append(eircode);
			
			LOG.info("It will seek the eircode.");
			response = restTemplate.getForObject(eircodeWBurl.toString(), Address[].class); // Call the EirCodeSearch service.
			
			LOG.info("Response: " + response);
		}
		
		return response;
	}
}

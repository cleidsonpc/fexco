package com.cleidsonpc.webapp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.cleidsonpc.webapp.model.Address;
import com.cleidsonpc.webapp.service.EirCodeSearchService;

/**
 * Class responsible for control the web application.
 */
@Controller
@RequestMapping("/webapp")
public class HomeController {

	private static final Logger LOG = Logger.getLogger(HomeController.class);
	
	@Autowired
	private EirCodeSearchService eirCodeSearchService;
	
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
	@RequestMapping(value="/eircode/search", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public Address[] searchEirCode(@RequestParam("ds") String dataset, @RequestParam("ec") String eircode) {
		Address[] response = null;
		
		if(StringUtils.isEmpty(eircode) || "undefined".equals(eircode)) {
			LOG.info("Eircode is invalid");
			
			Address addr = new Address();
			addr.setErrorMessage("Eircode is invalid");
			response = new Address[]{addr};
			
		} else {
			LOG.info("Home.searchEirCode called.");
			
			LOG.info("It will seek the eircode.");
			response = eirCodeSearchService.searchEirCode(dataset, eircode); // Call the EirCodeSearch service.
			
			LOG.info("Response: " + response);
		}
		
		return response;
	}
}

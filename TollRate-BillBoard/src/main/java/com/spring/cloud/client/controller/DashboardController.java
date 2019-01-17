package com.spring.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.client.model.TollRate;

@Controller
public class DashboardController {
	
	/**
	 * Used as a marker annotation indicating that the annotated RestTemplate should use a RibbonLoadBalancerClient for interacting with your service(s).
	In turn, this allows you to use "logical identifiers" for the URLs you pass to the RestTemplate. These logical identifiers are typically the name of a service. For example:
	
	restTemplate.getForObject("http://some-service-name/user/{id}", String.class, 1);
	where some-service-name is the logical identifier.
	 */
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="getTollRateBackup")
	@RequestMapping("/dashboard")
	public String getTollRate(@RequestParam int stationId, Model m) {
		
		TollRate tr = restTemplate.getForObject("http://toll_service/tollrate/" + stationId, TollRate.class);
		System.out.println("stationId: " + stationId);
		m.addAttribute("rate", tr.getCurrentRate().doubleValue());
		return "dashboard";
	}
	
	public String getTollRateBackup(@RequestParam int stationId, Model m) {
		System.out.println("Fallback Operation Called!");
		
		m.addAttribute("rate", "1.00");
		return "dashboard";
	}

}
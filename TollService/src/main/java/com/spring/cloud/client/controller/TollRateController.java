package com.spring.cloud.client.controller;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.client.model.TollRate;

@RestController
public class TollRateController {

	@RequestMapping("/tollrate/{stationId}")
	public TollRate getTollRateDeatils(@PathVariable int stationId) {
		
		System.out.println("Station Requested::"+stationId);
		TollRate tollRate;
		
		switch(stationId) {
			case 1 :
				tollRate = new TollRate(stationId, new BigDecimal(0.55), Instant.now().toString());
				break;
			case 2 :
				tollRate = new TollRate(stationId, new BigDecimal(0.65), Instant.now().toString());
				break;
			case 3 :
				tollRate = new TollRate(stationId, new BigDecimal(0.23), Instant.now().toString());
				break;
			default :
				tollRate = new TollRate(stationId, new BigDecimal(0.87), Instant.now().toString());
				break;
		}
		
		return tollRate;
			
	}
}

package com.mycompany.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SlowService {
	Logger logger = Logger.getLogger(SlowService.class);
	
	public String doSlowWork() {
		logger.info("Start  slow work");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("finish slow work");
		// return "forward:/another"; // forward to another url
		return "index"; // return view's name
	}
}

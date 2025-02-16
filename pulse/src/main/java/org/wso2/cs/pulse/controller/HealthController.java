package org.wso2.cs.pulse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@GetMapping("/")
	public String index() {
		return "Service Is Up And Running";
	}

}

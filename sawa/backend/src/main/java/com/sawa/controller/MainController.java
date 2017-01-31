package com.sawa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class MainController {

	@RequestMapping({ "/**" })
	public String index() {
		return "index";
	}

}

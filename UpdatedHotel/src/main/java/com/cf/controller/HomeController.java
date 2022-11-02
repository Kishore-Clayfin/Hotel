package com.cf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
	 @GetMapping("api/user")
		public ModelAndView homePage()
		{
			ModelAndView mv=new ModelAndView("homepage");
			return mv;
		}
}

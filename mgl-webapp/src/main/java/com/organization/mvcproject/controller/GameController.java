package com.organization.mvcproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.model.Review;
import com.organization.mvcproject.api.service.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
		return new ModelAndView("reviewCreatePage", "command", new Review());
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public ModelAndView addReview(Review review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}

		return new ModelAndView("reviewDetailPage", "submittedReview", review);
	}
	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView game() {

		System.out.println("Get request to /games");

		return new ModelAndView("gamesPage", "command", new GameImpl());
	}

}
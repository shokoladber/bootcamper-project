//TODO 1.0   package naming convention, improve package declaration
package com.organization.mvcproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.model.Review;
import com.organization.mvcproject.service.GameService;

//TODO 1.0  follow java class naming, improve class name
@Controller
public class GameController {

	//TODO 1.0 variable naming convention, improve reference name
	@Autowired
	private GameService gameService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public ModelAndView review() {
	/**
	 * TODO 1.0 Rename the jsp view, to "reviewCreatePage" because it matches the URL triggering a circular view path error.
	 * update games.jsp as well.
	 * SEE:  https://www.baeldung.com/spring-circular-view-path-error
	 */
		return new ModelAndView("reviewCreatePage", "command", new Review());
	}

	@RequestMapping(value = "/addReview", method = RequestMethod.POST)
	public ModelAndView addReview(Review review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
	/**
	 * TODO 1.0 Rename the jsp view, to "reviewDetailPage" because what is the view the "result" of?
	 * update games.jsp as well.
	 */
		return new ModelAndView("reviewDetailPage", "submittedReview", review);
	}

	
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView game() {
		/**
		 * TODO 1.0 Rename the jsp view, to "games" because it matches the URL triggering a circular view path error.
		 * update games.jsp as well.
		 * SEE:  https://www.baeldung.com/spring-circular-view-path-error
		 */
		return new ModelAndView("gamesPage", "command", new Game());
	}

	/**
	 * TODO 2.0 (Separation of concerns) consider moving all controller endpoints that return a ResponseEntity into a @RestController.
	 */


}
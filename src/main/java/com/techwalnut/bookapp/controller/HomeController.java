package com.techwalnut.bookapp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techwalnut.bookapp.service.BookService;
import com.techwalnut.bookapp.vo.BookVO;
import com.techwalnut.bookapp.vo.PreviewVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BookService bookService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, ModelMap modelMap) {
		logger.info("Welcome home! The client locale is {}.", locale);
		List<PreviewVO> bookVOs = bookService.showAllBooks();
		System.out.println("BookVo :: "+bookVOs);
		modelMap.addAttribute("bookVos", bookVOs);
		return "home";
	}
	
}

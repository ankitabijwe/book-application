package com.techwalnut.bookapp.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techwalnut.bookapp.service.BookService;
import com.techwalnut.bookapp.vo.PreviewVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	BookService bookService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, ModelMap modelMap) {
		int pageIndex = 0;
		int numberOfRecordsPerPage = 4;
		int count = bookService.getTotalCount();
		List<PreviewVO> bookVOs = bookService.showAllBooks(pageIndex,numberOfRecordsPerPage);
		
		
		modelMap.addAttribute("count", count);
		modelMap.addAttribute("bookVos", bookVOs);
		
		return "home";
	}
	
	@RequestMapping(value="showbooks",method=RequestMethod.POST)
	public String showBookPageWise(ModelMap modelMap,@RequestParam int num){
		List<PreviewVO> bookVOs = bookService.showAllBooks(num,4);
		modelMap.addAttribute("bookVos", bookVOs);
	//	modelMap.addAttribute("count", bookVOs.size());
		//List<PreviewVO> bookVos = bookService.getBookPageWise(num);
		return "sample";
	}
	
}

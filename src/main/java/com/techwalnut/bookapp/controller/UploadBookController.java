package com.techwalnut.bookapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techwalnut.bookapp.service.UploadBookService;
import com.techwalnut.bookapp.vo.BookVO;

@Controller
@RequestMapping("/uploadController")
public class UploadBookController {

	@Autowired 
	UploadBookService uploadBookService;
	
	@RequestMapping(value = "/getUploadForm", method = RequestMethod.GET)
	public String getUploadForm(ModelMap modelMap) {
		return "uploadBookForm";
	}

	@RequestMapping(value = "/uploadBook", method = RequestMethod.POST)
	public String uploadBook(HttpServletRequest request,ModelMap map,BookVO bookVO) {
		System.out.println("BookVO ::"+bookVO.getFile().getOriginalFilename());
		boolean isSaved = uploadBookService.saveBookData(bookVO);
		if(isSaved)
			map.addAttribute("msg","Successfully uploaded" );
		else
			map.addAttribute("msg","Not uploaded" );
		return "uploadBookForm";
	}
	
	
}


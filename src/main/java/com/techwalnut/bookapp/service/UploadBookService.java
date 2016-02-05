package com.techwalnut.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwalnut.bookapp.manager.UploadBookManager;
import com.techwalnut.bookapp.vo.BookVO;
@Service
public class UploadBookService {

	@Autowired
	UploadBookManager uploadBookManager;

	public boolean saveBookData(BookVO bookVO) {
		return uploadBookManager.saveBookData(bookVO);
	}

}

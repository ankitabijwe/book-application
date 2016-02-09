package com.techwalnut.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwalnut.bookapp.manager.BookManager;
import com.techwalnut.bookapp.vo.BookVO;
import com.techwalnut.bookapp.vo.PreviewVO;

@Service
public class BookService {

	@Autowired
	BookManager bookManager;

	public List<PreviewVO> showAllBooks(int pageIndex, int numberOfRecordsPerPage) {
		return bookManager.showAllBooks(pageIndex,numberOfRecordsPerPage);

	}

	public List<PreviewVO> getBookPageWise(String num) {
		return bookManager.getBookPageWise(num);

		
	}

	public int getTotalCount() {
		return bookManager.getTotalCount();
		
	}

}

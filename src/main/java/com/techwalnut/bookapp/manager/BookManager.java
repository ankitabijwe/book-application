package com.techwalnut.bookapp.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.techwalnut.bookapp.dao.BookDao;
import com.techwalnut.bookapp.vo.BookVO;
import com.techwalnut.bookapp.vo.PreviewVO;

@Component
public class BookManager {

	@Autowired
	BookDao bookDao;

	@Value("${IMAGEPATH}")
	String imagePath;

	@Value("${PDFPATH}")
	String pdfPath;

	public List<PreviewVO> showAllBooks() {
		List<PreviewVO> bookVOs = bookDao.showAllBooks();
		for (PreviewVO bookVO : bookVOs) {
			bookVO.setBookImage(imagePath + File.separator + bookVO.getBookImage());
			bookVO.setFile(pdfPath + File.separator + bookVO.getFile());
		

		}
		return bookVOs;

	}
}

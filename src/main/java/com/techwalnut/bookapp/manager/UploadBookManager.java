package com.techwalnut.bookapp.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.techwalnut.bookapp.dao.UploadBookDao;
import com.techwalnut.bookapp.vo.BookVO;

@Component
public class UploadBookManager {

	@Autowired
	UploadBookDao uploadBookDao;

	@Value("${PDFPATH}")
	String pdfPath;

	@Value("${IMAGEPATH}")
	String imagePath;

	public boolean saveBookData(BookVO bookVO) {
		try {
			
			copyToFolder(pdfPath,bookVO.getFile());
			copyToFolder(imagePath, bookVO.getBookImage());
			System.out.println("ImagePath :: " + imagePath + "\n PDFPAth :: " + pdfPath);
			
			
			return uploadBookDao.saveBookData(bookVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("resource")
	private void copyToFolder(String filepath, MultipartFile multipartFile) throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		inputStream = multipartFile.getInputStream();
		File pdffile = new File(filepath + File.separator + multipartFile.getOriginalFilename());
		outputStream = new FileOutputStream(pdffile);
		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}
	}

}

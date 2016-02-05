package com.techwalnut.bookapp.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techwalnut.bookapp.vo.BookVO;

@Controller
@RequestMapping("/showBookController")
public class ShowBookController {

	@RequestMapping(value = "/getBookImage", method = RequestMethod.GET)
	public void showBook(HttpServletResponse response, HttpServletRequest request, @RequestParam String filename) {
		System.out.println(filename);
		File file = new File(filename);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		FileInputStream fileInputStream = null;
		byte[] bFile = new byte[(int) file.length()];

		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);

			response.getOutputStream().write(bFile);

			response.getOutputStream().close();
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/getPdf", method=RequestMethod.GET)
	public void showPdf(HttpServletResponse response,HttpServletRequest request,@RequestParam String pdfPath) throws IOException{
		System.out.println(pdfPath);
		File file = new File(pdfPath);
		ServletOutputStream servletOutputStream = null;
		BufferedInputStream inputStream = null;
		try{
			servletOutputStream = response.getOutputStream();
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition",
                    "inline; filename=dwg.pdf");
            response.setContentLength((int) file.length());
            inputStream = new BufferedInputStream(new FileInputStream(file));
            int readBytes = 0;
            while ((readBytes = inputStream.read()) != -1)
            	servletOutputStream.write(readBytes);
        }
		catch(Exception e){
			e.printStackTrace();
			}finally {
            if (servletOutputStream != null)
            	servletOutputStream.flush();
            servletOutputStream.close();
            if (inputStream != null)
            	inputStream.close();
        }
		}
	}


package com.techwalnut.bookapp.vo;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class BookVO {
	int id;
	MultipartFile file;
	MultipartFile bookImage;
	String bookName;
	String bookAuthor;
	String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public MultipartFile getBookImage() {
		return bookImage;
	}

	public void setBookImage(MultipartFile bookImage) {
		this.bookImage = bookImage;
	}
	

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "BookVO [id=" + id + ", file=" + file + ", bookImage=" + bookImage + ", bookName=" + bookName
				+ ", bookAuthor=" + bookAuthor + ", email=" + email + "]";
	}

	

}

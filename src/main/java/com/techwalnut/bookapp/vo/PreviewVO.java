package com.techwalnut.bookapp.vo;

import java.sql.Timestamp;

public class PreviewVO {
	

		int id;
		String file;
		String bookImage;
		String bookName;
		String bookAuthor;
		String email;
		Timestamp date;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFile() {
			return file;
		}

		public void setFile(String file) {
			this.file = file;
		}

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public String getBookImage() {
			return bookImage;
		}

		public void setBookImage(String bookImage) {
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

		
		public Timestamp getDate() {
			return date;
		}

		public void setDate(Timestamp date) {
			this.date = date;
		}

		@Override
		public String toString() {
			return "PreviewVO [id=" + id + ", file=" + file + ", bookImage=" + bookImage + ", bookName=" + bookName
					+ ", bookAuthor=" + bookAuthor + ", email=" + email + ", time=" + date + "]";
		}

	}


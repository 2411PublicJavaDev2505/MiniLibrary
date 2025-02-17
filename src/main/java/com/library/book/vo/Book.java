package com.library.book.vo;

public class Book {
	private int bookNo;
	private String bookName;
	private String bookWriter;
	private int bookPrice;
	private String publisher;
	private String genre;
	
	public Book() {}
	
	public Book(int bookNo, String bookName, String bookWriter, int bookPrice, String publisher, String genre) {
		super();
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookPrice = bookPrice;
		this.publisher = publisher;
		this.genre = genre;
	}



	public Book(String bookName, String bookWriter, int bookPrice, String publisher, String genre) {
		super();
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookPrice = bookPrice;
		this.publisher = publisher;
		this.genre = genre;
	}

	public int getBookNo() {
		return bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookName=" + bookName + ", bookWriter=" + bookWriter + ", bookPrice="
				+ bookPrice + ", publisher=" + publisher + ", genre=" + genre + "]";
	}
	
	

}

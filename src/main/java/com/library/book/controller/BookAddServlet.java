package com.library.book.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.library.book.service.BookService;
import com.library.book.vo.Book;

/**
 * Servlet implementation class BookAddServlet
 */
@WebServlet("/book/add")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/book/add.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		String bookName = request.getParameter("bookName");
		String bookWriter = request.getParameter("bookWriter");
		int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
		String publisher = request.getParameter("publisher");
		String genre = request.getParameter("genre");
		
		Book book = new Book(bookName, bookWriter, bookPrice, publisher, genre);
		BookService nService = new BookService();
		
		int result = nService.addBook(book);
		if(result > 0 ) {
			response.sendRedirect("/book/list");			
		}
		
	}

}

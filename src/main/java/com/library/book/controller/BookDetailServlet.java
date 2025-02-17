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
 * Servlet implementation class BookDetailServlet
 */
@WebServlet("/book/detail")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService nService = new BookService(); 
//		int bookNo = (request.getParameter("bookNo")!=null)
//				?Integer.parseInt(request.getParameter("bookeNo")):1;\
		
		int bookNo = Integer.parseInt(request.getParameter("bookNo")) ;
		
		
		Book book = nService.selectOneByNo(bookNo);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/WEB-INF/views/book/detail.jsp")
		.forward(request, response);	
	}
}

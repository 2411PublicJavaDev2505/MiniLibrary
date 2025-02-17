package com.library.book.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.library.book.service.BookService;
import com.library.book.vo.Book;
import com.library.book.vo.SearchVO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/book/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService nService = new BookService();
//		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		SearchVO search = new SearchVO(searchCondition, searchKeyword);
		
		List<Book> searchList = nService.selectSearchList(search);

		request.setAttribute("searchList", searchList);
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("searchCondition", searchCondition);
//		request.setAttribute("bookNo", bookNo);
		request.getRequestDispatcher("/WEB-INF/views/book/search.jsp")
		.forward(request, response);
	}

}

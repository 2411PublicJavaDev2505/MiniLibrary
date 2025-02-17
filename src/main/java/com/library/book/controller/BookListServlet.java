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
import com.library.lease.common.NavigationUtil;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/book/list")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService nService = new BookService();
		
		int totalCount = nService.getTotalCount();
		int boardLimit = 10;
		int maxPage = (int)Math.ceil((double)totalCount / boardLimit);
		
		int currentPage = request.getParameter("currentPage") != null
				? Integer.parseInt(request.getParameter("currentPage")) : 1;
		
		List<Book> nList = nService.selectListAll(currentPage);
		
		if(nList.size() > 0 ) {
			int naviCountperPage = 5;
			int startNavi = (currentPage-1)/naviCountperPage*naviCountperPage+1;
			int endNavi = (startNavi-1) + naviCountperPage;
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
			
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
			
			request.setAttribute("nList", nList);
			request.getRequestDispatcher("/WEB-INF/views/book/list.jsp").forward(request, response);
		}else {
			NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다.");
			
		}
		
	}

}

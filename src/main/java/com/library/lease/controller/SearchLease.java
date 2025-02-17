package com.library.lease.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.library.lease.model.service.LeaseService;
import com.library.lease.model.vo.Lease;
import com.library.lease.model.vo.SearchVo;
import com.library.user.model.vo.User;

/**
 * Servlet implementation class SearchLease
 */
@WebServlet("/total/lease")
public class SearchLease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchLease() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseService lService = new LeaseService();
		
		int totalCount = lService.getTotalCount();
		int boardLimit = 10;
		int maxPage = (int)Math.ceil((double)totalCount / boardLimit);
	
		int currentPage = request.getParameter("currentPage") != null
				? Integer.parseInt(request.getParameter("currentPage")) : 1;
		
		List<Lease> lList = lService.selectLeaseList(currentPage);
		//List<User> uList = lService.selectListAll(currentPage);
		if(lList.size() > 0 ) {
			int naviCountperPage = 5;
			int startNavi = (currentPage-1)/naviCountperPage*naviCountperPage+1;
			int endNavi = (startNavi-1) + naviCountperPage;
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
			
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("lList", lList);
			//request.setAttribute("lList", llist);
			request.getRequestDispatcher("/WEB-INF/views/lease/lease.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseService lService = new LeaseService();
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		SearchVo search = new SearchVo(searchCondition, searchKeyword);
		
		List<Lease> lList = lService.searchOneByCondition(search);
		System.out.println(lList);
		request.setAttribute("lList", lList);
		//System.out.println(lList);
		if(lList != null) {
			request.getRequestDispatcher("/WEB-INF/views/lease/search.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/lease/error.jsp").forward(request, response);
		}
		
		
	}

}

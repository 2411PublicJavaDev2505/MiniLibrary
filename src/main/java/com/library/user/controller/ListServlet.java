package com.library.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.library.user.model.service.UserService;
import com.library.user.model.vo.User;
import com.library.lease.common.NavigationUtil;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/user/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService uService = new UserService();
		
		int totalCount = uService.getTotalCount();
		int boardLimit = 10;
		int maxPage = (int)Math.ceil((double)totalCount / boardLimit);
	
		int currentPage = request.getParameter("currentPage") != null
				? Integer.parseInt(request.getParameter("currentPage")) : 1;
		List<User> uList = uService.selectListAll(currentPage);
		if(uList.size() > 0 ) {
			int naviCountperPage = 5;
			int startNavi = (currentPage-1)/naviCountperPage*naviCountperPage+1;
			int endNavi = (startNavi-1) + naviCountperPage;
			if(endNavi > maxPage) {
				endNavi = maxPage;
			}
			
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.setAttribute("maxPage", maxPage);
			
			request.setAttribute("uList", uList);
			request.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(request, response);
		}else {
			NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다.");
			
		}
		

	}
}

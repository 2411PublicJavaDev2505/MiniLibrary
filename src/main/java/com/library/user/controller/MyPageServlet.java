package com.library.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.library.user.model.service.UserService;
import com.library.user.model.vo.User;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/user/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	UserService uService = new UserService();    	
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		User user = uService.searchOneByNo(userId);
		if(user != null) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp")
			.forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
	
		}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));
		String userAddr = request.getParameter("userAddr");
		String gender = request.getParameter("gender");
		String userId = request.getParameter("userId");
		User user = new User(userId, userName, age, userAddr, gender);
		UserService uService = new UserService();
		int result = uService.updateUser(user);
		if(result > 0) {
			response.sendRedirect("/user/list");
		}else {
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp")
			.forward(request, response);
		}
    }
    }
package com.library.lease.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.library.book.service.BookService;
import com.library.book.vo.Book;
import com.library.lease.common.NavigationUtil;
import com.library.lease.model.service.LeaseService;
import com.library.lease.model.vo.Lease;
import com.library.lease.model.vo.SearchVo;
import com.library.user.model.service.UserService;
import com.library.user.model.vo.User;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert/lease")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseService lService = new LeaseService();
		List<Lease> llist = lService.selectLeaseList();
		
		request.setAttribute("lList", llist);
		//System.out.println(llist);
		request.getRequestDispatcher("/WEB-INF/views/lease/insert.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseService lService = new LeaseService();
		BookService bService = new BookService();
		UserService uService = new UserService();
		
		String bookTitle = request.getParameter("bookTitle");
		String userName = request.getParameter("userName") ;
		int bookNo = 0;
		String userid = "";
		
		
		//SearchVo searchVo = new SearchVo(searchCondition, searchKeyword);
		
		
		List<Book> bList = bService.selectListAll();
		List<User> uList = uService.selectListAll();

		//System.out.println(bList);
		//System.out.println(uList);
		
		for(Book book : bList) {
			if(bookTitle.equals(book.getBookName())) {;
			bookNo = book.getBookNo();
			//System.out.println(bookNo);
//			return;
			}
		}
		
		for(User user : uList) {
			//System.out.println(user);
			if(userName.equals(user.getUserName())) {
				userid = user.getUserId();
				//System.out.println(userid);
				break;
			}
		}
		
		Lease lease = new Lease(bookNo, userid);
		
		int result = lService.insertLease(lease);
		System.out.println(result);
		if(result > 0 ) {
			response.sendRedirect("/total/lease");
		}else {
			NavigationUtil.navigateToError(request, response, "404", "잘못됨");
		}
		
		
		
		
		
//		if(bookNo > 0) {
//			for(User user : uList) {
//				System.out.println(user);
//				if(userName.equals(user.getUserName())) {
//					userid = user.getUserId();
//					System.out.println(userid);
//					return;
//				}else {
//					NavigationUtil.navigateToError(request, response, "404", "고객 이름을 확인해주세요");
//				}
//			}
//		}else {
//			NavigationUtil.navigateToError(request, response, "404", "책 제목을 확인해주세요");
//		}
//		
//		Lease lease = new Lease(bookNo, userid);
		
		
		//System.out.println(lease.getBookNo());
		//System.out.println(lease.getUserId());
		
//		System.out.println(lease);

		
		
		
		
//		if(result > 0) {
//			//request.getRequestDispatcher("/WEB-INF/views/lease/lease.jsp").forward(request, response);
//			response.sendRedirect("/total/lease");
//		}else {
//			NavigationUtil.navigateToError(request, response, "404", "책 번호 , 고객 이름을 확인해주세요");
//		}	
	}
}

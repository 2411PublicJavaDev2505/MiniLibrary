package com.library.lease.common;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NavigationUtil {
	private static final String ERROR_PAGE = "/WEB-INF/views/common/error.jsp";


	public static void navigateToError
	(HttpServletRequest request, HttpServletResponse response
			, String errorCode, String errorMessage) 
					throws ServletException, IOException {
		request.setAttribute("errorcode", errorCode);
		request.setAttribute("errorMessage", errorMessage);
		request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
	}
	
}


package com.library.book.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;


import com.library.book.dao.BookDAO;
import com.library.book.vo.Book;
import com.library.book.vo.SearchVO;
import com.library.lease.common.SqlSessionTemplate;

public class BookService {
	
	private BookDAO nDao;
	private SqlSession session;
	
	public BookService() {
		nDao = new BookDAO();
		session = SqlSessionTemplate.getSqlSession();
		
	}

	public List<Book> selectListAll(int currentPage) {
		List<Book> nList = nDao.selectList(session, currentPage);
		return nList;
	}
	
	public List<Book> selectListAll() {
		List<Book> nList = nDao.selectList(session);
		return nList;
	}

	public int deleteBook(int bookNo) {
		int result = nDao.deleteBook(session, bookNo);
		return result;
	}

	public List<Book> selectSearchList(SearchVO search) {
		List<Book> searchList = nDao.selectSearchList(session, search);
		return searchList;
	}

	public int addBook(Book book) {
		int result = nDao.addBook(session, book);
		return result;
	}

	public Book selectOneByNo(int bookNo) {
		Book book = nDao.selectOneByNo(session, bookNo);
		return book;
	}

	public int getTotalCount() {
		int totalCount = nDao.getTotalCount(session);
		return totalCount;
	}


}

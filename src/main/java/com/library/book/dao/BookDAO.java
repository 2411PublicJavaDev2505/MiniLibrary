package com.library.book.dao;


import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.library.book.vo.Book;
import com.library.book.vo.SearchVO;

public class BookDAO {

	public List<Book> selectList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<Book> nList = session.selectList("BookMapper.selectList" ,  null, rowBounds);
		return nList;
	}
	
	public List<Book> selectList(SqlSession session) {
		
		
		List<Book> nList = session.selectList("BookMapper.selectList" );
		return nList;
	}

	public List<Book> selectSearchList(SqlSession session, SearchVO search) {
		List<Book> searchList = session.selectList("BookMapper.selectSearchList", search);
		return searchList;
	}

	public int deleteBook(SqlSession session, int bookNo) {
		int result = session.delete("BookMapper.deleteBook", bookNo);
		return result;
	}

	public int addBook(SqlSession session, Book book) {
		int result = session.insert("BookMapper.addBook", book);
		return result;
	}

	public Book selectOneByNo(SqlSession session, int bookNo) {
		Book book = session.selectOne("BookMapper.selectOneByNo", bookNo);
		return book;
	}

	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("BookMapper.getTotalCount");
		return totalCount;
	}
}
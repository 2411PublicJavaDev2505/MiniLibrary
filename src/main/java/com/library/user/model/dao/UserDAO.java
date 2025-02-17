package com.library.user.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.library.user.model.vo.SearchVO;
import com.library.user.model.vo.User;

public class UserDAO {

	public int insertUser(SqlSession session, User user) {
		int result = session.insert("UserMapper.insertUser", user);
		return result;
	}

	public int updateUser(SqlSession session, User user) {
		int result = session.update("UserMapper.updateUser", user);
		return result;
	}

	public int deleteUser(SqlSession session, String userId) {
		int result = session.delete("UserMapper.deleteUser", userId);
		return result;
	}

	public List<User> selectList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<User> uList = session.selectList("UserMapper.selectList", null, rowBounds);
		return uList;
	}

	public List<User> selectList(SqlSession session) {
		List<User> uList = session.selectList("UserMapper.selectList");
		return uList;
	}
	public List<User> selectById(SqlSession session, String searchId) {
		List<User> selectById = session.selectList("UserMapper.selectById", searchId);
		return selectById;
	}

	public List<User> selectSearchList(SqlSession session, SearchVO search) {
		List<User> searchList = session.selectList("UserMapper.selectSearchList", search);
		return searchList;
	}

	public User selectOneById(SqlSession session, String userId) {
		User user = session.selectOne("UserMapper.selectOneById", userId);
		return user;
	}

	public User searchOneByNo(SqlSession session, String userId) {
		User user = session.selectOne("UserMapper.searchOneByNo", userId);
		return user;
	}

	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("UserMapper.getTotalCount");
		return totalCount;
	}

	

}

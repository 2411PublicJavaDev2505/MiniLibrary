package com.library.user.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.library.lease.common.SqlSessionTemplate;
import com.library.user.model.dao.UserDAO;
import com.library.user.model.vo.SearchVO;
import com.library.user.model.vo.User;

public class UserService {
	
	private UserDAO uDao;
	private SqlSession session;
	
	public UserService() {
		uDao = new UserDAO();
		session = SqlSessionTemplate.getSqlSession();
	}
	public int insertUser(User user) {
		int result = uDao.insertUser(session, user);
		return result;
	}
	public int updateUser(User user) {
		int result = uDao.updateUser(session, user);
		return result;
	}
	public int deleteUser(String userId) {
		int result = uDao.deleteUser(session, userId);
		return result;
	}
	public List<User> selectListAll(int currentPage) {
		List<User> uList = uDao.selectList(session, currentPage);
		return uList;
	}
	public List<User> selectListAll() {
		List<User> uList = uDao.selectList(session);
		return uList;
	}
	public List<User> selectSearchList(SearchVO search) {
		List<User> searchList = uDao.selectSearchList(session, search);
		return searchList;
	}
	public User searchOneByNo(String userId) {
		User user = uDao.searchOneByNo(session, userId);
		return user;
	}
	public int getTotalCount() {
		int totalCount = uDao.getTotalCount(session);
		return totalCount;
	}

	


}

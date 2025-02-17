package com.library.lease.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.library.lease.common.SqlSessionTemplate;
import com.library.lease.model.dao.LeaseDAO;
import com.library.lease.model.vo.Lease;
import com.library.lease.model.vo.SearchVo;
import com.library.user.model.vo.User;

public class LeaseService {
	private LeaseDAO lDao;
	private SqlSession session;
	
	
	public LeaseService() {
		lDao = new LeaseDAO();
		session = SqlSessionTemplate.getSqlSession();
	}

	
	

	public List<Lease> selectLeaseList() {
		List<Lease> lList = lDao.selectLeaseList(session);
		return lList;
	}
	
	public List<Lease> selectLeaseList(int currentPage) {
		List<Lease> lList = lDao.selectLeaseList(session, currentPage);
		return lList;
	}
	




	public List<Lease> searchOneByCondition(SearchVo search) {
		List<Lease>lList = lDao.searchOneByCondition(session, search);
		return lList;
	}




	public int insertLease(Lease lease) {
		int result = lDao.insertLease(session, lease);
		return result;
	}




	public int getTotalCount() {
		int totalCount = lDao.getTotalCount(session);
		return totalCount;
	}




	public List<User> selectListAll(int currentPage) {
		List<User> lList = lDao.selectList(session, currentPage);
		return lList;
	}





	
	
	
	
	
}

package com.library.lease.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.library.lease.model.vo.Lease;
import com.library.lease.model.vo.SearchVo;
import com.library.user.model.vo.User;

public class LeaseDAO {

	public LeaseDAO() {}
	
	
	
	public List<Lease> selectLeaseList(SqlSession session) {
		List<Lease>lList =  session.selectList("leaseList.selectLeaseList", session);
		return lList;
	}
	
	public List<Lease> selectLeaseList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Lease>lList =  session.selectList("leaseList.selectLeaseList",null, rowBounds);
		//System.out.println(lList);
		return lList;
	}
	

	public List<Lease> searchOneByCondition(SqlSession session, SearchVo search) {
		List<Lease>lList = session.selectList("leaseList.searchOneByCondition", search);
		return lList;
	}



	public int insertLease(SqlSession session, Lease lease) {
		int result = session.insert("leaseList.insertLease", lease);
		System.out.println(result);
		return result;
	}



	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("leaseList.getTotalCount");
		return totalCount;
	}



	public List<User> selectList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<User> lList = session.selectList("leaseList.selectList", null, rowBounds);
		return lList;
	}

}

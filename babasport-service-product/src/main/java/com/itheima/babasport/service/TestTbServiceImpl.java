package com.itheima.babasport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.babasport.dao.TestTbDao;
import com.itheima.babasport.pojo.TestTb;


@Service("testTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService {
	
	@Autowired
	private TestTbDao testTbDao;
	
	@Override
	public void insertTestTb(TestTb testTb) {

		testTbDao.insertTestTb(testTb);
		
//		throw new RuntimeException();
	}
	
}

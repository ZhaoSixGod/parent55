package com.itheima;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.babasport.dao.TestTbDao;
import com.itheima.babasport.pojo.TestTb;
import com.itheima.babasport.service.TestTbService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class TestTestTb {
	
	@Autowired
//	private TestTbDao testTbDao;
	private TestTbService testTbService;
	
	@Test
	public void testAdd() throws Exception{
		TestTb testTb=new TestTb();
		testTb.setId(5);
		testTb.setName("ajkjka");
		testTb.setBirthday(new Date());
		testTbService.insertTestTb(testTb);
	}
}

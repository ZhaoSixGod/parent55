package com.itheima.babasport.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.itheima.babasport.dao.product.ColorDao;
import com.itheima.babasport.pojo.product.Color;
import com.itheima.babasport.pojo.product.ColorQuery;

/**
 * 颜色管理
 * @author Administrator
 *
 */
@Service("colorService")
@Controller
public class ColorServiceImpl implements ColorService {
	
	@Autowired
	private ColorDao colorDao;
	
	//颜色结果集
	public List<Color> selectColorList(){
		ColorQuery colorQuery=new ColorQuery();
		colorQuery.createCriteria().andParentIdNotEqualTo(0L);
		return colorDao.selectByExample(colorQuery);
	}
}
